package com.github.lorenzoyang.expressionsvisitor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTypeSystemVisitorTest {

    @Test
    public void testIntConstantType() {
        assertTrue(new IntConstant(10)
                .accept(new ExpressionTypeSystemVisitor()).isInt());
    }

    @Test
    public void testBooleanConstantType() {
        assertTrue(new BooleanConstant(true)
                .accept(new ExpressionTypeSystemVisitor()).isBoolean());
    }

    @Test
    public void testSumType() {
        assertTrue(new Sum(new IntConstant(1), new IntConstant(10))
                .accept(new ExpressionTypeSystemVisitor()).isInt());
    }

    @Test
    public void testSumNonIntegerLeftType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () -> new Sum(new BooleanConstant(true), new IntConstant(10))
                        .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected int but was boolean", thrown.getMessage());
    }

    @Test
    public void testSumNonIntegerRightType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () -> new Sum(new IntConstant(10), new BooleanConstant(true))
                        .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected int but was boolean", thrown.getMessage());
    }

    @Test
    public void testBooleanType() {
        assertTrue(new And(new BooleanConstant(true), new BooleanConstant(false))
                .accept(new ExpressionTypeSystemVisitor()).isBoolean());
    }

    @Test
    public void testBooleanNonBooleanLeftType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () -> new And(new IntConstant(10), new BooleanConstant(true))
                        .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected boolean but was int", thrown.getMessage());
    }

    @Test
    public void testBooleanNonBooleanRightType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () -> new And(new BooleanConstant(true), new IntConstant(10))
                        .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected boolean but was int", thrown.getMessage());
    }

    @Test
    public void testEqualType() {
        assertTrue(new Equal(new BooleanConstant(true), new IntConstant(10))
                .accept(new ExpressionTypeSystemVisitor()).isBoolean());
    }

    @Test
    public void testEqualInvalidLeftType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () ->
                        new Equal(
                                new And(new BooleanConstant(true), new IntConstant(10)),
                                new IntConstant(0))
                                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected boolean but was int", thrown.getMessage());
    }

    @Test
    public void testEqualInvalidRightType() {
        ExpressionTypeException thrown = assertThrows(ExpressionTypeException.class,
                () ->
                        new Equal(
                                new IntConstant(0),
                                new And(new BooleanConstant(true), new IntConstant(10)))
                                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected boolean but was int", thrown.getMessage());
    }

}
