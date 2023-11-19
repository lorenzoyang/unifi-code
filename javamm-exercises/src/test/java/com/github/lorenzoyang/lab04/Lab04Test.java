package com.github.lorenzoyang.lab04;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lab04Test {
    private final Lab04 lab = new Lab04();

    @Test
    public void testIsSum() {
        assertTrue(lab.isSum(1, 2, 3));
        assertTrue(lab.isSum(3, 1, 2));
        assertFalse(lab.isSum(3, 2, 2));
    }

    @Test
    public void testLastDigit() {
        assertTrue(lab.lastDigit(23, 19, 13));
        assertFalse(lab.lastDigit(23, 19, 12));
        assertTrue(lab.lastDigit(23, 19, 3));
    }

    @Test
    public void testOrder() {
        assertTrue(lab.order(1, 2, 4, false));
        assertFalse(lab.order(1, 2, 1, false));
        assertTrue(lab.order(1, 1, 2, true));
    }

    @Test
    public void testRange() {
        assertTrue(lab.range(5, 1, 10, false));
        assertFalse(lab.range(11, 1, 10, false));
        assertTrue(lab.range(11, 1, 10, true));
    }

    @Test
    public void testSix() {
        assertTrue(lab.six(6, 4));
        assertFalse(lab.six(4, 5));
        assertTrue(lab.six(1, 5));
    }
}
