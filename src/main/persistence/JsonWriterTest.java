package persistence;

// Method was taken from JsonWriterTest in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.TrainingLog;
import model.Workout;
import org.junit.Test;

import java.util.ArrayList;

public class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
//        try {
//            ArrayList<Workout> testLog = new ArrayList<>();
//            TrainingLog tl = new TrainingLog("testTl", testLog);
//        }
    }

    @Test
    void testWriterEmptyTrainingLog() {
       //stub
    }

    @Test
    void testWriterGeneralTrainingLog() {
        //stub
    }

}
