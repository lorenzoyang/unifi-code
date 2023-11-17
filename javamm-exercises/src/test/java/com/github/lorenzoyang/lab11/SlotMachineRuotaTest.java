package com.github.lorenzoyang.lab11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlotMachineRuotaTest {
    private final SlotMachine test = new SlotMachine();

    @Test
    public void test1() {

        int[][] slot = new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        int[] rotazioni = {2, 2, 0, 1};
        int[][] slotRuotata = {
                {0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        ;
        assertArrayEquals(slotRuotata, test.ruota(slot, rotazioni));
    }

    @Test
    public void test2() {

        int[][] slot = new int[][]{{0, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        int[] rotazioni = {5, 8, 6, 10};
        int[][] slotRuotata = {{0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        assertArrayEquals(slotRuotata, test.ruota(slot, rotazioni));
    }

    @Test
    public void test3() {

        int[][] slot = new int[][]{
                {1, 0},
                {0, 1},
                {1, 1},
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}};
        int[] rotazioni = {1, 1};
        int[][] slotRuotata = {{1, 1},
                {1, 0},
                {0, 1},
                {1, 1},
                {0, 0},
                {0, 1},
                {1, 0}};
        assertArrayEquals(slotRuotata, test.ruota(slot, rotazioni));
    }

    @Test
    public void test4() {
        int[][] slot = new int[][]{{1}, {0}, {1}, {0}, {0}, {1}, {1}};
        int[] rotazioni = {15};
        int[][] slotRuotata = {{1},
                {1},
                {0},
                {1},
                {0},
                {0},
                {1}};
        assertArrayEquals(slotRuotata, test.ruota(slot, rotazioni));
    }

    @Test
    public void test5() {
        int[][] slot = new int[][]{
                {0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 1, 6, 0, 3, 11};
        int[][] slotRuotata = {
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        assertArrayEquals(slotRuotata, test.ruota(slot, rotazioni));
    }
}
