package task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedGraph {

    private final Set<String> vertices1 = new HashSet<>();
    //private Set<Vertex> vertices;
    private final Set<Edge> edges = new HashSet<>();

    private Edge findEdge(String start, String end) {
        for (Edge e: edges) {
            if (e.getStart() == start && e.getEnd() == end) {
                return e;
            }
        }
        return null;
    }

    public boolean addVertex(String vertexToAdd) {
        return vertices1.add(vertexToAdd);
    }

    public boolean addEdge(String start, String end, int weight) {
        if (!vertices1.contains(start) || !vertices1.contains(end)) return false;
        if (findEdge(start, end) != null) return false;
        edges.add(new Edge(start, end, weight));
        return true;
    }

    public boolean removeVertex(String vertexToRemove) {
        Set<Edge> edgesToRemove = new HashSet<>();
        for (Edge e: edges) {
            if (e.getStart() == vertexToRemove || e.getEnd() == vertexToRemove) {
                edgesToRemove.add(e);
            }
        }
        edges.removeAll(edgesToRemove);
        return vertices1.remove(vertexToRemove);
    }

    public boolean removeEdge(String start, String end) {
        Edge edge = findEdge(start, end);
        if (edge == null) return false;
        edges.remove(edge);
        return true;
    }

    public boolean changeName(String nameToChange, String newName) {
        if (vertices1.contains(newName)) return false;
        if (!vertices1.remove(nameToChange)) return false;
        addVertex(newName);
        for (Edge e: edges) {
            if (e.getStart() == nameToChange) e.setStart(newName);
            if (e.getEnd() == nameToChange) e.setEnd(newName);
        }
        return true;
    }

    public boolean changeWeight(String start, String end, int weight) {
        Edge edge = findEdge(start, end);
        if (edge == null) return false;
        edge.setWeight(weight);
        return true;
    }

    public List<Edge> getIns(String name) {
        ArrayList<Edge> ins = new ArrayList<>();
        for (Edge e: edges) {
            if (e.getEnd() == name) ins.add(e);
        }
        return ins;
    }

    public List<Edge> getOuts(String name) {
        ArrayList<Edge> outs = new ArrayList<>();
        for (Edge e: edges) {
            if (e.getStart() == name) outs.add(e);
        }
        return outs;
    }

}
