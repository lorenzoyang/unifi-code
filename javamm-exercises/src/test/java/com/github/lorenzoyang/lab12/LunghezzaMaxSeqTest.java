package com.github.lorenzoyang.lab12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LunghezzaMaxSeqTest {
    private final LunghezzaMaxSeq test = new LunghezzaMaxSeq();

    @Test
    public void test1() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'w';
        int output = 3;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test2() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'b';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test3() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'a';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test4() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'T';
        int output = 2;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }


    @Test
    public void test5() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'x';
        int output = 3;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test6() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = 'W';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test7() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = '3';
        int output = 0;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test8() {
        char[] inputArray = {'b', 'a', 'w', 'w', 'T', 'T', 'x', 'x', 'x', 'w', 'w', 'w', 'W', 'w', 'a', 'w', '2', '1', '1'};
        char inputChar = '1';
        int output = 2;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test9() {
        char[] inputArray = {'b', 'a'};
        char inputChar = 'b';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test10() {
        char[] inputArray = {'b', 'a'};
        char inputChar = 'a';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test11() {
        char[] inputArray = {'b', 'a'};
        char inputChar = 'c';
        int output = 0;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test12() {
        char[] inputArray = {'a'};
        char inputChar = 'b';
        int output = 0;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test13() {
        char[] inputArray = {'a'};
        char inputChar = 'a';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test14() {
        char[] inputArray = {'a'};
        char inputChar = '1';
        int output = 0;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test15() {
        char[] inputArray = {'a', 'a', 'a'};
        char inputChar = 'a';
        int output = 3;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test16() {
        char[] inputArray = {'a', 'a'};
        char inputChar = 'a';
        int output = 2;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test17() {
        char[] inputArray = {'a', 'a'};
        char inputChar = 'b';
        int output = 0;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test18() {
        char[] inputArray = {'a', 'a', 'b'};
        char inputChar = 'a';
        int output = 2;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test19() {
        char[] inputArray = {'b', 'a', 'a'};
        char inputChar = 'a';
        int output = 2;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }

    @Test
    public void test20() {
        char[] inputArray = {'a', 'b', 'a'};
        char inputChar = 'a';
        int output = 1;
        assertEquals(test.lunghezzaMaxSeq(inputArray, inputChar), output);
    }
}
