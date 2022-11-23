package model;

// Method taken from Workroom in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.ArrayList;

public class TrainingLog implements Writable {

    String title;
    ArrayList<Workout> trainingLog;



    //EFFECTS: creates a new empty training log
    public TrainingLog(String title, ArrayList<Workout> listOfWorkoutForLog) {
        this.title = title;
        this.trainingLog = listOfWorkoutForLog;

    }

    // REQUIRES: workout is not null
    // MODIFIES: TrainingLog
    public void addWorkout(Workout workout, ArrayList<Workout> trainingLogName)  {

        trainingLogName.add(workout);
        EventLog.getInstance().logEvent(new Event(workout.getType() + " workout added to training log!"));
    }

    // REQUIRES: title is not an empty string, tl is not an empty list
    // EFFECTS: returns a list of workouts that have a name equal to title
    public static ArrayList<Workout> workoutsContainingTitle(String title, ArrayList<Workout> tl) {
        ArrayList<Workout> specificLog = new ArrayList<>();
        for (Workout w: tl) {
            if (w.getName().contains(title)) {
                specificLog.add(w);
            }
        }
        return specificLog;
    }

    // EFFECTS: returns a list of the workouts contained in this training log that have the specified type
    public ArrayList<Workout> getWorkoutsWithType(String type) {
        ArrayList<Workout> workoutsMatchingType = new ArrayList<>();
        for (Workout w : this.trainingLog) {
            if (w.getType().equals(type)) {
                workoutsMatchingType.add(w);
            }
        }
        EventLog.getInstance().logEvent(new Event("Filtered workouts by: " + type + "."));
        return workoutsMatchingType;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Workout> getTrainingLog() {
        return trainingLog;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("trainingLog", workoutsToJson());
        EventLog.getInstance().logEvent(new Event("Saved training log " + title + " to file."));
        return json;
    }

    // EFFECTS: returns workouts in this TrainingLog as a JSON array
    private JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : trainingLog) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }

}
