package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

public class UnorderedArrayPriorityQueueTest extends PriorityQueueTest<UnorderedArrayPriorityQueue<Integer>> {
    @Override
    protected UnorderedArrayPriorityQueue<Integer> createPriorityQueue() {
        return new UnorderedArrayPriorityQueue<>();
    }
}
