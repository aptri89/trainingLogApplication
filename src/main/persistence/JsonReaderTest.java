package persistence;

// Method was taken from JsonReaderTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.TrainingLog;
import model.Workout;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TrainingLog tl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyTrainingLog() {
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
    void testReaderGeneralTrainingLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrainingLog.json");
        // stub

        }

    }

