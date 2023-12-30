package com.github.lorenzoyang.algorithmsdatastructures.applications;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void evaluateReturnsCorrectResultForSimpleExpression() {
        assertEquals(7, calculator.evaluate("(3+4)"));
    }

    @Test
    public void evaluateReturnsCorrectResultForComplexExpression() {
        assertEquals(2075, calculator.evaluate("(5 * (((9+8) * (4 * 6)) +7))"));
    }

    @Test
    public void evaluateReturnsCorrectResultForExpressionWithSubtraction() {
        assertEquals(-1, calculator.evaluate("(3-4)"));
    }

    @Test
    public void evaluateReturnsCorrectResultForExpressionWithMultiplication() {
        assertEquals(12, calculator.evaluate("(3*4)"));
    }

    @Test
    public void evaluateReturnsCorrectResultForExpressionWithDivision() {
        assertEquals(2, calculator.evaluate("(8/4)"));
    }

    @Test
    public void evaluateThrowsExceptionForInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluate("(3/0)"));
    }

    @Test
    public void evaluateThrowsExceptionForExpressionWithInvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluate("(3&4)"));
    }
}
