package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;
import io.javalin.core.validation.Validator;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        Validator<String> firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                .check(fn -> !fn.isEmpty(), "Имя не должно быть пустым");
        Validator<String> lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                .check(fn -> !fn.isEmpty(), "Фамилия не должна быть пустой");
        Validator<String> emailValidator = ctx.formParamAsClass("email", String.class)
                .check(email -> EmailValidator.getInstance().isValid(email), "email должен быть корректным");
        Validator<String> passwordValidator = ctx.formParamAsClass("password", String.class)
                .check(password -> StringUtils.isNumeric(password)
                        , "Пароль должен содержать только цифры")
                .check(password -> password.length() > 3, "Пароль должен быть не короче 4 символов");
        Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                firstNameValidator,
                lastNameValidator,
                emailValidator,
                passwordValidator
                );
        // Если данные не валидные
        if (!errors.isEmpty()) {
            // Устанавливаем код ответа
            ctx.status(422);
            // Передаем ошибки и данные компании
            ctx.attribute("errors", errors);
            User invalidUser = new User(
                    ctx.formParamAsClass("firstName", String.class).getOrDefault(null),
                    ctx.formParamAsClass("lastName", String.class).getOrDefault(null),
                    ctx.formParamAsClass("email", String.class).getOrDefault(null),
                    ctx.formParamAsClass("password", String.class).getOrDefault(null)
                    );
            ctx.attribute("user", invalidUser);
            ctx.render("users/new.html");
        } else {
            User user = new User(
                    ctx.formParamAsClass("firstName", String.class).getOrDefault(null),
                    ctx.formParamAsClass("lastName", String.class).getOrDefault(null),
                    ctx.formParamAsClass("email", String.class).getOrDefault(null),
                    ctx.formParamAsClass("password", String.class).getOrDefault(null)
            );
            user.save();
            ctx.attribute("flash", "Пользователь создан успешно");
            ctx.redirect("/users");
        }
        // END
    };
}
