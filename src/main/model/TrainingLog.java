package model;


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
    }

    // REQUIRES: title is not an empty string, tl is not an empty list
    // EFFECTS: returns a list of workouts that have a name equal to title
    public static ArrayList<Workout> workoutsContainingTitle(String title, ArrayList<Workout> tl) {
        ArrayList<Workout> specificLog = new ArrayList<>();
        for (Workout w: tl) {
            if (w.getTitle().contains(title)) {
                specificLog.add(w);
            }
        }
        return specificLog;
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


        return json;
    }

}
