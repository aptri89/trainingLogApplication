package persistence;

// Method was taken from JsonWriterTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.



    @Test
    public void testWriterInvalidFile() {
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
    public void testWriterEmptyTrainingLog() {
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
            assertEquals(0, tl.getTrainingLog().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown!");
        }
    }

    @Test
    public void testWriterGeneralTrainingLog() {
        try {
            ArrayList<Workout> testLog = new ArrayList<>();
            Swim testSwim = new Swim("Swim", "name", "October25,2022", 120, 45,
                    100, 6, 3.5);
            Bike testBike = new Bike("Bike", "name", "October25,2022", 140, 45,
                    25, 4, 20);
            Run testRun = new Run("Run", "name", "October25,2022", 150, 5,
                    4, 46, 5, 6);
            TrainingLog tl = new TrainingLog("testTl", testLog);
            tl.getTrainingLog().add(testSwim);
            tl.getTrainingLog().add(testBike);
            tl.getTrainingLog().add(testRun);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTrainingLog.json");
            writer.open();
            writer.write(tl);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterGeneralTrainingLog.json");
            tl = reader.read();
            testWriterGeneralTrainingLogHelper(tl, testSwim, testBike, testRun);
        } catch (IOException e) {
            fail("Exception should not have been thrown!");
        }
    }


    public void testWriterGeneralTrainingLogHelper(TrainingLog tl, Swim s, Bike b, Run r) {

        assertEquals("testTl", tl.getTitle());
        assertEquals(3, tl.getTrainingLog().size());

        checkSwimWorkout("Swim", "name", "October25,2022", 120, 45,
                6, 3.5, 100, s);
        checkBikeWorkout("Bike", "name", "October25,2022", 140, 45, 4,
                20, 25, b);
        checkRunWorkout("Run", "name", "October25,2022", 150, 46, 5,
                6, 5, 4, r);
    }


}




