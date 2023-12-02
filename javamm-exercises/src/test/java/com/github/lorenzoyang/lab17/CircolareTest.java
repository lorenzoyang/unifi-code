package com.github.lorenzoyang.lab17;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircolareTest {
    private final Circolare test = new Circolare();

    @Test
    public void test1() {
        char[][] m = {
                {'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'B', 'S', 'S', 'S', 'S'}
        };
        assertTrue(test.circolare(m));
    }

    @Test
    public void test2() {
        char[][] m = {
                {'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'B', 'S', 'S', 'S', 'S'},
                {'B', 'S', 'S', 'S', 'S'}
        };
        assertFalse(test.circolare(m));
    }

    @Test
    public void test3() {
        char[][] m = {
                {'B', 'B', 'D', 'D'},
                {'B', 'D', 'D', 'B'},
                {'D', 'B', 'B', 'S'}
        };
        assertTrue(test.circolare(m));
    }
}
