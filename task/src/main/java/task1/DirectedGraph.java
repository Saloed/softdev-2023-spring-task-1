package task1;

import java.util.*;

public class DirectedGraph {

    private final Map<String, Map<String, Integer>> vertexes = new HashMap<>();

    public boolean addVertex(String vertexToAdd) {
        return vertexes.putIfAbsent(vertexToAdd, new HashMap<>()) == null;
    }

    public boolean addEdge(String start, String end, int weight) {
        if (weight <= 0) return false;
        var startLinks = vertexes.get(start);
        var endLinks = vertexes.get(end);

        if (startLinks.putIfAbsent(end, weight) != null) return false;
        if (endLinks.putIfAbsent(start, -weight) != null) return false;

        return true;
    }

    public boolean removeVertex(String vertexToRemove) {
        var links = vertexes.remove(vertexToRemove);
        if (links == null) return false;

        for (var name: links.keySet()) {
            vertexes.get(name).remove(vertexToRemove);
        }

        return true;
    }

    public boolean removeEdge(String start, String end) {
        var startLinks = vertexes.get(start);
        var endLinks = vertexes.get(end);

        if (startLinks == null || endLinks == null) return false;
        var weight = startLinks.get(end);
        if (weight == null || weight < 0) return false;
        startLinks.remove(end);
        endLinks.remove(start);

        return true;
    }

    public boolean changeName(String nameToChange, String newName) {
        if (vertexes.get(newName) != null) return false;
        var links = vertexes.remove(nameToChange);
        if (links == null) return false;
        vertexes.put(newName, links);

        for (var name: links.keySet()) {
            var oppositeLinks = vertexes.get(name);
            var weight = oppositeLinks.remove(nameToChange);
            oppositeLinks.put(newName, weight);
        }

        return true;
    }

    public boolean changeWeight(String start, String end, int weight) {
        if (weight <= 0) return false;

        var startLinks = vertexes.get(start);
        var endLinks = vertexes.get(end);
        if (startLinks == null || endLinks == null) return false;

        var oldWeight = startLinks.get(end);
        if (oldWeight == null || oldWeight < 0) return false;
        startLinks.replace(end, weight);
        endLinks.replace(start, -weight);

        return true;
    }

    public Set<Edge> getIns(String name) {
        Set<Edge> edges = new HashSet<>();
        var links = vertexes.get(name);
        if (links != null) {
            for (var elem: links.entrySet()) {
                if (elem.getValue() < 0) edges.add(new Edge(elem.getKey(), name, -elem.getValue()));
            }
        }

        return edges;
    }

    public Set<Edge> getOuts(String name) {
        Set<Edge> edges = new HashSet<>();
        var links = vertexes.get(name);
        if (links != null) {
            for (var elem: links.entrySet()) {
                if (elem.getValue() > 0) edges.add(new Edge(name, elem.getKey(), elem.getValue()));
            }
        }

        return edges;
    }
}