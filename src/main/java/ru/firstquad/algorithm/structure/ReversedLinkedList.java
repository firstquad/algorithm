package ru.firstquad.algorithm.structure;

public class ReversedLinkedList {
    private Node head;
    private Node tail;

    public class Node {
        private Object value;
        private Node nextValue;
    }

    public void addFIFO(Object value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.nextValue = tail;
        } else {
            tail.nextValue = newNode;
            tail = newNode;
        }
    }

    public void addLIFO(Object value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.nextValue = tail;
        } else {
            newNode.nextValue = head;
            head = newNode;
        }
    }

    public ReversedLinkedList getReversed() {
        if (head == null || head.nextValue == null)
            return this;
        ReversedLinkedList reversedList = new ReversedLinkedList();
        Node tmp = head;
        while (tmp != null) {
            reversedList.addLIFO(tmp.value);
            tmp = tmp.nextValue;
        }
        return reversedList;
    }
}
