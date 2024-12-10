package com.github.lorenzoyang.expressionsvisitor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTypeTest {

    @Test
    public void testInt() {
        ExpressionType ofInt = ExpressionType.ofInt();
        assertTrue(ofInt.isInt());
        assertFalse(ofInt.isBoolean());
        assertEquals("int", ofInt.toString());
    }

    @Test
    public void testBoolean() {
        ExpressionType ofBoolean = ExpressionType.ofBoolean();
        assertTrue(ofBoolean.isBoolean());
        assertFalse(ofBoolean.isInt());
        assertEquals("boolean", ofBoolean.toString());
    }

    @Test
    public void testSameInstance() {
        assertSame(ExpressionType.ofBoolean(), ExpressionType.ofBoolean());
        assertSame(ExpressionType.ofInt(), ExpressionType.ofInt());
    }

}
