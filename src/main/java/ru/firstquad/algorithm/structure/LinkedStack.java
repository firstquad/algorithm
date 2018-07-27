package ru.firstquad.algorithm.structure;

/**
 * Created by Dima on 22.06.2015.
 */
public class LinkedStack {
    private Node node;

    private class Node {
        int item;
        Node next;
    }

    public void push(int item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = node;
        node = newNode;
    }

    public int pop() {
        int item = node.item;
        node = node.next;
        return item;
    }

    public Boolean isEmpty() {
        return node == null;
    }
}
