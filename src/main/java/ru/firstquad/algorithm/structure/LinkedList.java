package ru.firstquad.algorithm.structure;

/**
 * Created by Dima on 22.06.2015.
 */
public class LinkedList {
    private Node first, last;

    private class Node {
        int item;
        Node next;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public void enqueue(int item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public int dequeue() {
        int item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
