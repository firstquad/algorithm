package ru.firstquad.algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DVFirstov 29.07.18
 */
public class SkipList {
    private SkipListNode head;
    private int maxLevel;
    private int size;
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        size = 0;
        maxLevel = 0;
        head = new SkipListNode(null);
        head.nextNodes.add(null);
    }

    public boolean add(Integer e) {
        if (contains(e)) return false;
        size++;
        int level = 0;
        while (Math.random() < PROBABILITY)
            level++;

        while (level > maxLevel) {
            head.nextNodes.add(null);
            maxLevel++;
        }

        SkipListNode newNode = new SkipListNode(e);
        SkipListNode current = head;
        do {
            current = findNext(e, current, level);
            newNode.nextNodes.add(0, current.nextNodes.get(level));
            current.nextNodes.set(level, newNode);
        } while (level-- > 0);

        return true;
    }

    private SkipListNode find(Integer e) {
        return find(e, head, maxLevel);
    }

    private SkipListNode find(Integer e, SkipListNode current, int level) {
        do {
            current = findNext(e, current, level);
        } while (level-- > 0);
        return current;
    }

    private SkipListNode findNext(Integer e, SkipListNode current, int level) {
        SkipListNode next = current.nextNodes.get(level);
        while (next != null) {
            Integer value = next.getValue();
            if (lessThan(e, value)) // e < value
                break;
            current = next;
            next = current.nextNodes.get(level);
        }
        return current;
    }

    public boolean contains(Object o) {
        Integer e = (Integer) o;
        SkipListNode node = find(e);
        return node != null &&
                node.getValue() != null &&
                equalTo(node.getValue(), e);
    }

    private boolean lessThan(Integer a, Integer b) {
        return a.compareTo(b) < 0;
    }

    private boolean equalTo(Integer a, Integer b) {
        return a.compareTo(b) == 0;
    }

    private boolean greaterThan(Integer a, Integer b) {
        return a.compareTo(b) > 0;
    }

    public class SkipListNode {
        private Integer value;
        public List<SkipListNode> nextNodes;

        public Integer getValue() {
            return value;
        }

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<>();
        }

        public int level() {
            return nextNodes.size() - 1;
        }

        public String toString() {
            return "SLN: " + value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SkipListNode currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.nextNodes.toString()).append("\n");
            currentNode = currentNode.nextNodes.get(0);
        }
        return sb.toString();
    }
}