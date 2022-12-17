package exercise.controller;

import exercise.model.User;
//import exercise.model.QUser;
//import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import com.querydsl.core.types.Predicate;

import java.util.List;

// Зависимости для самостоятельной работы

@RestController
@RequestMapping("/users")
public class UsersController {

//    @Autowired
//    private UserRepository userRepository;

    // BEGIN

//    @GetMapping("")
//    public List<User> users(
//            @RequestParam(name = "firstName", required = false) String firstname,
//            @RequestParam(name = "lastName", required = false) String lastName
//    ) {
//
//        userRepository.findAll();
//    }
    // END
}

