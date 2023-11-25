package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void addIncreasesSize() {
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void addAppendsToTail() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
    }

    @Test
    void getRetrievesCorrectElement() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
    }

    @Test
    void getThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void setChangesElementValue() {
        list.add(1);
        list.set(0, 2);
        assertEquals(2, list.get(0));
    }

    @Test
    void setThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 2));
    }

    @Test
    void removeDecreasesSize() {
        list.add(1);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void removeThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void removeShiftsElements() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
    }
}