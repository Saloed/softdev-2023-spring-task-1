package task1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedGraphTest {

    @Test
    public void testVertexAdding() {
        DirectedGraph directedGraph = new DirectedGraph();

        boolean result1 = directedGraph.addVertex("a");
        boolean result2 = directedGraph.addVertex("a");

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testEdgeAdding() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");

        boolean result1 = directedGraph.addEdge("a", "b", 3);
        boolean result2 = directedGraph.addEdge("a", "c", 4);
        boolean result3 = directedGraph.addEdge("a", "b", 10);

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }

    @Test
    public void testVertexRemoving() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");

        boolean result1 = directedGraph.removeVertex("a");
        boolean result2 = directedGraph.removeVertex("B");

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testEdgeRemoving() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");

        directedGraph.addEdge("a", "b", 5);
        directedGraph.addEdge("a","c",6);

        boolean result1 = directedGraph.removeEdge("a", "b");
        boolean result2 = directedGraph.removeEdge("c", "a");
        boolean result3 = directedGraph.removeEdge("a", "c");

        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }

    @Test
    public void testNameChanging() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");

        directedGraph.addEdge("a", "b", 5);
        directedGraph.addEdge("a","c",6);

        boolean result1 = directedGraph.changeName("a", "A");
        boolean result2 = directedGraph.changeName("a", "A");

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testWeightChanging() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");

        directedGraph.addEdge("b", "a", 5);

        boolean result1 = directedGraph.changeWeight("b", "a", 7);
        boolean result2 = directedGraph.changeWeight("b", "a", -7);
        boolean result3 = directedGraph.changeWeight("a", "b", 10);

        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    public void testInsGetting() {
        DirectedGraph directedGraph = new DirectedGraph();

        Edge edge1 = new Edge("a", "b", 5);
        Edge edge2 = new Edge("a","c",8);
        Edge edge3 = new Edge("c", "b", 6);
        Edge edge4 = new Edge("d", "c", 15);

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");

        directedGraph.addEdge("a", "b", 5);
        directedGraph.addEdge("a","c",8);
        directedGraph.addEdge("c","b",6);
        directedGraph.addEdge("d","c",15);

        Set<Edge> resultA = new HashSet<>();
        Set<Edge> resultB = new HashSet<>();
        Set<Edge> resultC = new HashSet<>();
        Set<Edge> resultD = new HashSet<>();

        resultB.add(edge1);
        resultB.add(edge3);
        resultC.add(edge2);
        resultC.add(edge4);

        assertEquals(resultA, directedGraph.getIns("a"));
        assertEquals(resultB, directedGraph.getIns("b"));
        assertEquals(resultC, directedGraph.getIns("c"));
        assertEquals(resultD, directedGraph.getIns("d"));
    }

    @Test
    public void testOutsGetting() {
        DirectedGraph directedGraph = new DirectedGraph();

        Edge edge1 = new Edge("a", "b", 5);
        Edge edge2 = new Edge("a","c",8);
        Edge edge3 = new Edge("c", "b", 6);
        Edge edge4 = new Edge("d", "c", 15);

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");

        directedGraph.addEdge("a", "b", 5);
        directedGraph.addEdge("a","c",8);
        directedGraph.addEdge("c","b",6);
        directedGraph.addEdge("d","c",15);

        Set<Edge> resultA = new HashSet<>();
        Set<Edge> resultB = new HashSet<>();
        Set<Edge> resultC = new HashSet<>();
        Set<Edge> resultD = new HashSet<>();

        resultA.add(edge1);
        resultA.add(edge2);
        resultC.add(edge3);
        resultD.add(edge4);

        assertEquals(resultA, directedGraph.getOuts("a"));
        assertEquals(resultB, directedGraph.getOuts("b"));
        assertEquals(resultC, directedGraph.getOuts("c"));
        assertEquals(resultD, directedGraph.getOuts("d"));
    }

    @Test
    public void mixedTest() {
        DirectedGraph directedGraph = new DirectedGraph();

        Edge edge1 = new Edge("A", "b", 5);
        Edge edge2 = new Edge("A","c",8);
        Edge edge3 = new Edge("c", "b", 6);
        Edge edge4 = new Edge("d", "c", 15);

        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");

        directedGraph.addEdge("a", "b", 5);
        directedGraph.addEdge("a","c",8);
        directedGraph.addEdge("c","b",6);
        directedGraph.addEdge("d","c",15);

        Set<Edge> resultA = new HashSet<>();
        Set<Edge> resultB = new HashSet<>();
        Set<Edge> resultC = new HashSet<>();
        Set<Edge> resultD = new HashSet<>();

        resultA.add(edge1);
        resultA.add(edge2);
        resultC.add(edge3);
        resultD.add(edge4);

        directedGraph.changeName("a", "A");

        assertEquals(resultA, directedGraph.getOuts("A"));
        assertEquals(resultB, directedGraph.getOuts("b"));
        assertEquals(resultC, directedGraph.getOuts("c"));
        assertEquals(resultD, directedGraph.getOuts("d"));
    }

}