package com.github.lorenzoyang.algorithmsdatastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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
    void removeShiftsElements() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.remove(0);
        assertEquals(Integer.valueOf(2), dynamicArray.get(0));
    }

    @Test
    void removeThrowsExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(0));
    }


    @Test
    void insertIncreasesSizeAndShiftsElements() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.insert(1, 3);
        assertEquals(3, dynamicArray.size());
        assertEquals(Integer.valueOf(1), dynamicArray.get(0));
        assertEquals(Integer.valueOf(3), dynamicArray.get(1));
        assertEquals(Integer.valueOf(2), dynamicArray.get(2));
    }

    @Test
    void insertThrowsExceptionForInvalidIndex() {
        dynamicArray.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(2, 2));
    }

    @Test
    void resizeIncreasesCapacity() {
        for (int i = 0; i < 15; i++) {
            dynamicArray.add(i);
        }
        assertEquals(15, dynamicArray.size());
    }

    @Test
    void resizeDecreasesCapacity() {
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
        for (int i = 0; i < 8; i++) {
            dynamicArray.remove(0);
        }
        assertEquals(2, dynamicArray.size());
    }

    @Test
    void isEmptyReturnsTrueWhenEmpty() {
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseWhenNotEmpty() {
        dynamicArray.add(1);
        assertFalse(dynamicArray.isEmpty());
    }

    @Test
    void capacityReturnsCorrectCapacity() {
        assertEquals(10, dynamicArray.capacity());
        dynamicArray.add(1);
        assertEquals(10, dynamicArray.capacity());
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
        assertTrue(dynamicArray.capacity() > 10);
    }

    @Test
    void iteratorHasNextReturnsFalseWhenEmpty() {
        assertFalse(dynamicArray.iterator().hasNext());
    }

    @Test
    void iteratorHasNextReturnsTrueWhenNotEmpty() {
        dynamicArray.add(1);
        assertTrue(dynamicArray.iterator().hasNext());
    }

    @Test
    void iteratorNextReturnsCorrectElement() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        Iterator<Integer> iterator = dynamicArray.iterator();
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
    }

    @Test
    void iteratorNextThrowsExceptionWhenNoMoreElements() {
        dynamicArray.add(1);
        Iterator<Integer> iterator = dynamicArray.iterator();
        iterator.next();
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}