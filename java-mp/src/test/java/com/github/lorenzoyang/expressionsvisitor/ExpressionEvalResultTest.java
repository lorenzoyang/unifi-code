package com.github.lorenzoyang.expressionsvisitor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ExpressionEvalResultTest {

    @Test
    public void testValidInt() {
        assertEquals(10, ExpressionEvalResult.ofInt(10).asInt());
    }

    @Test
    public void testInvalidInt() {
        ExpressionEvalResultException thrown = assertThrows(ExpressionEvalResultException.class,
                () -> ExpressionEvalResult.ofBoolean(false).asInt());
        assertEquals("Not a valid int: false", thrown.getMessage());
    }

    @Test
    public void testValidBoolean() {
        assertEquals(true, ExpressionEvalResult.ofBoolean(true).asBoolean());
    }

    @Test
    public void testInvalidBoolean() {
        ExpressionEvalResultException thrown = assertThrows(ExpressionEvalResultException.class,
                () -> ExpressionEvalResult.ofInt(10).asBoolean());
        assertEquals("Not a valid boolean: 10", thrown.getMessage());
    }

}
