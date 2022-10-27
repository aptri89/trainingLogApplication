package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTest {

    private Run testRun;

    @BeforeEach
    void runBefore() {testRun = new Run("Run", "TrackRun", "October15,2022", 160,
            4, 45, 51, 9, 10);
    }

    @Test
    public void testRunConstructor() {

        assertEquals("TrackRun", testRun.getName());
        assertEquals("October15,2022", testRun.getDate());
        assertEquals(160, testRun.getHeartRate());
        assertEquals(4, testRun.getAvgRunPaceMins());
        assertEquals(45, testRun.getAvgRunPaceSecs());
        assertEquals(51, testRun.getTotalTime());
        assertEquals(9, testRun.getPerceivedDifficulty());
        assertEquals(10, testRun.getDistance());

    }

    @Test
    public void testGetCompleteRunPace() {
        assertEquals("4:45",
                testRun.getCompleteRunPace(testRun.getAvgRunPaceMins(), testRun.getAvgRunPaceSecs()));
    }

    @Test
    public void testRunSetters() {
        testRun.changeRunPaceMins(5);
        assertEquals(5, testRun.getAvgRunPaceMins());

        testRun.changeRunPaceSecs(4);
        assertEquals(4, testRun.getAvgRunPaceSecs());
    }



}
