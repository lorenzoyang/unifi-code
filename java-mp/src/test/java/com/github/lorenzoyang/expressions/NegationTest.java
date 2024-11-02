package com.github.lorenzoyang.expressions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NegationTest {
    @Test
    public void testNegationEval() {
        assertEquals(-3, new Negation(new Constant(3)).eval());
        assertEquals(3, new Negation(new Constant(-3)).eval());
    }
}