package com.github.lorenzoyang.lab09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccoppiataTest {
    private final Accoppiata accoppiata = new Accoppiata();

    @Test
    public void test1() {
        char[] A = new char[]{'m', 'a', 't', 'r', 'i', 'x', 'm', 'a', 't', 'r', 'i', 'x'};
        assertTrue(accoppiata.accoppiata(A));
    }

    @Test
    public void test2() {

        char[] A = new char[]{'m', 'a', 't', 'r', 'i', 'x'};
        assertFalse(accoppiata.accoppiata(A));

    }

    @Test
    public void test3() {

        char[] A = new char[]{'m', 'm'};
        assertTrue(accoppiata.accoppiata(A));

    }

    @Test
    public void test4() {

        char[] A = new char[]{'a'};
        assertFalse(accoppiata.accoppiata(A));

    }

    @Test
    public void test5() {

        char[] A = new char[]{'m', 'm', 'm', 'x'};
        assertFalse(accoppiata.accoppiata(A));

    }
}