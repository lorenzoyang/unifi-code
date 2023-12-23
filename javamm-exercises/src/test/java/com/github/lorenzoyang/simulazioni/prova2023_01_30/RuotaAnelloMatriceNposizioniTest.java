package com.github.lorenzoyang.simulazioni.prova2023_01_30;

import org.junit.Assert;
import org.junit.Test;

public class RuotaAnelloMatriceNposizioniTest {
    private final RuotaAnelloMatrice test = new RuotaAnelloMatrice();

    @Test
    public void test1() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{4, 1, 2}, {7, 5, 3}, {8, 9, 6}};
        int k = 1;
        int n = 1;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test5() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{4, 1, 2}, {7, 5, 3}, {8, 9, 6}};
        int k = 1;
        int n = -15;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test6() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{4, 1, 2}, {7, 5, 3}, {8, 9, 6}};
        int k = 1;
        int n = -31;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test7() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        int k = 1;
        int n = 34;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test2() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{6, 1, 2, 3, 4}, {11, 7, 8, 9, 5}, {16, 12, 13, 14, 10}, {21, 17, 18, 19, 15}, {22, 23, 24, 25, 20}};
        int k = 2;
        int n = 17;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }


    @Test
    public void test3() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 3, 4, 5}, {6, 8, 9, 14, 10}, {11, 7, 13, 19, 15}, {16, 12, 17, 18, 20}, {21, 22, 23, 24, 25}};
        int k = 1;
        int n = -1;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test4() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{8, 1, 2, 3, 4, 5, 6}, {15, 9, 10, 11, 12, 13, 7}, {22, 16, 17, 18, 19, 20, 14}, {29, 23, 24, 25, 26, 27, 21}, {36, 30, 31, 32, 33, 34, 28}, {43, 37, 38, 39, 40, 41, 35}, {44, 45, 46, 47, 48, 49, 42}};
        ;
        int k = 3;
        int n = 25;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test8() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        ;
        int k = 3;
        int n = 48;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test9() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{6, 1, 2, 3, 4}, {11, 7, 8, 9, 5}, {16, 12, 13, 14, 10}, {21, 17, 18, 19, 15}, {22, 23, 24, 25, 20}};
        int k = 2;
        int n = -31;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test10() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{8, 1, 2, 3, 4, 5, 6}, {15, 9, 10, 11, 12, 13, 7}, {22, 16, 17, 18, 19, 20, 14}, {29, 23, 24, 25, 26, 27, 21}, {36, 30, 31, 32, 33, 34, 28}, {43, 37, 38, 39, 40, 41, 35}, {44, 45, 46, 47, 48, 49, 42}};
        ;
        int k = 3;
        int n = -47;
        Assert.assertEquals(test.ruotaAnelloMatriceNposizioni(T, k, n), Ris);
    }
}
