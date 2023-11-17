package com.github.lorenzoyang.lab10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBilanciamentoTest {
    private final TestBilanciamento test = new TestBilanciamento();

    @Test
    public void testTestBilanciamento() {
        assertTrue(test.testBilanciamento(new int[]{-4, -4}));
        assertTrue(test.testBilanciamento(new int[]{12, -3, 22, 7}));
        assertTrue(test.testBilanciamento(new int[]{-3, 4, 100, -13, 9, -104, -8, -1}));
        assertFalse(test.testBilanciamento(new int[]{24}));
        assertFalse(test.testBilanciamento(new int[]{24, 1, 24}));
        assertFalse(test.testBilanciamento(new int[]{0, 2, 2, 0}));
        assertFalse(test.testBilanciamento(new int[]{}));
    }
}
