package ru.firstquad.algorithm.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dima on 22.06.2015.
 */
public class LinkedList implements Iterable<Integer> {
    private Node head;

    private class Node {
        int item;
        Node next;

        Node(int item) {
            this.item = item;
        }
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public void addLast(int i) {
        if (isEmpty()) {
            head = new Node(i);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(i);
    }

    public void addFirst(int i) {
        if (isEmpty()) {
            head = new Node(i);
            return;
        }
        Node newHead = new Node(i);
        newHead.next = head;
        head = newHead;
    }

    public LinkedList getReversed() {
        LinkedList reversed = new LinkedList();
        for (int i : this) {
            reversed.addFirst(i);
        }
        return reversed;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIter(head);
    }

    public class LinkedListIter implements Iterator<Integer> {
        private Node last;

        public LinkedListIter(Node last) {
            this.last = last;
        }

        @Override
        public boolean hasNext() {
            return last != null;
        }

        @Override
        public Integer next() {
            if (last == null)
                throw new NoSuchElementException();
            Node next = last;
            last = last.next;
            return next.item;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : this) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }


}
