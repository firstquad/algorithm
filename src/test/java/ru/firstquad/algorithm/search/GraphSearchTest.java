package ru.firstquad.algorithm.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.firstquad.algorithm.structure.Graph;

import java.util.Arrays;
import java.util.List;

import static ru.firstquad.algorithm.search.GraphSearch.getShortestPathTo;

/**
 * Created by DVFirstov
 */
public class GraphSearchTest {
    Graph g;

    @Before
    public void setUp() throws Exception {

        List<Graph.Node> c1 = Arrays.asList(
                new Graph.Node(231),
                new Graph.Node(234),
                new Graph.Node(6));
        Graph.Node n1 = new Graph.Node(456, c1);

        List<Graph.Node> c2 = Arrays.asList(
                n1,
                new Graph.Node(678),
                new Graph.Node(1),
                new Graph.Node(225));
        Graph.Node n2 = new Graph.Node(5, c2);

        List<Graph.Node> c3 = Arrays.asList(
                n2,
                new Graph.Node(54),
                new Graph.Node(24),
                new Graph.Node(32));

        Graph.Node n3 = new Graph.Node(9, c3);

        List<Graph.Node> c4 = Arrays.asList(
                n3,
                new Graph.Node(6),
                new Graph.Node(1679),
                new Graph.Node(298));
        Graph.Node n4 = new Graph.Node(7, c4);

        List<Graph.Node> c5 = Arrays.asList(
                n4,
                new Graph.Node(68),
                new Graph.Node(95),
                new Graph.Node(456));
        Graph.Node root = new Graph.Node(6743, c5);

        g = new Graph(root);

    }

    @Test
    public void DFS() throws Exception {
        Assert.assertEquals(6743, GraphSearch.DFS(g.getRoot(), 6743).value);
        Assert.assertEquals(231, GraphSearch.DFS(g.getRoot(), 231).value);
        Assert.assertNull(GraphSearch.DFS(g.getRoot(), 10));
    }

    @Test
    public void BFS() throws Exception {
        Assert.assertEquals(6743, GraphSearch.BFS(g.getRoot(), 6743).value);
        Assert.assertEquals(231, GraphSearch.BFS(g.getRoot(), 231).value);
        Assert.assertNull(GraphSearch.BFS(g.getRoot(), 10));
    }

    @Test
    public void dijkstra() throws Exception {
        Graph.Node n1 = new Graph.Node(3);
        Graph.Node n2 = new Graph.Node(4);
        Graph.Node n3 = new Graph.Node(56);
        Graph.Node n4 = new Graph.Node(46);
        Graph.Node n5 = new Graph.Node(769);
        Graph.Node n6 = new Graph.Node(2134);
        Graph.Node n7 = new Graph.Node(7);
        Graph.Node n8 = new Graph.Node(6);
        Graph.Node n9 = new Graph.Node(234);
        Graph.Node n10 = new Graph.Node(9);

        n1.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n2, 75),
                new Graph.Edge(n4, 140),
                new Graph.Edge(n8, 118)
        };

        n2.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n1, 75),
                new Graph.Edge(n3, 71)
        };

        n3.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n2, 71),
                new Graph.Edge(n4, 151)
        };

        n4.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n1, 140),
                new Graph.Edge(n5, 99),
                new Graph.Edge(n3, 151),
                new Graph.Edge(n6, 80),
        };

        n5.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n4, 99),
                new Graph.Edge(n10, 211)
        };

        n6.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n4, 80),
                new Graph.Edge(n7, 97),
                new Graph.Edge(n1, 146)
        };

        n7.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n6, 97),
                new Graph.Edge(n8, 101),
                new Graph.Edge(n9, 138)
        };

        n8.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n1, 118),
                new Graph.Edge(n9, 111)
        };

        n9.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n8, 111),
                new Graph.Edge(n10, 70)
        };

        n10.adjacencies = new Graph.Edge[]{
                new Graph.Edge(n7, 111),
                new Graph.Edge(n3, 70)
        };

        GraphSearch.dijkstra(n1);

        List<Graph.Node> path = getShortestPathTo(n10);
        System.out.println("Path: " + path);

        Assert.assertEquals(4, getShortestPathTo(n10).size());
    }


}