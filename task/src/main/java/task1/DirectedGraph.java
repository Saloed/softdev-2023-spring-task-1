package task1;

import java.util.*;

public class DirectedGraph {

    static class Vertex {
        public Set<String> ins = new HashSet<>();
        public Set<String> outs = new HashSet<>();
    }

    public static class Edge1 {
        public String start;
        public String end;
        public int weight;

        public Edge1(String start, String end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private final Map<String, Vertex> vertices = new HashMap<>();
    private final Map<Edge, Integer> e = new HashMap<>();

    public boolean addVertex(String vertexToAdd) {
        Vertex vertex = vertices.putIfAbsent(vertexToAdd, new Vertex());

        return vertex == null;
    }

    public boolean addEdge(String start, String end, int weight) {
        Vertex startV = vertices.get(start);
        Vertex endV = vertices.get(end);

        if (startV == null || endV == null) return false;
        if (weight < 0) return false;
        if (!startV.outs.add(end)) return false;
        if (!endV.ins.add(start)) return false;

        e.put(new Edge(start, end), weight);

        return true;
    }

    public boolean removeVertex(String vertexToRemove) {
        Vertex vertex = vertices.get(vertexToRemove);

        if (vertex == null) return false;

        for (String vName: vertex.ins) {
            vertices.get(vertexToRemove).outs.remove(vertexToRemove);
            e.remove(new Edge(vName, vertexToRemove));
        }

        for (String vName: vertex.outs) {
            vertices.get(vertexToRemove).ins.remove(vertexToRemove);
            e.remove(new Edge(vertexToRemove, vName));
        }

        return true;
    }

    public boolean removeEdge(String start, String end) {
        if (e.remove(new Edge(start, end)) == null) return false;

        vertices.get(end).ins.remove(start);
        vertices.get(start).outs.remove(end);

        return true;
    }

    public boolean changeName(String nameToChange, String newName) {
        Vertex vertex = vertices.get(nameToChange);
        if (vertex == null) return false;

        for (String vName: vertex.ins) {
            Set<String> outs = vertices.get(vName).outs;
            outs.remove(nameToChange);
            outs.add(newName);

            Integer weight = e.remove(new Edge(vName, nameToChange));
            e.put(new Edge(vName, newName), weight);
        }

        for (String vName: vertex.outs) {
            Set<String> ins = vertices.get(vName).ins;
            ins.remove(nameToChange);
            ins.add(newName);

            Integer weight = e.remove(new Edge(nameToChange, vName));
            e.put(new Edge(newName, vName), weight);
        }

        return true;
    }

    public boolean changeWeight(String start, String end, int weight) {
        if (weight < 0) return false;
        if (e.replace(new Edge(start, end), weight) == null) return false;

        return true;
    }

    public Set<Edge1> getIns(String name) {
        Set<Edge1> edges = new HashSet<>();
        Vertex vertex = vertices.get(name);
        if (vertex == null) return edges;

        for (String v: vertex.ins) {
            edges.add(new Edge1(v, name, e.get(new Edge(v, name))));
        }
        return edges;
    }

    public Set<Edge1> getOuts(String name) {
        Set<Edge1> edges = new HashSet<>();
        Vertex vertex = vertices.get(name);
        if (vertex == null) return edges;

        for (String v: vertex.outs) {
            edges.add(new Edge1(name, v, e.get(new Edge(name, v))));
        }
        return edges;
    }

}