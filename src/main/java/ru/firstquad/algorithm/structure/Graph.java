package ru.firstquad.algorithm.structure;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.compare;

/**
 * Created by DVFirstov
 */
public class Graph {
    private Node root;

    public Graph(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public static class Node implements Comparable<Node> {
        public int value;
        public List<Node> children = new ArrayList<>();

        /**
         * for Dijkstra algorithm
         */
        public Edge[] adjacencies;
        public int shortestDistance = Integer.MAX_VALUE;
        public Node parent;

        public Node(int value, List<Node> children, int shortestDistance) {
            this.value = value;
            this.shortestDistance = shortestDistance;
            this.children = children;
        }

        public Node(int value, List<Node> children) {
            this.value = value;
            this.children = children;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return compare(this.shortestDistance, o.shortestDistance);
        }
    }

    /**
     * for Dijkstra algorithm
     */
    public static class Edge {
        public final Node target;
        public final int weight;

        public Edge(Node targetNode, int weightVal) {
            target = targetNode;
            weight = weightVal;
        }
    }
}
