package com.github.lorenzoyang.lab11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitaCompletaTest {
    private final SlotMachine test = new SlotMachine();

    @Test
    public void test1() {

        int[][] slot = new int[][]{{0, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        int[] rotazioni = {2, 2, 0, 1};
        int[][] slotRuotata = {{0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};
        boolean ris = true;

        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
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
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test3() {

        int[][] slot = new int[][]{{0, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}};
        int[] rotazioni = {5, 8, 6, 12};
        int[][] slotRuotata = {{0, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 1}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test4() {

        int[][] slot = new int[][]{{1, 0},
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
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test5() {

        int[][] slot = new int[][]{{1, 0},
                {0, 1},
                {0, 1},
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}};
        int[] rotazioni = {1, 1};
        int[][] slotRuotata = {{1, 1},
                {1, 0},
                {0, 1},
                {0, 1},
                {0, 0},
                {0, 1},
                {1, 0}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test6() {

        int[][] slot = new int[][]{{1},
                {0},
                {1},
                {0},
                {0},
                {1},
                {1}};
        int[] rotazioni = {15};
        int[][] slotRuotata = {{1},
                {1},
                {0},
                {1},
                {0},
                {0},
                {1}};
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test7() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 1, 6, 0, 3, 11};
        int[][] slotRuotata = {{0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test8() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 1, 6, 1, 3, 11};
        int[][] slotRuotata = {{0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test9() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 0, 3, 1, 4, 1};
        int[][] slotRuotata = {{0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1}};
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test10() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 0, 3, 1, 4, 1};
        int[][] slotRuotata = {{0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1}};
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 2), ris);
    }

    @Test
    public void test11() {

        int[][] slot = new int[][]{{0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}};
        int[] rotazioni = {0, 0, 3, 1, 4, 1};
        int[][] slotRuotata = {{0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 1), ris);
    }

    @Test
    public void test12() {

        int[][] slot = new int[][]{{0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0}};
        int[] rotazioni = {1, 1, 2, 3, 0, 4};
        int[][] slotRuotata = {{0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}};
        boolean ris = true;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }

    @Test
    public void test13() {

        int[][] slot = new int[][]{{0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0}};
        int[] rotazioni = {1, 1, 2, 3, 0, 4};
        int[][] slotRuotata = {{0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 2), ris);
    }

    @Test
    public void test14() {

        int[][] slot = new int[][]{{0, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0}};
        int[] rotazioni = {2, 1, 2, 3, 0, 4};
        int[][] slotRuotata = {{1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}};
        boolean ris = false;
        assertEquals(test.partitaCompleta(slot, rotazioni, 3), ris);
    }
}
