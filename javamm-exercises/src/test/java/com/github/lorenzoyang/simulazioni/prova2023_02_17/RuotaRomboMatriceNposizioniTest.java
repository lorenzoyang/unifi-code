package com.github.lorenzoyang.simulazioni.prova2023_02_17;

import org.junit.Assert;
import org.junit.Test;

public class RuotaRomboMatriceNposizioniTest {
    private RuotaRomboMatrice test = new RuotaRomboMatrice();

    @Test
    public void test1() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{1, 6, 3}, {2, 5, 8}, {7, 4, 9}};
        int k = 1;
        int n = 1;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test5() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{1, 6, 3}, {2, 5, 8}, {7, 4, 9}};
        int k = 1;
        int n = -3;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test6() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{1, 6, 3}, {2, 5, 8}, {7, 4, 9}};
        int k = 1;
        int n = -11;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test7() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{1, 8, 3}, {6, 5, 4}, {7, 2, 9}};
        int k = 1;
        int n = 18;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test2() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 15, 4, 5}, {6, 9, 8, 19, 10}, {3, 12, 13, 14, 23}, {16, 7, 18, 17, 20}, {21, 22, 11, 24, 25}};
        int k = 2;
        int n = 10;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }


    @Test
    public void test3() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 3, 4, 5}, {6, 7, 12, 9, 10}, {11, 18, 13, 8, 15}, {16, 17, 14, 19, 20}, {21, 22, 23, 24, 25}};
        int k = 1;
        int n = -9;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test4() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{1, 2, 3, 12, 5, 6, 7}, {8, 9, 4, 11, 20, 13, 14}, {15, 10, 17, 18, 19, 28, 21}, {16, 23, 24, 25, 26, 27, 34}, {29, 22, 31, 32, 33, 40, 35}, {36, 37, 30, 39, 46, 41, 42}, {43, 44, 45, 38, 47, 48, 49}};
        ;
        int k = 3;
        int n = -11;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test8() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        ;
        int k = 3;
        int n = 36;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test9() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 9, 4, 5}, {6, 3, 8, 15, 10}, {7, 12, 13, 14, 19}, {16, 11, 18, 23, 20}, {21, 22, 17, 24, 25}};
        int k = 2;
        int n = 9;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }

    @Test
    public void test10() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{1, 2, 3, 20, 5, 6, 7}, {8, 9, 12, 11, 28, 13, 14}, {15, 4, 17, 18, 19, 34, 21}, {10, 23, 24, 25, 26, 27, 40}, {29, 16, 31, 32, 33, 46, 35}, {36, 37, 22, 39, 38, 41, 42}, {43, 44, 45, 30, 47, 48, 49}};
        ;
        int k = 3;
        int n = -10;
        Assert.assertEquals(test.ruotaRomboMatriceNposizioni(T, k, n), Ris);
    }
}
