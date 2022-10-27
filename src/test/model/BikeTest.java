package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BikeTest {

    private Bike testBike;

    @BeforeEach
    void runBefore() {testBike = new Bike("Bike", "VO2MaxSession", "October12,2022", 154,
            75, 27, 8, 40);
    }

    @Test
    public void testBikeConstructor() {

        assertEquals("VO2MaxSession", testBike.getName());
        assertEquals("October12,2022", testBike.getDate());
        assertEquals(154, testBike.getHeartRate());
        assertEquals(75, testBike.getTotalTime());
        assertEquals(27, testBike.getAvgBikeSpeed());
        assertEquals(8, testBike.getPerceivedDifficulty());
        assertEquals(40, testBike.getDistance());

    }

    @Test
    public void testChangeBikeSpeed() {

        testBike.changeBikeSpeed(22);
        assertEquals(22, testBike.getAvgBikeSpeed());
    }
}
