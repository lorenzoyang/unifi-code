package com.github.lorenzoyang.lab10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EsplosioneMatriceTest {
    private final EsplosioneMatrice esplosioneMatrice = new EsplosioneMatrice();

    @Test
    public void test1() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test2() {
        int r = 0, c = 1;
        int[][] input = new int[][]{{1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}};
        int[][] output = new int[][]{{1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test3() {
        int r = 1, c = 1;
        int[][] input = new int[][]{{1, 0},
                {1, 1}};
        int[][] output = new int[][]{{0, 0},
                {0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test4() {
        int r = 1, c = 0;
        int[][] input = new int[][]{{1, 0},
                {1, 1}};
        int[][] output = new int[][]{{0, 0},
                {0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test5() {
        int r = 0, c = 1;
        int[][] input = new int[][]{{1, 0},
                {1, 1}};
        int[][] output = new int[][]{{1, 0},
                {1, 1}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test6() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test7() {
        int r = 1, c = 1;
        int[][] input = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test8() {
        int r = 1, c = 1;
        int[][] input = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 0, 1}};
        int[][] output = new int[][]{{1, 0, 0},
                {1, 0, 0},
                {0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test9() {
        int r = 0, c = 2;
        int[][] input = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 0, 1}};
        int[][] output = new int[][]{{1, 0, 0},
                {1, 1, 0},
                {0, 0, 1}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test10() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test11() {
        int r = 3, c = 3;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test12() {
        int r = 3, c = 0;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test13() {
        int r = 3, c = 0;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test14() {
        int r = 0, c = 0;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test15() {
        int r = 3, c = 2;
        int[][] input = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test16() {
        int r = 3, c = 2;
        int[][] input = new int[][]{{1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test17() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}};
        int[][] output = new int[][]{{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test18() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1}};
        int[][] output = new int[][]{{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test19() {
        int r = 2, c = 2;
        int[][] input = new int[][]{{1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1}};
        int[][] output = new int[][]{{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

    @Test
    public void test20() {
        int r = 0, c = 4;
        int[][] input = new int[][]{{1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0}};
        int[][] output = new int[][]{{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        assertArrayEquals(esplosioneMatrice.esplodiMatrice(input, r, c), output);
    }

}
