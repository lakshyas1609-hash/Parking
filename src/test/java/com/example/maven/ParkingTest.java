
package com.example.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    Parking parking = new Parking();

    @Test
    void testTwoWheelerOneHour() {
        assertEquals(10, parking.calculateFee("two-wheeler", 1));
    }
    

    @Test
    void testFourWheelerOneHour() {
        assertEquals(20, parking.calculateFee("four-wheeler", 1));
    }

    @Test
    void testTwoWheelerMultipleHours() {
        assertEquals(30, parking.calculateFee("two-wheeler", 3));
    }

    @Test
    void testFourWheelerMultipleHours() {
        assertEquals(60, parking.calculateFee("four-wheeler", 3));
    }

    @Test
    void testPartialHourRounding() {
        assertEquals(20, parking.calculateFee("two-wheeler", 1.5));
    }

    @Test
    void testZeroDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> parking.calculateFee("two-wheeler", 0));
    }

    @Test
    void testNegativeDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> parking.calculateFee("four-wheeler", -2));
    }

    @Test
    void testInvalidVehicleType() {
        assertThrows(IllegalArgumentException.class,
                () -> parking.calculateFee("bus", 2));
    }

    @Test
    void testNullVehicleType() {
        assertThrows(IllegalArgumentException.class,
                () -> parking.calculateFee(null, 2));
    }
}
