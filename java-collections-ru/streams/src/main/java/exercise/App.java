package exercise;

import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> email) {
        return (int) email.stream()
                .filter(text -> StringUtils.isNotBlank(text))
                .filter(text -> text.endsWith("gmail.com") || text.endsWith("yandex.ru") || text.endsWith("hotmail.com"))
                .count();
    }
}
// END
