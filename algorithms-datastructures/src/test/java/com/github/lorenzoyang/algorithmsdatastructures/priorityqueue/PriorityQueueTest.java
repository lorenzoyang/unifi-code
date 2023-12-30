package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class PriorityQueueTest<T extends PriorityQueue<Integer>> {
    private T priorityQueue;

    protected abstract T createPriorityQueue();

    @BeforeEach
    public void setUp() {
        priorityQueue = createPriorityQueue();
    }

    @Test
    void insertIncreasesSize() {
        priorityQueue.insert(5);
        assertEquals(1, priorityQueue.size());
    }

    @Test
    void insertMaintainsMaxPriority() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        assertEquals(10, priorityQueue.max());
        priorityQueue.insert(15);
        priorityQueue.insert(2);
        assertEquals(15, priorityQueue.max());

    }

    @Test
    void removeDecreasesSize() {
        priorityQueue.insert(5);
        priorityQueue.remove();
        assertEquals(0, priorityQueue.size());
    }

    @Test
    void removeReturnsMaxPriority() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        assertEquals(10, priorityQueue.remove());
        priorityQueue.insert(15);
        priorityQueue.insert(2);
        assertEquals(15, priorityQueue.remove());
    }

    @Test
    void removeThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> priorityQueue.remove());
    }

    @Test
    void maxReturnsMaxPriority() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        assertEquals(10, priorityQueue.max());
        priorityQueue.insert(89);
        priorityQueue.insert(2);
        assertEquals(89, priorityQueue.max());
    }

    @Test
    void maxThrowsExceptionWhenEmpty() {
        assertThrows(IllegalStateException.class, () -> priorityQueue.max());
    }

    @Test
    void sizeReturnsCorrectSize() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        assertEquals(2, priorityQueue.size());
        priorityQueue.insert(89);
        priorityQueue.insert(2);
        assertEquals(4, priorityQueue.size());
        priorityQueue.remove();
        assertEquals(3, priorityQueue.size());
    }

    @Test
    void isEmptyReturnsTrueWhenEmpty() {
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    void isEmptyReturnsFalseWhenNotEmpty() {
        priorityQueue.insert(5);
        assertFalse(priorityQueue.isEmpty());
    }
}
