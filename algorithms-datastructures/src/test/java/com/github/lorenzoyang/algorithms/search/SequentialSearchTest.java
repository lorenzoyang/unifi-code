package com.github.lorenzoyang.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SequentialSearchTest {

    @Test
    void search_returnsNull_whenArrayIsEmpty() {
        SequentialSearch<Integer> sequentialSearch = new SequentialSearch<>();
        Integer[] array = new Integer[0];
        Integer value = 5;
        assertNull(sequentialSearch.search(array, value));
    }

    @Test
    void search_returnsNull_whenValueIsNotInArray() {
        SequentialSearch<Integer> sequentialSearch = new SequentialSearch<>();
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 6;
        assertNull(sequentialSearch.search(array, value));
    }

    @Test
    void search_returnsValue_whenValueIsInArray() {
        SequentialSearch<Integer> sequentialSearch = new SequentialSearch<>();
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 3;
        assertEquals(value, sequentialSearch.search(array, value));
    }

    @Test
    void search_returnsFirstOccurrence_whenValueIsRepeatedInArray() {
        SequentialSearch<Integer> sequentialSearch = new SequentialSearch<>();
        Integer[] array = {1, 2, 3, 4, 5, 3};
        Integer value = 3;
        assertEquals(value, sequentialSearch.search(array, value));
    }
}