package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrainingLogTest {

    private TrainingLog testTrainingLog;
    private ArrayList<Workout> listOfWorkoutsForLog;
    private Swim testSwimWorkout = new Swim("Test Swim", "October 15, 2022", 123,
            51, 120, 4, 2.3);
    private Bike testBikeWorkout = new Bike ("Test Bike", "October 17, 2022", 145,
            120, 25, 8, 78);
    private Run testRunWorkout = new Run ("Speed Work", "October 24, 2022", 156, 4,
            34, 46, 9, 10);
    private ArrayList<Workout> listOfWorkoutsForLogContainingTestTitle;


    @BeforeEach
    void runBefore() {
        testTrainingLog = new TrainingLog("October 17-23, 2022", listOfWorkoutsForLog);
    }

    @Test
    public void testTrainingLogConstructor() {
        assertEquals("October 17-23, 2022", testTrainingLog.getTitle());
        assertEquals(listOfWorkoutsForLog, testTrainingLog.getTrainingLog());

    }

    @Test
    public void testAddWorkout() {
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        assertEquals(1, listOfWorkoutsForLog.size());
        assertEquals(testSwimWorkout, listOfWorkoutsForLog.get(0));

    }

    // fix this test, so confused
    @Test
    public void testGetWorkoutsContainingTitle() {
        String title = "Test";
        testTrainingLog.workoutsContainingTitle(title, )
        ArrayList<Workout> testListWorkoutsForLog = new ArrayList<Workout>();
        testListWorkoutsForLog.add(testSwimWorkout);
        testListWorkoutsForLog.add(testBikeWorkout);

    }



}
