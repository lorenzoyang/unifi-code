package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapPriorityQueueTest {
    private HeapPriorityQueue<Integer> heapPriorityQueue;

    @BeforeEach
    void setUp() {
        heapPriorityQueue = new HeapPriorityQueue<>();
    }

    @Test
    void insertIncreasesSize() {
        heapPriorityQueue.insert(5);
        assertEquals(1, heapPriorityQueue.size());
    }

    @Test
    void insertMaintainsMaxPriority() {
        heapPriorityQueue.insert(5);
        heapPriorityQueue.insert(10);
        assertEquals(10, heapPriorityQueue.max());
        heapPriorityQueue.insert(15);
        heapPriorityQueue.insert(2);
        assertEquals(15, heapPriorityQueue.max());

    }

    @Test
    void removeDecreasesSize() {
        heapPriorityQueue.insert(5);
        heapPriorityQueue.remove();
        assertEquals(0, heapPriorityQueue.size());
    }

    @Test
    void removeReturnsMaxPriority() {
        heapPriorityQueue.insert(5);
        heapPriorityQueue.insert(10);
        assertEquals(10, heapPriorityQueue.remove());
        heapPriorityQueue.insert(15);
        heapPriorityQueue.insert(2);
        assertEquals(15, heapPriorityQueue.remove());
    }

    @Test
    void removeThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> heapPriorityQueue.remove());
    }

    @Test
    void maxReturnsMaxPriority() {
        heapPriorityQueue.insert(5);
        heapPriorityQueue.insert(10);
        assertEquals(10, heapPriorityQueue.max());
        heapPriorityQueue.insert(89);
        heapPriorityQueue.insert(2);
        assertEquals(89, heapPriorityQueue.max());
    }

    @Test
    void maxThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> heapPriorityQueue.max());
    }

    @Test
    void sizeReturnsCorrectSize() {
        heapPriorityQueue.insert(5);
        heapPriorityQueue.insert(10);
        assertEquals(2, heapPriorityQueue.size());
        heapPriorityQueue.insert(89);
        heapPriorityQueue.insert(2);
        assertEquals(4, heapPriorityQueue.size());
        heapPriorityQueue.remove();
        assertEquals(3, heapPriorityQueue.size());
    }

    @Test
    void isEmptyReturnsTrueWhenEmpty() {
        assertTrue(heapPriorityQueue.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseWhenNotEmpty() {
        heapPriorityQueue.insert(5);
        assertFalse(heapPriorityQueue.isEmpty());
    }
}
