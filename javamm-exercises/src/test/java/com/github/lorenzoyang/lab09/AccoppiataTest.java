package com.github.lorenzoyang.lab09;

import org.junit.Assert;
import org.junit.Test;


public class AccoppiataTest {
    private final Accoppiata test = new Accoppiata();

    @Test
    public void test1() {

        char[] A = new char[]{'m', 'a', 't', 'r', 'i', 'x', 'm', 'a', 't', 'r', 'i', 'x'};
        Assert.assertEquals(test.accoppiata(A), true);

    }

    @Test
    public void test2() {

        char[] A = new char[]{'m', 'a', 't', 'r', 'i', 'x'};
        Assert.assertEquals(test.accoppiata(A), false);

    }

    @Test
    public void test3() {

        char[] A = new char[]{'m', 'm'};
        Assert.assertEquals(test.accoppiata(A), true);

    }

    @Test
    public void test4() {

        char[] A = new char[]{'a'};
        Assert.assertEquals(test.accoppiata(A), false);

    }

    @Test
    public void test5() {

        char[] A = new char[]{'m', 'm', 'm', 'x'};
        Assert.assertEquals(test.accoppiata(A), false);

    }

}