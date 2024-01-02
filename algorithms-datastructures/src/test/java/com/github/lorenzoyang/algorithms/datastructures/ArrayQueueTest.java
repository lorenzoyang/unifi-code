package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    private ArrayQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new ArrayQueue<>();
    }

    @Test
    public void enqueueIncreasesSize() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    public void dequeueDecreasesSize() {
        queue.enqueue(1);
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void dequeueReturnsCorrectElement() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void peekReturnsCorrectElementWithoutRemoving() {
        queue.enqueue(1);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    public void isEmptyReturnsTrueWhenQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseWhenQueueIsNotEmpty() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void dequeueThrowsExceptionWhenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    public void peekThrowsExceptionWhenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
    }

    @Test
    public void queueResizesCorrectly() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, queue.dequeue());
        }
    }
}
