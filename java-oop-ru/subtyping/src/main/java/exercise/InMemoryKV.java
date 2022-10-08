package exercise;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dictionary = new HashMap<>();

    public InMemoryKV(Map<String, String> dictionary) {
        this.dictionary.putAll(dictionary);
    }

    @Override
    public void set(String key, String value) {
        this.dictionary.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.dictionary.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.dictionary.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dictionary);
    }
}
// END
