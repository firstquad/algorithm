package ru.firstquad.algorithm.structure;

/**
 * Created by DVFirstov 27.07.18
 */
public class Tries {
    private Node root = new Node();

    public void add(String s) {
        Node next = root;
        for (char c : s.toCharArray()) {
            int charIndex = getCharIndex(c);
            if (next.children[charIndex] == null) {
                next.addChild(c);
            }
            next.incrementSize();
            next = next.children[charIndex];
        }
    }

    public int childrenCount(String prefix) {
        return root.childrenCount(prefix, 0);
    }

    private class Node {
        private int NUMBER_OF_CHARACTERS = 26;
        private Node[] children = new Node[NUMBER_OF_CHARACTERS];
        private char value;
        private int size;

        public Node() {
        }

        public Node(char value) {
            this.value = value;
        }

        public void addChild(char c) {
            children[getCharIndex(c)] = new Node(c);
        }

        public void incrementSize() {
            size++;
        }

        public int getSize() {
            return size;
        }

        private int childrenCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }
            Node child = children[getCharIndex(s.charAt(index))];
            if (child == null) {
                return 0;
            }
            return child.childrenCount(s, index + 1);
        }
    }

    private int getCharIndex(char c) {
        return c - 'a';
    }

}
