package com.codewars.seven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurviveTheAttackTest {

    @Test
    void testBlock() {
        assertEquals(true, SurviveTheAttack.block(new int[] { 1, 3, 5, 7 }, new int[] { 2, 4, 6, 8 }));
        assertEquals(false, SurviveTheAttack.block(new int[] { 2, 9, 9, 7 }, new int[] { 1, 1, 3, 8 }));
        assertEquals(true, SurviveTheAttack.block(new int[] { 10, 10, 1, 1 }, new int[] { 4, 4, 7, 7 }));
        assertEquals(true, SurviveTheAttack.block(new int[] { }, new int[] { 1,2,3 }));
        assertEquals(false, SurviveTheAttack.block(new int[] {1,2,3 }, new int[] { }));
    }
}
