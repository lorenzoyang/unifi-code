package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

public class UnorderedArrayPriorityQueueTest extends PriorityQueueTest<UnorderedArrayPriorityQueue<Integer>> {
    @Override
    protected UnorderedArrayPriorityQueue<Integer> createPriorityQueue() {
        return new UnorderedArrayPriorityQueue<>();
    }
}
