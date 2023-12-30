package com.github.lorenzoyang.algorithmsdatastructures.search;

import com.github.lorenzoyang.algorithmsdatastructures.DynamicArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequentialSearchTest {
    @Test
    void search_returnsNegative_whenArrayIsEmpty() {
        Integer[] array = new Integer[0];
        Integer value = 5;
        assertEquals(-1, SequentialSearch.search(array, value));
    }

    @Test
    void search_returnsNegative_whenValueIsNotInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 6;
        assertEquals(-1, SequentialSearch.search(array, value));
    }

    @Test
    void search_returnsIndex_whenValueIsInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 3;
        assertEquals(2, SequentialSearch.search(array, value));
    }

    @Test
    void search_returnsFirstOccurrenceIndex_whenValueIsRepeatedInArray() {
        Integer[] array = {1, 2, 3, 4, 5, 3};
        Integer value = 3;
        assertEquals(2, SequentialSearch.search(array, value));
    }

    @Test
    void searchWithDynamicArray_returnsNegative_whenArrayIsEmpty() {
        DynamicArray<Integer> array = new DynamicArray<>();
        Integer value = 5;
        assertEquals(-1, SequentialSearch.search(array, value));
    }

    @Test
    void searchWithDynamicArray_returnsNegative_whenValueIsNotInArray() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        Integer value = 6;
        assertEquals(-1, SequentialSearch.search(array, value));
    }

    @Test
    void searchWithDynamicArray_returnsIndex_whenValueIsInArray() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        Integer value = 3;
        assertEquals(2, SequentialSearch.search(array, value));
    }

    @Test
    void searchWithDynamicArray_returnsFirstOccurrenceIndex_whenValueIsRepeatedInArray() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        array.insert(5, 3);
        Integer value = 3;
        assertEquals(2, SequentialSearch.search(array, value));
    }

    @Test
    void searchSentinel_returnsNegative_whenArrayIsEmpty() {
        Integer[] array = new Integer[0];
        Integer value = 5;
        assertEquals(-1, SequentialSearch.searchSentinel(array, value));
    }

    @Test
    void searchSentinel_returnsNegative_whenValueIsNotInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 6;
        assertEquals(-1, SequentialSearch.searchSentinel(array, value));
    }

    @Test
    void searchSentinel_returnsIndex_whenValueIsInArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 3;
        assertEquals(2, SequentialSearch.searchSentinel(array, value));
    }

    @Test
    void searchSentinel_returnsFirstOccurrenceIndex_whenValueIsRepeatedInArray() {
        Integer[] array = {1, 2, 3, 4, 5, 3};
        Integer value = 3;
        assertEquals(2, SequentialSearch.searchSentinel(array, value));
    }

    @Test
    void searchSentinel_returnsLastIndex_whenValueIsLastElement() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer value = 5;
        assertEquals(4, SequentialSearch.searchSentinel(array, value));
    }
}