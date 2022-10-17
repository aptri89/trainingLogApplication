package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WorkoutTest {

    private Workout testWorkout;

    @BeforeEach
    void runBefore() {
        testWorkout = new Workout("Testing", "September 14, 2022", 100,
                25, 3, 1);
    }

    @Test
    public void testWorkoutConstructor() {
        assertEquals("Testing", testWorkout.getTitle());
        assertEquals("September 14, 2022", testWorkout.getDate());
        assertEquals(100, testWorkout.getHeartRate());
        assertEquals(25, testWorkout.getTotalTime());
        assertEquals(3, testWorkout.getPerceivedDifficulty());
        assertEquals(1, testWorkout.getDistance());

    }

    @Test
    public void testCalcTrainingLoadValue() {
        int testTrainingLoadValue = (testWorkout.getPerceivedDifficulty() * testWorkout.getTotalTime());
        assertEquals(testTrainingLoadValue,
                testWorkout.calcTrainingLoadValue(testWorkout.getPerceivedDifficulty(), testWorkout.getTotalTime()));
    }
}
