package com.github.lorenzoyang.lab09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AzzeraAdiacentiTest {
    private final AzzeraAdiacenti test = new AzzeraAdiacenti();

    @Test
    public void test1() {
        int r = 1, c = 1;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[][] output = new int[][]{{0, 0, 0, 4},
                {0, 6, 0, 8},
                {0, 0, 0, 12}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test2() {
        int r = 0, c = 1;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[][] output = new int[][]{{0, 2, 0, 4},
                {0, 0, 0, 8},
                {0, 0, 0, 12}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test3() {
        int r = 1, c = 0;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[][] output = new int[][]{{0, 0, 3, 0},
                {5, 0, 7, 0},
                {0, 0, 11, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test4() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[][] output = new int[][]{{1, 0, 3, 0},
                {0, 0, 7, 0},
                {0, 0, 11, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test5() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] output = new int[][]{{1, 2, 3, 4},
                {5, 0, 0, 0},
                {9, 0, 11, 0},
                {13, 0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test6() {
        int r = 3, c = 3;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] output = new int[][]{{0, 2, 0, 0},
                {5, 6, 7, 8},
                {0, 10, 0, 0},
                {0, 14, 0, 16}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test7() {
        int r = 1, c = 0;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] output = new int[][]{{0, 0, 3, 0},
                {5, 0, 7, 0},
                {0, 0, 11, 0},
                {13, 14, 15, 16}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test8() {
        int r = 0, c = 1;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] output = new int[][]{{0, 2, 0, 4},
                {0, 0, 0, 8},
                {9, 10, 11, 12},
                {0, 0, 0, 16}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);

    }

    @Test
    public void test9() {
        int r = 3, c = 1;
        int[][] input = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] output = new int[][]{{0, 0, 0, 4},
                {5, 6, 7, 8},
                {0, 0, 0, 12},
                {0, 14, 0, 16}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test10() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] output = new int[][]{{1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test11() {
        int r = 1, c = 1;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] output = new int[][]{{0, 0, 0},
                {0, 5, 0},
                {0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test12() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] output = new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 0, 9}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test13() {
        int r = 2, c = 1;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] output = new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 8, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test14() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}};
        int[][] output = new int[][]{{1, 0, 0},
                {0, 0, 0},
                {7, 8, 9},
                {10, 11, 12},
                {0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test15() {
        int r = 3, c = 2;
        int[][] input = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}};
        int[][] output = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {0, 0, 0},
                {0, 0, 12},
                {0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test16() {
        int r = 3, c = 3;
        int[][] input = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] output = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 0, 0, 0},
                {16, 17, 0, 19, 0},
                {21, 22, 0, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test17() {
        int r = 0, c = 4;
        int[][] input = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] output = new int[][]{{0, 2, 3, 0, 5},
                {0, 7, 8, 0, 0},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {0, 22, 23, 0, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test18() {
        int r = 4, c = 1;
        int[][] input = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] output = new int[][]{{0, 0, 0, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {0, 0, 0, 19, 20},
                {0, 22, 0, 24, 25}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test19() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] output = new int[][]{{1, 0, 3, 4, 0},
                {0, 0, 8, 9, 0},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {0, 0, 23, 24, 0}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }

    @Test
    public void test20() {
        int r = 1, c = 3;
        int[][] input = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        int[][] output = new int[][]{{1, 2, 0, 0, 0},
                {6, 7, 0, 9, 0},
                {11, 12, 0, 0, 0},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(test.azzeraAdiacenti(input, r, c), output);
    }
}
