package com.github.lorenzoyang.lab05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lab05Test {
    private final Lab05 lab05 = new Lab05();

    @Test
    public void testLoneSum() {
        assertEquals(6, lab05.loneSum(1, 2, 3));
        assertEquals(2, lab05.loneSum(3, 2, 3));
        assertEquals(0, lab05.loneSum(3, 3, 3));
    }

    @Test
    public void testNoTeenSum() {
        assertEquals(6, lab05.noTeenSum(1, 2, 3));
        assertEquals(3, lab05.noTeenSum(2, 13, 1));
        assertEquals(3, lab05.noTeenSum(2, 1, 14));
        assertEquals(18, lab05.noTeenSum(2, 1, 15));
    }

    @Test
    public void testRoundSum() {
        assertEquals(60, lab05.roundSum(16, 17, 18));
        assertEquals(30, lab05.roundSum(12, 13, 14));
        assertEquals(10, lab05.roundSum(6, 4, 4));
        assertEquals(0, lab05.roundSum(4, 4, 4));
    }


    @Test
    public void testEvenlySpaced() {
        assertTrue(lab05.evenlySpaced(2, 4, 6));
        assertTrue(lab05.evenlySpaced(4, 6, 2));
        assertFalse(lab05.evenlySpaced(4, 6, 3));
        assertFalse(lab05.evenlySpaced(4, 60, 9));
        assertTrue(lab05.evenlySpaced(79, 89, 99));
    }
}
