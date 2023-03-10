package task1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {

    private final Set<String> vertices = new HashSet<>();
    private final Set<Edge> edges = new HashSet<>();
    private final Map<String, Set<Edge>> ins = new HashMap<>();
    private final Map<String, Set<Edge>> outs = new HashMap<>();

    public boolean addVertex(String vertexToAdd) {
        ins.put(vertexToAdd, new HashSet<>());
        outs.put(vertexToAdd, new HashSet<>());

        return vertices.add(vertexToAdd);
    }

    public boolean addEdge(String start, String end, int weight) {
        Edge edge = new Edge(start, end, weight);

        if (!vertices.contains(start) || !vertices.contains(end)) return false;
        if (edges.contains(edge)) return false;
        if (weight < 0) return false;

        edges.add(edge);

        ins.get(end).add(edge);
        outs.get(start).add(edge);

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

        ins.remove(vertexToRemove);
        outs.remove(vertexToRemove);

        return vertices.remove(vertexToRemove);
    }

    public boolean removeEdge(String start, String end) {
        Edge edge = new Edge(start, end);

        if (!edges.contains(edge)) return false;

        edges.remove(edge);

        ins.get(end).remove(edge);
        outs.get(start).remove(edge);

        return true;
    }

    public boolean changeName(String nameToChange, String newName) {
        if (vertices.contains(newName)) return false;
        if (!vertices.remove(nameToChange)) return false;

        addVertex(newName);

        for (Edge e: edges) {
            if (e.getStart() == nameToChange) {
                e.setStart(newName);
                if (outs.containsKey(nameToChange)) {
                    outs.put(newName, outs.get(nameToChange));
                    outs.remove(nameToChange);
                }
            }
            if (e.getEnd() == nameToChange) {
                e.setEnd(newName);
                if (ins.containsKey(nameToChange)) {
                    ins.put(newName, ins.get(nameToChange));
                    ins.remove(nameToChange);
                }
            }
        }

        return true;
    }

    public boolean changeWeight(String start, String end, int weight) {
        Edge edge = new Edge(start, end);

        if (!edges.contains(edge)) return false;
        if (weight < 0) return false;

        edge.setWeight(weight);

        return true;
    }

    public Set<Edge> getIns(String name) {
        return ins.getOrDefault(name, new HashSet<>());
    }

    public Set<Edge> getOuts(String name) {
        return outs.getOrDefault(name, new HashSet<>());
    }

}