package task1;

import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DirectedGraph {

    private final Set<String> vertices = new HashSet<>();
    private final Set<Edge> edges = new HashSet<>();

    private @Nullable Edge findEdge(String start, String end) {
        return edges.stream()
                .filter(e -> e.getStart() == start && e.getEnd() == end)
                .findFirst().orElse(null);
    }

    public boolean addVertex(String vertexToAdd) {
        return vertices.add(vertexToAdd);
    }

    public boolean addEdge(String start, String end, int weight) {
        if (!vertices.contains(start) || !vertices.contains(end)) return false;
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
        return vertices.remove(vertexToRemove);
    }

    public boolean removeEdge(String start, String end) {
        Edge edge = findEdge(start, end);
        if (edge == null) return false;
        edges.remove(edge);
        return true;
    }

    public boolean changeName(String nameToChange, String newName) {
        if (vertices.contains(newName)) return false;
        if (!vertices.remove(nameToChange)) return false;
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
        if (weight < 0) return false;
        edge.setWeight(weight);
        return true;
    }

    public Set<Edge> getIns(String name) {
        return edges.stream()
                .filter(edge -> edge.getEnd().equals(name))
                .collect(Collectors.toSet());
    }

    public Set<Edge> getOuts(String name) {
        return edges.stream()
                .filter(edge -> edge.getStart().equals(name))
                .collect(Collectors.toSet());
    }

}
