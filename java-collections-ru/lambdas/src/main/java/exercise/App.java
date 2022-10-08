package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }

    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(array -> Arrays.stream(array).flatMap(includeArray -> Stream.of(includeArray, includeArray)).toArray(String[]::new))
                .flatMap(s -> Stream.of(s, s))
                .toArray(String[][]::new);
    }
}
// END
