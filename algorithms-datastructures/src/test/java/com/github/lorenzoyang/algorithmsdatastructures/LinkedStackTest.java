package com.github.lorenzoyang.algorithmsdatastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedStackTest {
    private LinkedStack<Integer> stack;

    @BeforeEach
    public void setup() {
        stack = new LinkedStack<>();
    }

    @Test
    public void pushIncreasesStackSize() {
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    public void popDecreasesStackSize() {
        stack.push(1);
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void popReturnsCorrectElement() {
        stack.push(1);
        int poppedElement = stack.pop();
        assertEquals(1, poppedElement);
    }

    @Test
    public void peekReturnsTopElementWithoutRemovingIt() {
        stack.push(1);
        int peekedElement = stack.peek();
        assertEquals(1, peekedElement);
        assertEquals(1, stack.size());
    }

    @Test
    public void popOnEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void peekOnEmptyStackThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }
}