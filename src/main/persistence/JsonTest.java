package persistence;

// Method was taken from JsonTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.Bike;
import model.Run;
import model.Swim;
import model.Workout;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkSwimWorkout(String type, String name, String date, int avgHeartRate, int totalTime,
                                 int perceivedDifficulty, double distance, int avgSwimPace, Workout w) {

        assertEquals(type, w.getType());
        assertEquals(name, w.getName());
        assertEquals(date, w.getDate());
        assertEquals(avgHeartRate, w.getHeartRate());
        assertEquals(totalTime, w.getTotalTime());
        assertEquals(perceivedDifficulty, w.getPerceivedDifficulty());
        assertEquals(distance, w.getDistance());
        assertEquals(avgSwimPace, Swim.getAvgSwimPace());
    }

    protected void checkBikeWorkout(String type, String name, String date, int avgHeartRate, int totalTime,
                                    int perceivedDifficulty, double distance, double avgBikeSpeed, Workout w) {

        assertEquals(type, w.getType());
        assertEquals(name, w.getName());
        assertEquals(date, w.getDate());
        assertEquals(avgHeartRate, w.getHeartRate());
        assertEquals(totalTime, w.getTotalTime());
        assertEquals(perceivedDifficulty, w.getPerceivedDifficulty());
        assertEquals(distance, w.getDistance());
        assertEquals(avgBikeSpeed, Bike.getAvgBikeSpeed());

    }

    protected void checkRunWorkout(String type, String name, String date, int avgHeartRate, int totalTime,
                                   int perceivedDifficulty, double distance, int avgRunPaceMins, int avgRunPaceSecs,
                                   Workout w) {

        assertEquals(type, w.getType());
        assertEquals(name, w.getName());
        assertEquals(date, w.getDate());
        assertEquals(avgHeartRate, w.getHeartRate());
        assertEquals(totalTime, w.getTotalTime());
        assertEquals(perceivedDifficulty, w.getPerceivedDifficulty());
        assertEquals(distance, w.getDistance());
        assertEquals(avgRunPaceMins, Run.getAvgRunPaceMins());
        assertEquals(avgRunPaceSecs, Run.getAvgRunPaceSecs());
    }
}

