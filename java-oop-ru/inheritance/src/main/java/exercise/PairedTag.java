package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> child;

    PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> child) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.body = body;
        this.child = child;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<" + tagName);
        for (Map.Entry<String, String> element : attributes.entrySet()) {
            stringBuilder.append(" " + element.getKey() + "=");
            stringBuilder.append("\"" + element.getValue() + "\"");
        }
        stringBuilder.append(">");
        for (Tag element : child) {
            stringBuilder.append(element.toString());
        }
        stringBuilder.append(body);
        stringBuilder.append("</" + tagName + ">");
//        return "<" + tagName + " " + attributes + ">" + child +  "</" + tagName;
        return stringBuilder.toString();
    }
}
// END
