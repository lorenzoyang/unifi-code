package com.github.lorenzoyang.expressionsvisitor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionEvaluatorVisitorTest {

    @Test
    public void testEvalIntConstant() {
        assertEquals(10,
                new IntConstant(10)
                        .accept(new ExpressionEvaluatorVisitor()).getValue());
    }

    @Test
    public void testEvalBooelanConstant() {
        assertEquals(true,
                new BooleanConstant(true)
                        .accept(new ExpressionEvaluatorVisitor()).getValue());
    }

    @Test
    public void testEvalEqualTrue() {
        assertTrue(
                new Equal(new IntConstant(10), new IntConstant(10))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
        assertTrue(
                new Equal(new BooleanConstant(true), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
    }

    @Test
    public void testEvalEqualFalse() {
        assertFalse(
                new Equal(new IntConstant(11), new IntConstant(10))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
        assertFalse(
                new Equal(new BooleanConstant(false), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
    }

    @Test
    public void testEvalEqualDifferentTypesFalse() {
        assertFalse(
                new Equal(new IntConstant(10), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
    }

    @Test
    public void testEvalValidSum() {
        assertEquals(15,
                new Sum(new IntConstant(5), new IntConstant(10))
                        .accept(new ExpressionEvaluatorVisitor()).asInt());
    }

    @Test
    public void testEvalInvalidSum() {
        ExpressionEvalResultException thrown = assertThrows(ExpressionEvalResultException.class,
                () -> new Sum(new IntConstant(5), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()));
        assertEquals("Not a valid int: true", thrown.getMessage());
    }

    @Test
    public void testEvalValidAnd() {
        assertTrue(
                new And(new BooleanConstant(true), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
        assertFalse(
                new And(new BooleanConstant(true), new BooleanConstant(false))
                        .accept(new ExpressionEvaluatorVisitor()).asBoolean());
    }

    @Test
    public void testEvalInvalidAnd() {
        ExpressionEvalResultException thrown = assertThrows(ExpressionEvalResultException.class,
                () -> new And(new IntConstant(5), new BooleanConstant(true))
                        .accept(new ExpressionEvaluatorVisitor()));
        assertEquals("Not a valid boolean: 5", thrown.getMessage());
    }

}