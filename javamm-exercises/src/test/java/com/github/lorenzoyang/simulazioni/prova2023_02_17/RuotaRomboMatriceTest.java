package com.github.lorenzoyang.simulazioni.prova2023_02_17;

import org.junit.Assert;
import org.junit.Test;

public class RuotaRomboMatriceTest {
    private RuotaRomboMatrice test = new RuotaRomboMatrice();

    @Test
    public void test1() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{1, 6, 3}, {2, 5, 8}, {7, 4, 9}};
        int k = 1;
        Assert.assertEquals(test.ruotaRomboMatrice(T, k), Ris);
    }

    @Test
    public void test2() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 9, 4, 5}, {6, 3, 8, 15, 10}, {7, 12, 13, 14, 19}, {16, 11, 18, 23, 20}, {21, 22, 17, 24, 25}};
        int k = 2;
        Assert.assertEquals(test.ruotaRomboMatrice(T, k), Ris);
    }

    @Test
    public void test3() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 3, 4, 5}, {6, 7, 14, 9, 10}, {11, 8, 13, 18, 15}, {16, 17, 12, 19, 20}, {21, 22, 23, 24, 25}};
        int k = 1;
        Assert.assertEquals(test.ruotaRomboMatrice(T, k), Ris);
    }

    @Test
    public void test4() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{1, 2, 3, 12, 5, 6, 7}, {8, 9, 4, 11, 20, 13, 14}, {15, 10, 17, 18, 19, 28, 21}, {16, 23, 24, 25, 26, 27, 34}, {29, 22, 31, 32, 33, 40, 35}, {36, 37, 30, 39, 46, 41, 42}, {43, 44, 45, 38, 47, 48, 49}};
        ;
        int k = 3;
        Assert.assertEquals(test.ruotaRomboMatrice(T, k), Ris);
    }
}
