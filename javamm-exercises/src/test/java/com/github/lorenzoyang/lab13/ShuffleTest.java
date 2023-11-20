package com.github.lorenzoyang.lab13;

import org.junit.Assert;
import org.junit.Test;

public class ShuffleTest {
    private final ShuffleMatrice test = new ShuffleMatrice();

    @Test
    public void test1() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 0, 2}};
        int[][] N = {{5, 4, 6}, {2, 1, 3}, {8, 7, 9}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test2() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{0, 1, 2}};
        int[][] N = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test3() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 2, 0}};
        int[][] N = {{9, 7, 8}, {3, 1, 2}, {6, 4, 5}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test4() {

        int[][] T = {{1, 2}, {3, 4}};
        int[][] S = {{0, 1}};
        int[][] N = {{1, 2}, {3, 4}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test5() {

        int[][] T = {{1, 2}, {3, 4}};
        int[][] S = {{1, 0}};
        int[][] N = {{4, 3}, {2, 1}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test6() {

        int[][] T = {{3}};
        int[][] S = {{0}};
        int[][] N = {{3}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test7() {

        int[][] T = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] S = {{0, 2, 1, 3}};
        int[][] N = {{1, 3, 2, 4}, {9, 11, 10, 12}, {5, 7, 6, 8}, {13, 15, 14, 16}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test8() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 0, 2}, {0, 1, 2}};
        int[][] N = {{5, 4, 6}, {2, 1, 3}, {8, 7, 9}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test9() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 0, 2}, {0, 1, 2}, {0, 2, 1}};
        int[][] N = {{5, 6, 4}, {8, 9, 7}, {2, 3, 1}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test10() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 0, 2}, {0, 1, 2}, {0, 2, 1}, {2, 0, 1}};
        int[][] N = {{9, 7, 8}, {3, 1, 2}, {6, 4, 5}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test11() {

        int[][] T = {{3}};
        int[][] S = {{0}, {0}, {0}};
        int[][] N = {{3}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }

    @Test
    public void test12() {

        int[][] T = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] S = {{1, 0, 2}, {0, 2, 1}};
        int[][] N = {{5, 6, 4}, {8, 9, 7}, {2, 3, 1}};
        Assert.assertArrayEquals(test.shuffleMatrice(T, S), N);
    }
}
