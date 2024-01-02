package com.github.lorenzoyang.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    public void iterativeSearchFindsTargetInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        int result = BinarySearch.iterativeSearch(array, 3);
        assertEquals(2, result);
    }

    @Test
    public void iterativeSearchReturnsMinusOneWhenTargetNotInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        int result = BinarySearch.iterativeSearch(array, 6);
        assertEquals(-1, result);
    }

    @Test
    public void recursiveSearchFindsTargetInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        int result = BinarySearch.recursiveSearch(array, 3);
        assertEquals(2, result);
    }

    @Test
    public void recursiveSearchReturnsMinusOneWhenTargetNotInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        int result = BinarySearch.recursiveSearch(array, 6);
        assertEquals(-1, result);
    }

    @Test
    public void iterativeSearchWorksOnEmptyArray() {
        Integer[] array = {};
        int result = BinarySearch.iterativeSearch(array, 3);
        assertEquals(-1, result);
    }

    @Test
    public void recursiveSearchWorksOnEmptyArray() {
        Integer[] array = {};
        int result = BinarySearch.recursiveSearch(array, 3);
        assertEquals(-1, result);
    }

    @Test
    public void iterativeSearchWorksOnNonSortedArray() {
        Integer[] array = {5, 4, 3, 2, 1};
        int result = BinarySearch.iterativeSearch(array, 3);
        assertEquals(2, result);
    }

    @Test
    public void recursiveSearchWorksOnNonSortedArray() {
        Integer[] array = {5, 4, 3, 2, 1};
        int result = BinarySearch.recursiveSearch(array, 3);
        assertEquals(2, result);
    }
}
