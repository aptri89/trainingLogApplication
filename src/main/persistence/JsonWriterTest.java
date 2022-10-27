package persistence;

// Method was taken from JsonWriterTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Before
    private void runBefore() {
        ArrayList<Workout> testLog = new ArrayList<>();
        Swim testSwim = new Swim("Swim", "name", "October25,2022", 120, 45,
                100, 6, 3.5);
        Bike testBike = new Bike("Bike", "name", "October25,2022", 140, 45,
                25, 4, 20);
    }


    @Test
    void testWriterInvalidFile() {
        try {
            ArrayList<Workout> testLog = new ArrayList<>();
            Swim testSwim = new Swim("Swim", "name", "October25,2022", 120, 45,
                    100, 6, 3.5);
            Bike testBike = new Bike("Bike", "name", "October25,2022", 140, 45,
                    25, 4, 20);
            testLog.add(testSwim);
            testLog.add(testBike);
            TrainingLog tl = new TrainingLog("testTl", testLog);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTrainingLog() {
        try {
            ArrayList<Workout> testLog = new ArrayList<>();
            TrainingLog tl = new TrainingLog("testTl", testLog);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTrainingLog.json");
            writer.open();
            writer.write(tl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTrainingLog.json");
            tl = reader.read();
            assertEquals("testTl", tl.getTitle());
            assertEquals(0, tl.getTrainingLog());
        } catch (IOException e) {
            fail("Exception should not have been thrown!");
        }
    }

    @Test
    void testWriterGeneralTrainingLog() {
        try {
            ArrayList<Workout> testLog = new ArrayList<>();
            Swim testSwim = new Swim("Swim", "name", "October25,2022", 120, 45,
                    100, 6, 3.5);
            Bike testBike = new Bike("Bike", "name", "October25,2022", 140, 45,
                    25, 4, 20);
            Run testRun = new Run("Run", "name", "October25,2022", 150, 5,
                    4, 46, 5, 6);
            testLog.add(testSwim);
            testLog.add(testBike);
            testLog.add(testRun);
            TrainingLog tl = new TrainingLog("testTl", testLog);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTrainingLog.json");
            writer.open();
            writer.write(tl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTrainingLog.json");
            tl = reader.read();
            assertEquals("testTl", tl.getTitle());
            List<Workout> workouts = tl.getTrainingLog();
            assertEquals(2, workouts.size());
            checkWorkoutUsingCorrectParamsBasedOnType(workouts.get(0));
            checkWorkoutUsingCorrectParamsBasedOnType(workouts.get(1));
            checkWorkoutUsingCorrectParamsBasedOnType(workouts.get(2));
        } catch (IOException e) {
            fail("Exception should not have been thrown!");
        }
    }

    private boolean checkWorkoutUsingCorrectParamsBasedOnType(Workout w) {
        if (w.getType() == "Swim") {
            checkSwimWorkout(w.getType(), w.getName(), w.getDate(), w.getHeartRate(), w.getTotalTime(),
                    w.getPerceivedDifficulty(), w.getDistance(), Swim.getAvgSwimPace(), w);
            return true;
        } else if (w.getType() == "Bike") {
            checkBikeWorkout(w.getType(), w.getName(), w.getDate(), w.getHeartRate(), w.getTotalTime(),
                    w.getPerceivedDifficulty(), w.getDistance(), Bike.getAvgBikeSpeed(),
                    w);
            return true;
        } else if (w.getType() == "Run") {
            checkRunWorkout(w.getType(), w.getName(), w.getDate(), w.getHeartRate(), w.getTotalTime(),
                    w.getPerceivedDifficulty(), w.getDistance(), Run.getAvgRunPaceMins(), Run.getAvgRunPaceSecs(),
                    w);
            return true;
        }


        return true;
    }

}

