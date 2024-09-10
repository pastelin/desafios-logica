package com.codewars.seven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsonantsTest {

    @Test
    void testGetCount() {
        assertEquals(0,Consonants.getCount(""));
        assertEquals(0,Consonants.getCount("aaaaa"));
        assertEquals(2,Consonants.getCount("XaeiouX"));
        assertEquals(5,Consonants.getCount("Bbbbb"));
        assertEquals(7,Consonants.getCount("helLo world"));
        assertEquals(7,Consonants.getCount("h^$&^#$&^elLo world"));
        assertEquals(2,Consonants.getCount("012345_Cb"));
        assertEquals(0,Consonants.getCount("0123456789"));

        assertEquals(0,Consonants.getCountOptimized(""));
        assertEquals(0,Consonants.getCountOptimized("aaaaa"));
        assertEquals(2,Consonants.getCountOptimized("XaeiouX"));
        assertEquals(5,Consonants.getCountOptimized("Bbbbb"));
        assertEquals(7,Consonants.getCountOptimized("helLo world"));
        assertEquals(7,Consonants.getCountOptimized("h^$&^#$&^elLo world"));
        assertEquals(2,Consonants.getCountOptimized("012345_Cb"));
        assertEquals(0,Consonants.getCountOptimized("0123456789"));
    }

}