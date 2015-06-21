package ru.firstquad.algorithm.func;

/**
 * Created by Dima on 22.06.2015.
 */
public class LinkedStack {
    Node node;

    private class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = this.node;
        this.node = newNode;
    }

    public String pop() {
        String item = node.item;
        this.node = node.next;
        return item;
    }

    public Boolean isEmpty() {
        return node == null;
    }
}
