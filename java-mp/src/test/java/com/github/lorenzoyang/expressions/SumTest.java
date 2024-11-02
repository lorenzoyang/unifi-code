package com.github.lorenzoyang.expressions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @Test
    public void simpleSumEval() {
        assertEquals(5, new Sum(
                new Constant(2),
                new Constant(3))
                .eval());
    }

    public void complexSumEval() {
        assertEquals(15, new Sum(
                new Sum(new Constant(10), new Constant(2)),
                new Constant(3)
        ).eval());
    }
}