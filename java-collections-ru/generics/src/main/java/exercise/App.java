package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List findWhere(List<Map<String, String>> books, Map<String, String> book) {
        List<Map> matchList = new ArrayList<>();
        int countMatch;
        for (Map<String, String> stringStringMap : books) {
            countMatch = 0;
            for (Entry<String, String> parameterBooks : stringStringMap.entrySet()) {
                for (Entry<String, String> parameterBook : book.entrySet()) {
                    if (parameterBooks.equals(parameterBook)) {
                        countMatch++;
                    }
                }
            }
            if (countMatch == book.size()) {
                matchList.add(stringStringMap);
            }
        }
        return matchList;
    }
}

//END
