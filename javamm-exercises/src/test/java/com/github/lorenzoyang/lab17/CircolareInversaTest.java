package com.github.lorenzoyang.lab17;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CircolareInversaTest {
    private final Circolare test = new Circolare();

    @Test
    public void test1() {
        char[][] m = {
                {'A', 'S', 'A', 'S', 'A'},
                {'S', 'B', 'S', 'B', 'A'},
                {'A', 'D', 'D', 'D', 'D'}
        };
        assertTrue(test.circolareInversa(m));
    }
}
