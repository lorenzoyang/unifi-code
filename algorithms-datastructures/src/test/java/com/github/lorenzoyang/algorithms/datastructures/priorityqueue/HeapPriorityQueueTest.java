package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

public class HeapPriorityQueueTest extends PriorityQueueTest<HeapPriorityQueue<Integer>> {
    @Override
    protected HeapPriorityQueue<Integer> createPriorityQueue() {
        return new HeapPriorityQueue<>();
    }
}

