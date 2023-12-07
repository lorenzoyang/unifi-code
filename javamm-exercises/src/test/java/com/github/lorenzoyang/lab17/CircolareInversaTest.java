package com.github.lorenzoyang.lab17;


import org.junit.Assert;
import org.junit.Test;

public class CircolareInversaTest {
    private final Circolare test = new Circolare();

    @Test
    public void test1() {

        char[][] M = {{'A', 'S', 'S'},
                {'A', 'B', 'D'},
                {'S', 'S', 'B'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }


    @Test
    public void test2() {

        char[][] M = {{'B', 'D', 'D'},
                {'B', 'S', 'S'},
                {'D', 'D', 'A'}};

        boolean ris = false;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }


    @Test
    public void test3() {

        char[][] M = {{'S', 'S', 'A'},
                {'A', 'D', 'A'},
                {'A', 'B', 'D'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test4() {

        char[][] M = {{'S', 'S', 'A'},
                {'A', 'D', 'D'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test5() {

        char[][] M = {{'D', 'D', 'B'},
                {'S', 'S', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test6() {

        char[][] M = {{'S', 'A'},
                {'B', 'D'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test7() {

        char[][] M = {{'A'},
                {'D'}};

        boolean ris = false;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test8() {

        char[][] M = {{'A'},
                {'B'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test9() {

        char[][] M = {{'A'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test10() {

        char[][] M = {{'A', 'S', 'A', 'S', 'A'},
                {'S', 'B', 'S', 'B', 'A'},
                {'A', 'D', 'D', 'D', 'D'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test11() {

        char[][] M = {{'B', 'D', 'B', 'D', 'B'},
                {'D', 'A', 'D', 'A', 'B'},
                {'B', 'D', 'S', 'S', 'S'}};

        boolean ris = false;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

    @Test
    public void test12() {

        char[][] M = {{'A', 'S', 'B', 'S'},
                {'A', 'B', 'S', 'A'},
                {'S', 'B', 'B', 'A'}};

        boolean ris = true;

        Assert.assertEquals(test.circolareInversa(M), ris);
    }

}
