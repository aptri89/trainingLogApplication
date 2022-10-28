package persistence;

// Method was taken from JsonTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.Bike;
import model.Run;
import model.Swim;
import model.Workout;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    protected void checkWorkout(String type, String name, String date, int avgHeartRate, int totalTime,
                                 int perceivedDifficulty, double distance, int avgSwimPace,
                                double avgBikeSpeed, int avgRunPaceMins, int avgRunPaceSecs, Workout w) {

        assertEquals(type, w.getType());
        assertEquals(name, w.getName());
        assertEquals(date, w.getDate());
        assertEquals(avgHeartRate, w.getHeartRate());
        assertEquals(totalTime, w.getTotalTime());
        assertEquals(perceivedDifficulty, w.getPerceivedDifficulty());
        assertEquals(distance, w.getDistance());
        assertEquals(avgSwimPace, w.getSwimPaceFromSwim());
        assertEquals(avgBikeSpeed, w.getBikeSpeedFromBike());
        assertEquals(avgRunPaceMins, w.getAvgRunPaceMinsFromRun());
        assertEquals(avgRunPaceSecs, w.getAvgRunPaceSecsFromRun());




    }
}
