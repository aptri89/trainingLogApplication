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
        listOfWorkoutsForLog.add(testSwimWorkout);
        listOfWorkoutsForLog.add(testBikeWorkout);
        listOfWorkoutsForLog.add(testRunWorkout);
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

    @Test
    public void testAddWorkoutMultipleTimes() {
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testBikeWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testRunWorkout, listOfWorkoutsForLog);
        assertEquals(3, listOfWorkoutsForLog.size());
        assertEquals(testSwimWorkout, listOfWorkoutsForLog.get(0));
        assertEquals(testBikeWorkout, listOfWorkoutsForLog.get(1));
        assertEquals(testRunWorkout, listOfWorkoutsForLog.get(2));
    }


    @Test
    public void testGetWorkoutsContainingTitle() {
        String title = "Test";
        assertEquals(2, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).size());
        assertEquals(testSwimWorkout, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).get(0));
        assertEquals(testBikeWorkout, testTrainingLog.workoutsContainingTitle(title, listOfWorkoutsForLog).get(1));


    }



}
