package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    private PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    public void setup() {
        priorityQueue = new PriorityQueue<>();
    }

    @Test
    public void insertIncreasesSize() {
        priorityQueue.insert(5);
        assertEquals(1, priorityQueue.size());
    }

    @Test
    public void insertMaintainsMaxPriority() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        assertEquals(10, priorityQueue.max());
    }

    @Test
    public void delMaxDecreasesSize() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        priorityQueue.delMax();
        assertEquals(1, priorityQueue.size());
    }

    @Test
    public void delMaxRemovesMaxPriority() {
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        priorityQueue.delMax();
        assertEquals(5, priorityQueue.max());
    }

    @Test
    public void delMaxOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> priorityQueue.delMax());
    }

    @Test
    public void maxOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> priorityQueue.max());
    }

    @Test
    public void isEmptyReturnsTrueOnEmpty() {
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseWhenNotEmpty() {
        priorityQueue.insert(5);
        assertFalse(priorityQueue.isEmpty());
    }
}
