package ru.firstquad.algorithm.structure;

import java.util.Arrays;

/**
 * Created by DVFirstov 27.07.18
 */
public class Heap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    private void swap(int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0)
            throw new IllegalStateException();
        int out = items[0];
        items[0] = items[size - 1];
        items[size - 1] = 0;
        size--;
        heapifyDown();
        return out;
    }

    public void add(int value) {
        ensureCapacity();
        items[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int currentIdx = size - 1;
        while (hasParent(currentIdx) && getParent(currentIdx) > items[currentIdx]) {
            swap(getParentIndex(currentIdx), currentIdx);
            currentIdx = getParentIndex(currentIdx);
        }
    }

    private void heapifyDown() {
        int currentInx = 0;
        while (hasLeft(currentInx)) {
            int smallerIndex = getLeftIndex(currentInx);
            if (hasRight(currentInx) && getRightChildren(currentInx) < getLeftChildren(currentInx)) {
                smallerIndex = getRightIndex(currentInx);
            }
            if (items[currentInx] < items[smallerIndex]) {
                break;
            } else {
                swap(currentInx, smallerIndex);
            }
            currentInx = smallerIndex;
        }
    }

    public void ensureCapacity() {
        if (capacity == size) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    public int getLeftIndex(int parentIndx) {
        return parentIndx * 2 + 1;
    }

    public int getRightIndex(int parentIndx) {
        return parentIndx * 2 + 2;
    }

    public int getParentIndex(int childIndx) {
        return (childIndx - 1) / 2;
    }

    public int getLeftChildren(int parentIndx) {
        return items[getLeftIndex(parentIndx)];
    }

    public int getRightChildren(int parentIndx) {
        return items[getRightIndex(parentIndx)];
    }

    public int getParent(int childIndx) {
        return items[getParentIndex(childIndx)];
    }

    public boolean hasLeft(int indx) {
        return getLeftIndex(indx) < size;
    }

    public boolean hasRight(int indx) {
        return getRightIndex(indx) < size;
    }

    public boolean hasParent(int indx) {
        return getParentIndex(indx) >= 0;
    }

    public int[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
