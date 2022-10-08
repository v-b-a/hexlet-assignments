package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {

    public static void save(Path filePath, Car instance) throws Exception {
        String jsonRepresentation = instance.serialize();
        Files.writeString(filePath, jsonRepresentation, StandardCharsets.UTF_8);
    }

    public static Car extract(Path filePath) throws Exception {
        String jsonRepresentation = Files.readString(filePath);
        Car instance = Car.unserialize(jsonRepresentation);
        return instance;
    }
}
// END
