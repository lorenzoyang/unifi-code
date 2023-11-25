package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DynamicArrayTest {
    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    void setUp() {
        dynamicArray = new DynamicArray<>();
    }

    @Test
    void addIncreasesSize() {
        dynamicArray.add(1);
        assertEquals(1, dynamicArray.size());
    }

    @Test
    void addResizesArray() {
        for (int i = 0; i < 11; i++) {
            dynamicArray.add(i);
        }
        assertEquals(11, dynamicArray.size());
    }

    @Test
    void getRetrievesElement() {
        dynamicArray.add(1);
        assertEquals(Integer.valueOf(1), dynamicArray.get(0));
    }

    @Test
    void getThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(0));
    }

    @Test
    void setChangesElement() {
        dynamicArray.add(1);
        dynamicArray.set(0, 2);
        assertEquals(Integer.valueOf(2), dynamicArray.get(0));
    }

    @Test
    void setThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.set(0, 2));
    }

    @Test
    void removeDecreasesSize() {
        dynamicArray.add(1);
        dynamicArray.remove(0);
        assertEquals(0, dynamicArray.size());
    }

    @Test
    void removeThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(0));
    }
}