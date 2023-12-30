package com.github.lorenzoyang.algorithmsdatastructures.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer, String> bst;

    @BeforeEach
    public void setup() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void putAndGetInEmptyTree() {
        bst.put(1, "one");
        assertEquals("one", bst.get(1));
    }

    @Test
    public void putAndGetMultipleValues() {
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");
        assertEquals("one", bst.get(1));
        assertEquals("two", bst.get(2));
        assertEquals("three", bst.get(3));
    }

    @Test
    public void overwriteExistingValue() {
        bst.put(1, "one");
        bst.put(1, "uno");
        assertEquals("uno", bst.get(1));
    }

    @Test
    public void getFromEmptyTree() {
        assertNull(bst.get(1));
    }

    @Test
    public void getNonExistingValue() {
        bst.put(1, "one");
        assertNull(bst.get(2));
    }

    @Test
    public void deleteFromEmptyTree() {
        assertDoesNotThrow(() -> bst.delete(1));
    }

    @Test
    public void deleteNonExistingValue() {
        bst.put(1, "one");
        assertDoesNotThrow(() -> bst.delete(2));
    }

    @Test
    public void deleteExistingValue() {
        bst.put(1, "one");
        bst.delete(1);
        assertNull(bst.get(1));
    }

    @Test
    public void minAndMaxInEmptyTree() {
        assertThrows(IllegalStateException.class, () -> bst.min());
        assertThrows(IllegalStateException.class, () -> bst.max());
    }

    @Test
    public void minAndMaxInNonEmptyTree() {
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");
        assertEquals(1, bst.min());
        assertEquals(3, bst.max());
    }

    @Test
    public void deleteMinAndMaxInEmptyTree() {
        assertThrows(IllegalStateException.class, () -> bst.deleteMin());
        assertThrows(IllegalStateException.class, () -> bst.deleteMax());
    }

    @Test
    public void deleteMinAndMaxInNonEmptyTree() {
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");
        bst.deleteMin();
        assertNull(bst.get(1));
        bst.deleteMax();
        assertNull(bst.get(3));
    }
}
