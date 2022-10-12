package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TrainingLog {


    //EFFECTS: creates a new empty training log
    public TrainingLog() {

        List<Workout> trainingLog = new ArrayList<Workout>();

    }

    // REQUIRES: workout is not null
    // MODIFIES: trainingLogName
    public void addWorkout(Workout workout, ArrayList<Workout> trainingLogName)  {

        trainingLogName.add(workout);

    }


}
