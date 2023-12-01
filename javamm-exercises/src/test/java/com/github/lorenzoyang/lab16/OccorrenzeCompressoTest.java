package com.github.lorenzoyang.lab16;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class OccorrenzeCompressoTest {
    private final OccorrenzeCompresso test = new OccorrenzeCompresso();

    @Test
    public void test1() {
        int[] input = {1, 0, 3, 4, 1, 4};
        int[] expected = {1, 2, 1, 2};
        int[] actual = test.occorrenzeCompresso(input);
        assertArrayEquals(expected, actual);
    }
}
