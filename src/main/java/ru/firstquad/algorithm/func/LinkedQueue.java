package ru.firstquad.algorithm.func;

/**
 * Created by Dima on 05.07.2015.
 */
public class LinkedQueue {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
