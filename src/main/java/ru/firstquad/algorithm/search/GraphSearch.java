package ru.firstquad.algorithm.search;

import ru.firstquad.algorithm.structure.Graph;

import java.util.*;

/**
 * Created by DVFirstov
 */
public class GraphSearch {

    /**
     * O(V + E)
     */
    public static Graph.Node DFS(Graph.Node n, int value) {
        return DFS(n, value, new HashSet<>());
    }

    private static Graph.Node DFS(Graph.Node n, int value, Set<Graph.Node> visited) {
        if (visited.contains(n)) {
            return n;
        }
        if (n.value == value) {
            return n;
        }
        visited.add(n);
        List<Graph.Node> children = n.children;
        for (Graph.Node child : children) {
            Graph.Node targetNode = DFS(child, value, visited);
            if (targetNode != null) {
                return targetNode;
            }
        }
        return null;
    }

    /**
     * O(V + E)
     */
    public static Graph.Node BFS(Graph.Node n, int value) {
        Set<Graph.Node> visited = new HashSet<>();
        Queue<Graph.Node> nextToVisit = new ArrayDeque<>();
        nextToVisit.add(n);
        while (!nextToVisit.isEmpty()) {
            Graph.Node nextNode = nextToVisit.remove();
            if (nextNode.value == value) {
                return nextNode;
            }
            if (visited.contains(nextNode)) {
                continue;
            }
            visited.add(nextNode);
            nextToVisit.addAll(nextNode.children);
        }
        return null;
    }

    /**
     * O(V * log(V) + E * log(V)).
     */
    public static void dijkstra(Graph.Node n) {
        n.shortestDistance = 0;
        Queue<Graph.Node> nextToVisit = new PriorityQueue<>();
        nextToVisit.add(n);

        while (!nextToVisit.isEmpty()) {
            Graph.Node nextNode = nextToVisit.remove();

            for (Graph.Edge e : nextNode.adjacencies) {
                Graph.Node v = e.target;
                int weight = e.weight;

                int distanceFromU = nextNode.shortestDistance + weight;
                if (distanceFromU < v.shortestDistance) {
                    nextToVisit.remove(v);
                    v.shortestDistance = distanceFromU;
                    v.parent = nextNode;
                    nextToVisit.add(v);
                }
            }
        }
    }

    public static List<Graph.Node> getShortestPathTo(Graph.Node target) {
        List<Graph.Node> path = new ArrayList<>();
        for (Graph.Node node = target; node != null; node = node.parent) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }
}
