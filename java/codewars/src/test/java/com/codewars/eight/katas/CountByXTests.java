package com.codewars.eight.katas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountByXTests {

    @Test
    void testCountByX() {
        assertEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, CountByX.countBy(1,10));
        assertEquals(new int[]{2,4,6,8,10}, CountByX.countBy(2,5));
    }
}
