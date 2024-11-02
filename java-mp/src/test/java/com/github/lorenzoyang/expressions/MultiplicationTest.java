package com.github.lorenzoyang.expressions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class MultiplicationTest {

    @Test
    public void testMultiplicationEval() {
        assertEquals(15, new Multiplication(
                new Constant(5),
                new Constant(3))
                .eval());
    }
}