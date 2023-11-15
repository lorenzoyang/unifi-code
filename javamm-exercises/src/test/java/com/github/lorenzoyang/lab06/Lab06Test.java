package com.github.lorenzoyang.lab06;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab06Test {
    private final Lab06 lab06 = new Lab06();

    @Test
    public void testIntegerSquareRoot() {
        assertEquals(1, lab06.integerSquareRoot(1));
        assertEquals(1, lab06.integerSquareRoot(2));
        assertEquals(3, lab06.integerSquareRoot(15));
        assertEquals(4, lab06.integerSquareRoot(16));
    }

    @Test
    public void testFirstLastDigitSum() {
        assertEquals(1, lab06.firstLastDigitSum(10));
        assertEquals(2, lab06.firstLastDigitSum(11));
        assertEquals(8, lab06.firstLastDigitSum(23456));
        assertEquals(12, lab06.firstLastDigitSum(95643));
        assertEquals(-1, lab06.firstLastDigitSum(5));
        assertEquals(-1, lab06.firstLastDigitSum(-10));
    }

    @Test
    public void testInvertNumber() {
        assertEquals(1, lab06.invertNumber(1));
        assertEquals(11, lab06.invertNumber(11));
        assertEquals(65432, lab06.invertNumber(23456));
        assertEquals(34659, lab06.invertNumber(95643));
        assertEquals(-1, lab06.invertNumber(0));
        assertEquals(-1, lab06.invertNumber(-1));
    }

    @Test
    public void testHarmonicSum() {
        assertEquals(1, lab06.harmonicSum(1));
        assertEquals(2, lab06.harmonicSum(2));
        assertEquals(3, lab06.harmonicSum(3));
        assertEquals(4, lab06.harmonicSum(5));
        assertEquals(5, lab06.harmonicSum(7));
        assertEquals(204, lab06.harmonicSum(1000));
    }

    @Test
    public void testDuplicateDigit() {
        assertEquals(11, lab06.duplicateDigit(1));
        assertEquals(1122, lab06.duplicateDigit(12));
        assertEquals(2211, lab06.duplicateDigit(21));
        assertEquals(221100, lab06.duplicateDigit(210));
    }
}
