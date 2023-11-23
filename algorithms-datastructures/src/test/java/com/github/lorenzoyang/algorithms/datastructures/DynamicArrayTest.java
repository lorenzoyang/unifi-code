package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    public void setup() {
        dynamicArray = new DynamicArray<>();
    }

    @Test
    public void addIncreasesSize() {
        dynamicArray.add(1);
        assertEquals(1, dynamicArray.size());
        dynamicArray.add(2);
        dynamicArray.add(3);
        assertEquals(3, dynamicArray.size());
    }

    @Test
    public void addStoresCorrectValue() {
        dynamicArray.add(1);
        assertEquals(1, dynamicArray.get(0));
        dynamicArray.add(2);
        assertEquals(2, dynamicArray.get(1));
    }

    @Test
    public void removeDecreasesSize() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.remove(0);
        assertEquals(0, dynamicArray.size());
    }

    @Test
    public void removeShiftsElements() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.remove(0);
        assertEquals(2, dynamicArray.get(0));
    }

    @Test
    public void getRetrievesCorrectValue() {
        dynamicArray.add(1);
        assertEquals(1, dynamicArray.get(0));
        dynamicArray.add(100);
        assertEquals(100, dynamicArray.get(1));
    }

    @Test
    public void setChangesValue() {
        dynamicArray.add(1);
        dynamicArray.set(0, 2);
        assertEquals(2, dynamicArray.get(0));
    }

    @Test
    public void isEmptyTest() {
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add(1);
        dynamicArray.add(2);
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.remove(0);
        dynamicArray.remove(0);
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void iteratorHasNextReturnsFalseForEmptyArray() {
        Iterator<Integer> iterator = dynamicArray.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorHasNextReturnsTrueForNonEmptyArray() {
        dynamicArray.add(1);
        Iterator<Integer> iterator = dynamicArray.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorNextReturnsCorrectValue() {
        dynamicArray.add(1);
        Iterator<Integer> iterator = dynamicArray.iterator();
        assertEquals(1, iterator.next());
    }

    @Test
    public void iteratorNextThrowsExceptionWhenNoElements() {
        Iterator<Integer> iterator = dynamicArray.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void getThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(0));
    }

    @Test
    public void setThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.set(0, 1));
    }

    @Test
    public void removeThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(0));
    }
}