import DirectedGraph.DirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectedGraphTest {
    DirectedGraph graph = new DirectedGraph("vv, cc, ff, kk", "vv, cc, 4; kk, cc, 9; cc, ff, 5");

    @Test
    public void addVertex() {
        graph.addVertex("cc");
        graph.addVertex("ss");
        DirectedGraph expected = new DirectedGraph(
                "vv, cc, ff, kk, ss",
                "vv, cc, 4; kk, cc, 9; cc, ff, 5");
        assertEquals(expected, graph);
    }
    @Test
    public void addArc() {
        graph.addArc("vv", "ii", 3);
        graph.addArc("ii", "vv", 3);
        DirectedGraph expected = new DirectedGraph(
                "vv, cc, ii, ff, kk",
                "vv, cc, 4; vv, ii, 3; ii, vv, 3; kk, cc, 9; cc, ff, 5"
        );
        assertEquals(expected, graph);
    }

    @Test
    public void deleteVertex() {
        graph.deleteVertex(graph.getVertex("ff"));
        DirectedGraph expected = new DirectedGraph("vv, cc, kk", "vv, cc, 4; kk, cc, 9");
        assertEquals(expected, graph);
    }

    @Test
    public void deleteArc() {
        graph.deleteArc("vv", "cc");
        graph.deleteArc("aa", "tt");
        graph.deleteArc("kk", "vv");
        DirectedGraph expected = new DirectedGraph("vv, cc, ff, kk", "kk, cc, 9; cc, ff, 5");
        assertEquals(expected, graph);
    }

    @Test
    public void setNameVertex() {
        graph.addArc("ff", "kk", 3);
        graph.setNameVertex(graph.getVertex("ff"), "ii");
        DirectedGraph expected = new DirectedGraph("vv, cc, ii, kk", "vv, cc, 4; kk, cc, 9; ii, kk, 3; cc, ii, 5");
        assertEquals(expected, graph);
    }

    @Test
    public void setWeightArc() {
        graph.getArcByName("vv", "cc").setWeight(6);
        graph.getArcByName("kk", "cc").setWeight(0);
        graph.getArcByVertexes(graph.getVertex("vv"), graph.getVertex("cc")).setWeight(8);
        DirectedGraph expected = new DirectedGraph("vv, cc, ff, kk", "vv, cc, 8; kk, cc, 9; cc, ff, 5");
        assertEquals(expected, graph);
    }

    @Test
    public void getIncomingArcs() {
        assertEquals(Set.of(
                        new DirectedGraph.Arc(new DirectedGraph.Vertex("vv"), new DirectedGraph.Vertex("cc"), 4),
                        new DirectedGraph.Arc(new DirectedGraph.Vertex("kk"), new DirectedGraph.Vertex("cc"), 9))
                , graph.getIncomingArcs(graph.getVertex("cc")));
    }

   @Test
    public void getOutcomingArcs() {
        DirectedGraph graph = new DirectedGraph("vv, cc, ii, kk, ff", "vv, cc, 4; vv, ii, 4; kk, cc, 9; cc, ff, 5");
        assertEquals(Set.of(
                        new DirectedGraph.Arc(new DirectedGraph.Vertex("vv"), new DirectedGraph.Vertex("cc"), 4),
                        new DirectedGraph.Arc(new DirectedGraph.Vertex("vv"), new DirectedGraph.Vertex("ii"), 4)),
                graph.getOutcomingArcs(graph.getVertex("vv")));
    }

    @Test
    public void mixedTests() {
        graph.deleteVertex(graph.getVertex("ii"));
        graph.getArcByVertexes(graph.getVertex("vv"), graph.getVertex("cc")).setWeight(8);
        graph.setNameVertex(graph.getVertex("vv"), "oo");
        graph.setNameVertex(graph.getVertex("aa"), "ll");
        DirectedGraph expected = new DirectedGraph("oo, cc, ff, kk", "oo, cc, 8; kk, cc, 9; cc, ff, 5");
        assertEquals(expected, graph);
    }
}
