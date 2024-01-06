package com.codewars.seven.katas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearsTest {

    @Test
    void isLeapYear() {
        assertEquals(true, LeapYears.isLeapYear(2020));
        assertEquals(true, LeapYears.isLeapYear(2000));
        assertEquals(false, LeapYears.isLeapYear(2015));
        assertEquals(false, LeapYears.isLeapYear(2100));

    }
}
