package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

public class OrderedArrayPriorityQueueTest extends PriorityQueueTest<OrderedArrayPriorityQueue<Integer>> {
    @Override
    protected OrderedArrayPriorityQueue<Integer> createPriorityQueue() {
        return new OrderedArrayPriorityQueue<>();
    }
}
