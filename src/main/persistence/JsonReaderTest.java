package persistence;

import model.TrainingLog;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TrainingLog tl = reader.read();
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyTrainingLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrainingLog.json");
//        try {
//
//        } catch (IOException) {
//
//        }
    }

    @Test
    void testReaderGeneralTrainingLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTrainingLog.json");

    }
}
