package ru.firstquad.algorithm.structure;

/**
 * Created by Dima on 05.07.2015.
 */
public class LinkedQueue {
    private Node head, tail;

    private class Node {
        int item;
        Node next;
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item) {
        Node oldLast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty())
            head = tail;
        else
            oldLast.next = tail;
    }

    public int getHead() {
        int item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null;
        return item;
    }
}
