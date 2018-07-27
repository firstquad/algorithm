package ru.firstquad.algorithm.structure;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by DVFirstov 27.07.18
 */
public class HeapTest {

    @Test
    public void peek() {
        Heap h = fillHeap();
        h.peek();
        h.peek();
        assertArrayEquals(new int[]{1, 2, 3, 6, 7, 0, 0, 0, 0, 0}, h.getItems());
    }

    @Test
    public void poll() {
        Heap h = fillHeap();
        h.poll();
        h.poll();
        assertArrayEquals(new int[]{3, 6, 7, 0, 0, 0, 0, 0, 0, 0}, h.getItems());
    }

    @Test
    public void add() {
        Heap h = fillHeap();
        assertArrayEquals(new int[]{1, 2, 3, 6, 7, 0, 0, 0, 0, 0}, h.getItems());
    }

    public Heap fillHeap() {
        Heap h = new Heap();
        h.add(3);
        h.add(6);
        h.add(2);
        h.add(1);
        h.add(7);
        return h;
    }
}