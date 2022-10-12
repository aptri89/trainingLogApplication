package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BikeTest {

    private Bike testBike;

    @BeforeEach
    void runBefore() {testBike = new Bike("VO2 Max Session", "October 12, 2022", 154,
            75, 27, 8, 40);
    }

    public void testBikeConstructor() {

        assertEquals("VO2 Max Session", testBike.getName());
        assertEquals("October 12, 2022", testBike.getDate());
        assertEquals(154, testBike.getHeartRate());
        assertEquals(75, testBike.getAvgBikeSpeed());

    }
}
