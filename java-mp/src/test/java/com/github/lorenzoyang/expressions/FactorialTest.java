package com.github.lorenzoyang.expressions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorialEval() {
        assertEquals(1, // 0!
                new Factorial(new Constant(0)).eval());
        assertEquals(120, // 5!
                new Factorial(new Sum(new Constant(1), new Constant(4))).eval());
    }
}