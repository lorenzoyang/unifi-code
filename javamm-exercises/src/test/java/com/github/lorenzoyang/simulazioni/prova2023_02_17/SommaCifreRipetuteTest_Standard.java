package com.github.lorenzoyang.simulazioni.prova2023_02_17;

import org.junit.Assert;
import org.junit.Test;

public class SommaCifreRipetuteTest_Standard {
    private SommaCifreRipetute test = new SommaCifreRipetute();

    @Test
    public void test1() {

        int numero = 322212292;
        long ris = 361492;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test2() {

        int numero = 1222222222;
        long ris = 118;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test3() {

        int numero = 341234000;
        long ris = 3412340;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test5() {

        int numero = 0;
        long ris = 0;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test6() {

        int numero = 900000999;
        long ris = 9027;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test7() {

        int numero = 1000000001;
        long ris = 101;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test8() {

        int numero = 1111122222;
        long ris = 510;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test9() {

        int numero = 9063355;
        long ris = 906610;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }

    @Test
    public void test10() {

        int numero = 3;
        long ris = 3;
        Assert.assertEquals(test.sommaCifreRipetute(numero), ris);
    }
}
