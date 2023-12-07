package com.github.lorenzoyang.lab17;

import org.junit.Assert;
import org.junit.Test;

public class CircolareTest {
    private final Circolare test = new Circolare();

    @Test
    public void test1() {

        char[][] M = {{'B', 'D', 'D'},
                {'B', 'A', 'S'},
                {'D', 'D', 'A'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }


    @Test
    public void test2() {

        char[][] M = {{'B', 'D', 'D'},
                {'B', 'S', 'S'},
                {'D', 'D', 'A'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test3() {

        char[][] M = {{'D', 'D', 'B'},
                {'A', 'S', 'B'},
                {'B', 'A', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test4() {

        char[][] M = {{'D', 'D', 'B'},
                {'B', 'S', 'B'},
                {'B', 'A', 'S'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test5() {

        char[][] M = {{'D', 'D', 'B'},
                {'B', 'S', 'B'},
                {'D', 'A', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test6() {

        char[][] M = {{'D', 'D', 'B'},
                {'B', 'S', 'S'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test7() {

        char[][] M = {{'D', 'D', 'B'},
                {'S', 'S', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test8() {

        char[][] M = {{'D', 'D', 'B'},
                {'S', 'A', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test9() {

        char[][] M = {{'D', 'S', 'B'},
                {'S', 'A', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test10() {

        char[][] M = {{'S', 'S', 'S'},
                {'S', 'A', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test11() {

        char[][] M = {{'D', 'B'},
                {'A', 'S'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test12() {

        char[][] M = {{'A'},
                {'D'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test13() {

        char[][] M = {{'A'},
                {'B'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test14() {

        char[][] M = {{'A'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test15() {

        char[][] M = {{'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'B', 'S', 'S', 'S', 'S'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test16() {

        char[][] M = {{'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'B', 'D', 'S', 'S', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test17() {

        char[][] M = {{'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'A', 'S', 'S', 'S', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolare(M), ris);
    }


    @Test
    public void test18() {

        char[][] M = {{'B', 'D', 'A', 'D'},
                {'B', 'A', 'D', 'B'},
                {'D', 'A', 'A', 'B'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

    @Test
    public void test19() {

        char[][] M = {{'B', 'B', 'D', 'D'},
                {'B', 'D', 'D', 'B'},
                {'D', 'B', 'B', 'S'}};

        boolean ris = true;

        Assert.assertEquals(test.circolare(M), ris);
    }

}
