package com.github.lorenzoyang.lab10;

import org.junit.Assert;
import org.junit.Test;

public class TestBilanciamentoTest {
    private final TestBilanciamento test = new TestBilanciamento();

    @Test
    public void test1() {

        int[] mioArray = new int[]{1, 2, 3, 4, 4, 5, 6, 7};
        Assert.assertEquals(test.testBilanciamento(mioArray), true);
    }

    @Test
    public void test2() {

        int[] mioArray = new int[]{1, 3, 3, 4, 4, 5, 6, 7};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test3() {

        int[] mioArray = new int[]{1, 2, 3, 4, 4, 5, 6, 8};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test4() {

        int[] mioArray = new int[]{4, 2, 3, 4, 4, 5, 6, 7};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test5() {

        int[] mioArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test6() {

        int[] mioArray = new int[]{1, 2, 3, 4};
        Assert.assertEquals(test.testBilanciamento(mioArray), true);
    }

    @Test
    public void test7() {

        int[] mioArray = new int[]{1, 3, 3, 4};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test8() {

        int[] mioArray = new int[]{1, 1};
        Assert.assertEquals(test.testBilanciamento(mioArray), true);
    }

    @Test
    public void test9() {

        int[] mioArray = new int[]{1, 7};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

    @Test
    public void test10() {

        int[] mioArray = new int[]{};
        Assert.assertEquals(test.testBilanciamento(mioArray), false);
    }

}