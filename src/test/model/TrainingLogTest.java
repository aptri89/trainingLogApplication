package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrainingLogTest {

    private TrainingLog testTrainingLog;
    private ArrayList<Workout> listOfWorkoutsForLog = new ArrayList<Workout>();
    private Swim testSwimWorkout = new Swim("Swim", "TestSwim", "October15,2022", 123,
            51, 120, 4, 2.3);
    private Bike testBikeWorkout = new Bike ("Bike", "TestBike", "October17,2022", 145,
            120, 25, 8, 78);
    private Run testRunWorkout = new Run ("Run", "SpeedWork", "October24,2022", 156, 4,
            34, 46, 9, 10);
    private ArrayList<Workout> listOfWorkoutsForLogContainingTestTitle;

    @BeforeEach
    void runBefore() {
        testTrainingLog = new TrainingLog("October17-23,2022", listOfWorkoutsForLog);
        listOfWorkoutsForLog.add(testSwimWorkout);
        listOfWorkoutsForLog.add(testBikeWorkout);
        listOfWorkoutsForLog.add(testRunWorkout);
    }

    @Test
    public void testTrainingLogConstructor() {
        assertEquals("October17-23,2022", testTrainingLog.getTitle());
        assertEquals(listOfWorkoutsForLog, testTrainingLog.getTrainingLog());

    }

    @Test
    public void testAddWorkout() {
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.trainingLog.remove(0);
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        assertEquals(1, listOfWorkoutsForLog.size());
        assertEquals(testSwimWorkout, listOfWorkoutsForLog.get(0));

    }

    @Test
    public void testAddWorkoutMultipleTimes() {
        testTrainingLog.addWorkout(testSwimWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testBikeWorkout, listOfWorkoutsForLog);
        testTrainingLog.addWorkout(testRunWorkout, listOfWorkoutsForLog);
        assertEquals(6, listOfWorkoutsForLog.size());
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

    @Test
    public void testEventMessageForFilter() {
        // stub
    }

    @Test
    public void testEventMessageForAddWorkout() {
        // stub
    }

    @Test
    public void testEventMessageForSavingLog() {
        // stub
    }

    @Test
    public void testEventMessageForLoadingLog() {
        // stub
    }





}
