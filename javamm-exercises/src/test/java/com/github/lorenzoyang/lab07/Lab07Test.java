package com.github.lorenzoyang.lab07;


import org.junit.Test;

import static org.junit.Assert.*;

public class Lab07Test {
    private final Lab07 lab07 = new Lab07();

    @Test
    public void testScalarProduct() {
        assertEquals(11, lab07.scalarProduct(new int[]{3, 4, -2}, new int[]{-1, 5, 3}));
        assertEquals(15, lab07.scalarProduct(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 1}));
        assertEquals(0, lab07.scalarProduct(new int[]{1, 2, 3, 4, 5}, new int[]{0, 0, 0, 0, 0}));
        assertEquals(-28, lab07.scalarProduct(new int[]{7}, new int[]{-4}));
    }

    @Test
    public void testArraySum() {
        assertArrayEquals(new int[]{2, 9, 1}, lab07.arraySum(new int[]{3, 4, -2}, new int[]{-1, 5, 3}));
        assertArrayEquals(new int[]{2, -4, 6, -8}, lab07.arraySum(new int[]{1, -2, 3, -4}, new int[]{1, -2, 3, -4}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, lab07.arraySum(new int[]{0, 0, 0, 0, 0}, new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testDecimal() {
        assertEquals(0, lab07.decimal(new int[]{0, 0, 0, 0}));
        assertEquals(7, lab07.decimal(new int[]{0, 1, 1, 1}));
        assertEquals(8, lab07.decimal(new int[]{1, 0, 0, 0}));
        assertEquals(15, lab07.decimal(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void testUpperCase() {
        assertArrayEquals(new char[]{'R', 'O', 'M', 'A'}, lab07.upperCase(new char[]{'r', 'o', 'm', 'a'}));
        assertArrayEquals(new char[]{'R', 'O', 'M', 'A'}, lab07.upperCase(new char[]{'r', 'O', 'm', 'a'}));
        assertArrayEquals(new char[]{'R', 'O', 'M', 'A'}, lab07.upperCase(new char[]{'R', 'O', 'M', 'A'}));
    }

    @Test
    public void testPalindrome() {
        assertTrue(lab07.palindrome(new int[]{4, 2, 5, 9, 9, 5, 2, 4}));
        assertTrue(lab07.palindrome(new int[]{3, -8, 1, -8, 3}));
        assertFalse(lab07.palindrome(new int[]{1, -9, 4, 3, 3, 4, 9, 1}));
        assertFalse(lab07.palindrome(new int[]{1, 2, 3, 3, 2, 1, 1}));
    }
}
