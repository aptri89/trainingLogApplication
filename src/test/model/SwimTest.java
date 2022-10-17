package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwimTest {

    private Swim testSwim;

    @BeforeEach
    void runBefore() {testSwim = new Swim("EnduranceProgression", "October20,2022", 120,
            56, 100, 5, 3.5);
    }

    @Test
    public void testSwimConstructor() {

        assertEquals("EnduranceProgression", testSwim.getTitle());
        assertEquals("October20,2022", testSwim.getDate());
        assertEquals(120, testSwim.getHeartRate());
        assertEquals(56, testSwim.getTotalTime());
        assertEquals(100, testSwim.getAvgSwimPace());
        assertEquals(5, testSwim.getPerceivedDifficulty());
        assertEquals(3.5, testSwim.getDistance());

    }

    @Test
    public void testConvertSwimPaceToMinsAndSecs() {
        assertEquals("1:40", testSwim.convertSwimPaceToMinsAndSecs(testSwim.getAvgSwimPace()));

    }

    @Test
    public void testChangeSwimPace() {
        testSwim.changeSwimPace(120);
        assertEquals(120, testSwim.getAvgSwimPace());
    }


}
