package com.github.lorenzoyang.lab11;

import org.junit.Assert;
import org.junit.Test;

public class SlotMachineTest_ControllaVincita {
    private final SlotMachine test = new SlotMachine();

    @Test
    public void test1() {

        int[][] slot = new int[][]{{0, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        boolean ris = false;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

    @Test
    public void test2() {

        int[][] slot = new int[][]{{0, 0, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 1}};
        boolean ris = true;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }


    @Test
    public void test3() {

        int[][] slot = new int[][]{{1, 0},
                {0, 1},
                {1, 1},
                {1, 1},
                {0, 1},
                {1, 0},
                {1, 1}};
        boolean ris = true;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

    @Test
    public void test4() {

        int[][] slot = new int[][]{{1, 0},
                {0, 1},
                {0, 1},
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}};
        boolean ris = false;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

    @Test
    public void test5() {

        int[][] slot = new int[][]{{1},
                {0},
                {1},
                {0},
                {0},
                {1},
                {1}};
        boolean ris = false;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

    @Test
    public void test6() {

        int[][] slot = new int[][]{{1},
                {0},
                {1},
                {1},
                {0},
                {1},
                {1}};
        boolean ris = true;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }


    @Test
    public void test7() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        boolean ris = true;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

    @Test
    public void test8() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        boolean ris = false;
        Assert.assertEquals(test.controllaVincita(slot), ris);
    }

}
