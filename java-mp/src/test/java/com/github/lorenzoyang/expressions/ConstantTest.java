package com.github.lorenzoyang.expressions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstantTest {

    @Test
    public void eval() {
        assertEquals(5, new Constant(5).eval());
    }
}