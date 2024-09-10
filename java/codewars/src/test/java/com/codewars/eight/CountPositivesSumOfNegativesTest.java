package com.codewars.eight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPositivesSumOfNegativesTest {

    @Test
    void testCountPositivesSumNegatives() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult,CountPositivesSumOfNegatives.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }
}