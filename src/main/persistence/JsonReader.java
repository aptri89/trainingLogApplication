package persistence;

// Method was taken from JsonReader in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.TrainingLog;
import model.Workout;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import model.Workout;
import org.json.*;


// Represents a reader that reads TrainingLog from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads TrainingLog from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TrainingLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTrainingLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TrainingLog from JSON object and returns it
    private TrainingLog parseTrainingLog(JSONObject jsonObject) {
        ArrayList<Workout> testList;
        testList = new ArrayList<>();
        TrainingLog tl = new TrainingLog("testLog", testList);
        return tl;
        //stub
    }

    // need two more methods here for converting still

}

