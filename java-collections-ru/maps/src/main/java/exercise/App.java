package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<>();
        if (sentence.length() == 0) {
            return wordsMap;
        }
        String[] wordsArray = sentence.split(" ");
        for (String word : wordsArray) {
            wordsMap.put(word, 0);
        }
        for (Map.Entry<String, Integer> value : wordsMap.entrySet()) {
            for(String word : wordsArray) {
                if(value.getKey().equals(word)) {
                    wordsMap.put(value.getKey(), value.getValue()+1);
                }
            }
        }
        return wordsMap;
    }
    public static String toString(Map<String, Integer> dict){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        if (dict.size() == 0) {
            builder.append("}");
            return  builder.toString();
        }
        for (Map.Entry<String, Integer> value : dict.entrySet()) {
            builder.append("\n  ").append(value.getKey()).append(": ").append(value.getValue());
        }
        builder.append("\n}");
        return builder.toString();
    }
}
//END
