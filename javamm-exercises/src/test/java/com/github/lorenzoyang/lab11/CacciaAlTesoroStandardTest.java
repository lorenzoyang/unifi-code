package com.github.lorenzoyang.lab11;


import org.junit.Assert;
import org.junit.Test;

public class CacciaAlTesoroStandardTest {
    private final CacciaAlTesoro test = new CacciaAlTesoro();

    @Test
    public void test1() {

        char[][] M = new char[][]{{'B', 'D', 'D', 'B'},
                {'B', 'A', 'B', 'B'},
                {'D', '?', 'A', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test2() {

        char[][] M = new char[][]{{'B', 'D', 'D', 'B'},
                {'B', 'A', 'B', 'B'},
                {'D', 'S', 'A', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test3() {

        char[][] M = new char[][]{{'B', 'D', 'T', 'B'},
                {'B', 'A', 'B', 'B'},
                {'D', '?', 'A', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test4() {

        char[][] M = new char[][]{{'A', 'D', 'D', 'A'},
                {'S', 'A', 'B', 'A'},
                {'A', '?', 'A', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test5() {

        char[][] M = new char[][]{{'D', 'B', 'D', 'A'},
                {'T', '?', 'T', 'A'},
                {'T', '?', 'T', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test6() {

        char[][] M = new char[][]{{'D', 'B', 'D', 'A'},
                {'T', '?', 'T', 'A'},
                {'S', '?', 'T', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test7() {

        char[][] M = new char[][]{{'D', 'B', 'D', 'A'},
                {'T', '?', 'T', 'A'},
                {'S', '?', 'T', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test8() {

        char[][] M = new char[][]{{'B', 'B', 'D', 'B'},
                {'B', 'D', 'B', 'B'},
                {'D', 'B', 'B', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test9() {

        char[][] M = new char[][]{{'B', 'B', 'D', 'B'},
                {'?', '?', '?', '?'},
                {'D', 'B', 'B', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test10() {

        char[][] M = new char[][]{{'B', 'B', 'D', 'B'},
                {'?', '?', '?', 'T'},
                {'D', 'B', 'B', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test11() {

        char[][] M = new char[][]{{'B', 'A', 'T', 'B'},
                {'D', 'A', 'A', 'T'},
                {'S', 'D', 'B', 'B'},
                {'S', 'A', 'D', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test12() {

        char[][] M = new char[][]{{'D', 'D', 'D', 'B'},
                {'D', 'A', 'S', 'S'},
                {'S', 'B', 'T', 'S'},
                {'S', 'S', 'T', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test13() {

        char[][] M = new char[][]{{'B', 'T', 'D', 'T'},
                {'?', 'D', 'A', 'T'},
                {'S', 'B', '?', 'S'},
                {'S', 'S', 'T', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test14() {

        char[][] M = new char[][]{{'B', 'A', 'S', 'S'},
                {'B', 'D', 'A', 'A'},
                {'S', 'B', 'T', 'A'},
                {'S', 'D', 'D', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test15() {

        char[][] M = new char[][]{{'B', 'A', 'B', 'S'},
                {'B', 'D', 'D', 'A'},
                {'S', 'B', 'T', 'A'},
                {'S', 'D', 'D', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test16() {

        char[][] M = new char[][]{{'S', 'A', 'A', 'B'},
                {'B', 'D', 'A', 'S'},
                {'S', 'B', 'T', 'A'},
                {'S', 'D', 'T', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test17() {

        char[][] M = new char[][]{{'B', 'T'},
                {'S', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test18() {

        char[][] M = new char[][]{{'B', 'T'},
                {'S', 'B'},
                {'B', 'S'},
                {'D', '?'},
                {'B', 'D'},
                {'D', 'X'},};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test19() {

        char[][] M = new char[][]{{'B', 'T'},
                {'S', 'B'},
                {'B', 'S'},
                {'D', 'D'},
                {'B', 'D'},
                {'D', 'X'},};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test20() {

        char[][] M = new char[][]{{'D', 'D', 'D', 'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test21() {

        char[][] M = new char[][]{{'D', '?', 'B', 'X'}};
        boolean ris = false;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

    @Test
    public void test22() {

        char[][] M = new char[][]{{'X'}};
        boolean ris = true;
        Assert.assertEquals(test.cacciaAlTesoro(M), ris);
    }

}
