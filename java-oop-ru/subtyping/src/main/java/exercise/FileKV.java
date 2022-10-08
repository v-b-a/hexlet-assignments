package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String filepath;

    FileKV(String filepath, Map<String, String> initialMap) {
        this.filepath = filepath;
        initialMap.entrySet().stream()
                .forEach(entry -> set(entry.getKey(), entry.getValue()));
//        Utils.writeFile(this.filepath, Utils.serialize(initialMap));
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(filepath);
        Map<String, String> map4 = Utils.unserialize(content);
        map4.put(key, value);
        Utils.writeFile(this.filepath, Utils.serialize(map4));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(filepath);
        Map<String, String> map4 = Utils.unserialize(content);
        map4.remove(key);
        Utils.writeFile(this.filepath, Utils.serialize(map4));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(filepath);
        Map<String, String> map4 = Utils.unserialize(content);
        return map4.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(filepath);
        Map<String, String> map4 = Utils.unserialize(content);
        return map4;
    }
}
// END
