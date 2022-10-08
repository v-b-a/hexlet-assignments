package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> map) {
        this.tagName = tagName;
        this.attributes = map;
    }

    @Override
    public String toString() {
//        return super.toString();
        StringBuilder builder = new StringBuilder();
        builder.append("<" + tagName);
        for (Map.Entry<String, String> element : attributes.entrySet()) {
            builder.append(" " + element.getKey() + "=");
            builder.append("\"" + element.getValue() + "\"");
        }
        builder.append(">");
        return builder.toString();
    }

}
// END
