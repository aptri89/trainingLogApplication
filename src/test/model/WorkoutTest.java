package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WorkoutTest {

    private Workout testWorkout;

    @BeforeEach
    void runBefore() {
        testWorkout = new Workout("Testing", "September14,2022", 100,
                25, 3, 1.5);
    }

    @Test
    public void testWorkoutConstructor() {
        assertEquals("Testing", testWorkout.getTitle());
        assertEquals("September14,2022", testWorkout.getDate());
        assertEquals(100, testWorkout.getHeartRate());
        assertEquals(25, testWorkout.getTotalTime());
        assertEquals(3, testWorkout.getPerceivedDifficulty());
        assertEquals(1.5, testWorkout.getDistance());

    }

    @Test
    public void testCalcTrainingLoadValue() {
        int testTrainingLoadValue = (testWorkout.getPerceivedDifficulty() * testWorkout.getTotalTime());
        assertEquals(testTrainingLoadValue,
                testWorkout.calcTrainingLoadValue(testWorkout.getPerceivedDifficulty(), testWorkout.getTotalTime()));
    }

    @Test
    public void testGetTrainingLoadValue() {
        testWorkout.calcTrainingLoadValue(testWorkout.getPerceivedDifficulty(), testWorkout.getTotalTime());
        assertEquals(75, testWorkout.getTrainingLoadValue());
    }

    @Test
    public void testChangeTitle() {
        String title = "ChangedTitle";
        testWorkout.changeTitle(title);
        assertEquals("ChangedTitle", testWorkout.getTitle());
    }

    @Test
    public void testChangeDate() {
        testWorkout.changeDate("September12,2022");
        assertEquals("September12,2022", testWorkout.getDate());

    }

    @Test
    public void testChangeDistance() {
        testWorkout.changeDistance(1.7);
        assertEquals(1.7, testWorkout.getDistance());
    }
}
