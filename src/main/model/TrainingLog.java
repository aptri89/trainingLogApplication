package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TrainingLog {


    //EFFECTS: creates a new empty training log
    public TrainingLog() {
       ArrayList<Workout> trainingLog = new ArrayList<Workout>();
    }

    // REQUIRES: workout is not null
    // MODIFIES: TrainingLog
    public void addWorkout(Workout workout, ArrayList<Workout> trainingLogName)  {
        trainingLogName.add(workout);
    }

    // REQUIRES: title is not an empty string, tl is not an empty list
    // EFFECTS: returns a list of workouts that have a name equal to title
    public ArrayList<Workout> workoutsWithTitle(String title, ArrayList<Workout> tl) {
        ArrayList<Workout> specificLog = new ArrayList<Workout>();
        for (Workout w: tl) {
            if (w.getName().contains(title)) {
                specificLog.add(w);
            }
        }
        return specificLog;
    }


}
