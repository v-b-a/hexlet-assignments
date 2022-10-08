package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> before, Map<String, Object> after) {
        LinkedHashMap<String, String> diff = new LinkedHashMap<>();
        for (HashMap.Entry<String, Object> valueAfter : after.entrySet()) {
            if(before.containsKey(valueAfter.getKey()) && after.containsKey(valueAfter.getKey())) {
                if(before.containsValue(valueAfter.getValue())) {
                    diff.put(valueAfter.getKey(), "unchanged");
                } else {
                    diff.put(valueAfter.getKey(), "changed");
                }
            } else {
                if(!before.containsKey(valueAfter.getKey())) {
                    diff.put(valueAfter.getKey(), "added");
                }
            }
        }
        for (HashMap.Entry<String, Object> valueBefore : before.entrySet()) {
            if (!after.containsKey(valueBefore.getKey())) {
                diff.put(valueBefore.getKey(), "deleted");
            }
        }
        return diff.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new,
                        (m, c) -> m.put(c.getKey(), c.getValue()),
                        LinkedHashMap::putAll);
    }
}
//END
