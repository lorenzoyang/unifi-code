package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new LinkedList<>();
    }

    @Test
    public void addIncreasesSize() {
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void addAppendsToTail() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void getRetrievesCorrectElement() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
    }

    @Test
    public void setChangesElementValue() {
        list.add(1);
        list.set(0, 2);
        assertEquals(2, list.get(0));
    }

    @Test
    public void removeDecreasesSize() {
        list.add(1);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removeShiftsElementsLeft() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
    }

    @Test
    public void iteratorIteratesOverElements() {
        list.add(1);
        list.add(2);
        var iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void getThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void setThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 1));
    }

    @Test
    public void removeThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }
}