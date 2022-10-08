package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    String tagName;
    Map<String, String> attributes;
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<" + tagName);
        for (Map.Entry<String, String> element : attributes.entrySet()) {
            builder.append(" " + element.getKey() + "=");
            builder.append("\"" + element.getValue() + "\"");
        }
        builder.append(">");
        return builder.toString();
    };
}
// END
