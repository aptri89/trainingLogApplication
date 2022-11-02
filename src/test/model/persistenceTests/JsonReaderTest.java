package model.persistenceTests;

// Method was taken from JsonReaderTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.*;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TrainingLog tl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    public void testReaderEmptyTrainingLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrainingLog.json");
        try {
            TrainingLog tl = reader.read();
            assertEquals("testTl", tl.getTitle());
            assertEquals(0, tl.getTrainingLog().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralTrainingLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrainingLog.json");
        try {
            TrainingLog tl = reader.read();
            assertEquals("testTl", tl.getTitle());
            List<Workout> workouts = tl.getTrainingLog();
            assertEquals(3, workouts.size());
            checkSwimWorkout("Swim", "name", "October25,2022", 120, 45,
                    6, 3.5, 100, workouts.get(0));
            checkBikeWorkout("Bike", "name", "October25,2022", 140, 45,
                    4, 20, 25, workouts.get(1));
            checkRunWorkout("Run", "name", "October25,2022", 150, 46,
                    5, 6, 5, 4, workouts.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");

        }

    }

}



