package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        if (letters.length() == 0 || word.length() == 0) {
            return false;
        }
        List<String> lettersArray = new ArrayList<>(Arrays.asList(letters.split("")));
        String[] arrayWord = word.toLowerCase().split("");
        StringBuilder builder = new StringBuilder();


        for (String s : arrayWord) {
            for (int j = 0; j < lettersArray.size(); j++) {
                if (s.equals(lettersArray.get(j))) {
                    lettersArray.remove(j);
                    builder.append(s);
                    break;
                }
            }
        }
        return builder.toString().equals(word.toLowerCase());
    }
}
//END
