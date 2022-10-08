package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {


    public static String getForwardedVariables(String file) {
        String[] array = file.split("\n");
        return  Arrays.stream(array)
                .filter(x -> x.startsWith("environment"))
                .map(x-> x.substring(x.indexOf("=\"")+2, x.length()-1))
                .flatMap(x-> Stream.of(x.split(",")))
                .filter(x-> x.startsWith("X_FORWARDED"))
                .map(x-> x.substring(12))
                .collect(Collectors.joining(","));
    }
}
//END
