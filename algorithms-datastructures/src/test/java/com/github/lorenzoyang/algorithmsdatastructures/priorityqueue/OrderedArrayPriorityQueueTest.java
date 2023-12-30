package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

public class OrderedArrayPriorityQueueTest extends PriorityQueueTest<OrderedArrayPriorityQueue<Integer>> {
    @Override
    protected OrderedArrayPriorityQueue<Integer> createPriorityQueue() {
        return new OrderedArrayPriorityQueue<>();
    }
}
