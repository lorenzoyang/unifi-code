package com.github.lorenzoyang.algorithms.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    private LinkedQueue<Integer> queue;

    @BeforeEach
    public void setup() {
        queue = new LinkedQueue<>();
    }

    @Test
    public void enqueueAddsElementToQueue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    public void dequeueRemovesElementFromQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        int removedElement = queue.dequeue();
        assertEquals(1, removedElement);
        assertEquals(1, queue.size());
    }

    @Test
    public void dequeueThrowsExceptionWhenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    public void peekReturnsFirstElementWithoutRemoving() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    public void peekThrowsExceptionWhenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
    }

    @Test
    public void sizeReturnsNumberOfElementsInQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
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
}
