package com.github.lorenzoyang.lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DecomprimiRLETest {
    private final DecomprimiRLE decomprimiRLE = new DecomprimiRLE();

    @Test
    public void test1() {
        int[] input = new int[]{0, 3, 1, 2, 0, 5, 1, 3, 0, 1};
        int[] output = new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test2() {
        int[] input = new int[]{0, 1};
        int[] output = new int[]{0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test3() {
        int[] input = new int[]{1, 1};
        int[] output = new int[]{1};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test4() {
        int[] input = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        int[] output = new int[]{1, 0, 1, 0, 1, 0, 1, 0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test5() {
        int[] input = new int[]{0, 1, 1, 2, 0, 3, 1, 4, 0, 5};
        int[] output = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test6() {
        int[] input = new int[]{0, 20};
        int[] output = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test7() {
        int[] input = new int[]{1, 10};
        int[] output = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test8() {
        int[] input = new int[]{0, 4, 1, 4, 0, 1};
        int[] output = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test9() {
        int[] input = new int[]{1, 1, 0, 4, 1, 1};
        int[] output = new int[]{1, 0, 0, 0, 0, 1};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test10() {
        int[] input = new int[]{1, 3, 0, 1, 1, 2, 0, 3, 1, 1};
        int[] output = new int[]{1, 1, 1, 0, 1, 1, 0, 0, 0, 1};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }

    @Test
    public void test11() {
        int[] input = new int[]{1, 7};
        int[] output = new int[]{1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(decomprimiRLE.decomprimiRLE(input), output);
    }
}
