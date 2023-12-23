package com.github.lorenzoyang.simulazioni.prova2023_01_30;

import org.junit.Assert;
import org.junit.Test;

public class RuotaAnelloMatriceTest {
    private final RuotaAnelloMatrice test = new RuotaAnelloMatrice();

    @Test
    public void test1() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] Ris = {{4, 1, 2}, {7, 5, 3}, {8, 9, 6}};
        int k = 1;
        Assert.assertEquals(test.ruotaAnelloMatrice(T, k), Ris);
    }

    @Test
    public void test2() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{6, 1, 2, 3, 4}, {11, 7, 8, 9, 5}, {16, 12, 13, 14, 10}, {21, 17, 18, 19, 15}, {22, 23, 24, 25, 20}};
        int k = 2;
        Assert.assertEquals(test.ruotaAnelloMatrice(T, k), Ris);
    }

    @Test
    public void test3() {

        int[][] T = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] Ris = {{1, 2, 3, 4, 5}, {6, 12, 7, 8, 10}, {11, 17, 13, 9, 15}, {16, 18, 19, 14, 20}, {21, 22, 23, 24, 25}};
        int k = 1;
        Assert.assertEquals(test.ruotaAnelloMatrice(T, k), Ris);
    }

    @Test
    public void test4() {

        int[][] T = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
        int[][] Ris = {{8, 1, 2, 3, 4, 5, 6}, {15, 9, 10, 11, 12, 13, 7}, {22, 16, 17, 18, 19, 20, 14}, {29, 23, 24, 25, 26, 27, 21}, {36, 30, 31, 32, 33, 34, 28}, {43, 37, 38, 39, 40, 41, 35}, {44, 45, 46, 47, 48, 49, 42}};
        ;
        int k = 3;
        Assert.assertEquals(test.ruotaAnelloMatrice(T, k), Ris);
    }
}
