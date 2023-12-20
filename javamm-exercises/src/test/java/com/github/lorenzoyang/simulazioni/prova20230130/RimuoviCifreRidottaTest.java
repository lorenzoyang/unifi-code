package com.github.lorenzoyang.simulazioni.prova20230130;

import org.junit.Assert;
import org.junit.Test;

public class RimuoviCifreRidottaTest {
    private final RimuoviCifre test = new RimuoviCifre();

    @Test
    public void test1() {

        long numero = 322212292;
        short cifra = 2;
        long ris = 32192;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test2() {

        long numero = 222212292;
        short cifra = 2;
        long ris = 192;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test3() {

        long numero = 22222222;
        short cifra = 2;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test4() {

        long numero = 2122232212;
        short cifra = 2;
        long ris = 212312;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test5() {

        long numero = 1121232111;
        short cifra = 1;
        long ris = 2232;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test6() {

        long numero = 1111111111;
        short cifra = 1;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test7() {

        long numero = 0;
        short cifra = 1;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test8() {

        long numero = 0;
        short cifra = 2;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test9() {

        long numero = 22222222;
        short cifra = 2;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test10() {

        long numero = 1;
        short cifra = 1;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test11() {

        long numero = 34456;
        short cifra = 1;
        long ris = 34456;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test12() {

        long numero = 34456;
        short cifra = 2;
        long ris = 34456;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test13() {

        long numero = 3142211;
        short cifra = 1;
        long ris = 3422;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test14() {

        long numero = 322212222;
        short cifra = 2;
        long ris = 321;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test15() {

        long numero = 222222000;
        short cifra = 2;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

    @Test
    public void test16() {

        long numero = 1100;
        short cifra = 1;
        long ris = 0;
        Assert.assertEquals(test.rimuoviCifre(numero, cifra), ris);
    }

}
