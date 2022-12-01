package persistence;

// Method was taken from JsonReader in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        ArrayList<Workout> newLog = new ArrayList<>();
        String title = jsonObject.getString("title");
        TrainingLog tl = new TrainingLog(title, newLog);
        addWorkouts(tl, jsonObject);
        EventLog.getInstance().logEvent(new Event("Loaded training log: " + tl.getTitle() + " from file."));
        return tl;
    }

    // MODIFIES: tl
    // EFFECTS: parses thingies from JSON object and adds them to TrainingLog
    private void addWorkouts(TrainingLog tl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("trainingLog");
        for (Object json: jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addWorkout(tl, nextWorkout);
        }
    }

    // Note: TA suppressed warnings while grading my phase 2 and did not tell me to change it so that is why I have
    // suppressed warnings for this method (there also doesn't seem to be a sensible way to modify it).

    // MODIFIES: tl
    // EFFECTS: converts jsonObject to Workout and adds to tl
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addWorkout(TrainingLog tl, JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        String name = jsonObject.getString("name");
        String date = jsonObject.getString("date");
        int avgHeartRate = jsonObject.getInt("avgHeartRate");
        int totalTime = jsonObject.getInt("totalTime");
        int perceivedDifficulty = jsonObject.getInt("perceivedDifficulty");
        int distance = jsonObject.getInt("distance");

        if (type.equals("Swim")) {
            int avgSwimPace = jsonObject.getInt("avgSwimPace");
            Swim swim = new Swim(type, name, date, avgHeartRate, totalTime,
                    avgSwimPace, perceivedDifficulty, distance);
            tl.getTrainingLog().add(swim);
        } else if (type.equals("Bike")) {
            int avgBikeSpeed = jsonObject.getInt("avgBikeSpeed");
            Bike bike = new Bike(type, name, date, avgHeartRate, totalTime,
                    avgBikeSpeed, perceivedDifficulty, distance);
            tl.getTrainingLog().add(bike);
        } else {
            int avgRunPaceMins = jsonObject.getInt("avgRunPaceMins");
            int avgRunPaceSecs = jsonObject.getInt("avgRunPaceSecs");
            Run run = new Run(type, name, date, avgHeartRate, avgRunPaceMins,
                    avgRunPaceSecs, totalTime, perceivedDifficulty, distance);
            tl.getTrainingLog().add(run);
        }

    }


}

