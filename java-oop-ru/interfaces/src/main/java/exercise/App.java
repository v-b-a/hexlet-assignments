package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> apartments, int count) {
//        apartments.sort(Comparator.comparing(s -> s.getArea()));
//
//        List<Home> resultList = apartments.subList(0, count+1);
//        resultList.stream()
//                .map(s-> s.toString());
//        return resultList;
        return apartments.stream()
                .sorted(Comparator.comparing(s -> s.getArea()))
                .limit(count)
                .map(string -> string.toString())
                .collect(Collectors.toList());
    }
}
// END
