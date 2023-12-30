package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

public class HeapPriorityQueueTest extends PriorityQueueTest<HeapPriorityQueue<Integer>> {
    @Override
    protected HeapPriorityQueue<Integer> createPriorityQueue() {
        return new HeapPriorityQueue<>();
    }
}

