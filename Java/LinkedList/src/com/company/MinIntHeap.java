package com.company;

import java.util.Arrays;

public class MinIntHeap {
    private static int capacity = 10;
    private static int size = 0;
    private static int[] items = new int[capacity];

    public static void main(String[] args) {
        MinIntHeap heap = new MinIntHeap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        heap.add(10);
        heap.add(9);
        printHeap(heap);
        System.out.println("poll");
        poll();
        printHeap(heap);
    }

    private static void printHeap(MinIntHeap heap) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < heap.size; i++) {
            builder.append(heap.items[i] + ",");
        }
        System.out.println(builder.toString());
    }

    private static int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private static int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private static boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private static boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) < size;
    }

    private static int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private static int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public static int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size - 1];
        heapifyDown();
        return item;
    }

    private static void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private static void swap(int indexOne, int indexTwo) {
        int oldIndexOne = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = oldIndexOne;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }
}
