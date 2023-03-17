package DirectedGraph;

import java.util.*;
import java.util.stream.Collectors;

public class DirectedGraph {

    public static class Vertex {
        private String name;
        private final HashMap<String, List<Arc>> incArc;
        private final HashMap<String, List<Arc>> outArc;

        public Vertex(String name) {
            this.name = name;
            this.incArc = new HashMap<>();
            this.outArc = new HashMap<>();
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Vertex)) return false;
            return Objects.equals(this.name, ((Vertex) obj).name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

    }

    public static class Arc {
        private final Vertex begin;
        private final Vertex end;
        private int weight;

        public Arc(Vertex begin, Vertex end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public void setWeight(int value) {
            if (value > 0) weight = value;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Arc arc = (Arc) o;
            return weight == arc.weight && Objects.equals(begin, arc.begin) && Objects.equals(end, arc.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end, weight);
        }
    }

    private final Map<String, Vertex> vertexes = new HashMap<>();
    private final Set<Arc> arcs = new HashSet<>();

    public DirectedGraph(String vertexesString, String arcsString) {
        if (vertexesString != null && arcsString != null) {
            String[] vertexesNames = vertexesString.split(", ");
            String[] arcsSubstrings = arcsString.split("; ");
            for (String vertexName : vertexesNames) {
                vertexes.put(vertexName, new Vertex(vertexName));
            }
            for (String arcStr : arcsSubstrings) {
                String[] arcElements = arcStr.split(", ");
                String begin = arcElements[0];
                String end = arcElements[1];
                int weight = Integer.parseInt(arcElements[2]);

                Vertex beginVertex;
                if (vertexes.containsKey(begin)) beginVertex = vertexes.get(begin);
                else beginVertex = new Vertex(begin);

                Vertex endVertex;
                if (vertexes.containsKey(end)) endVertex = vertexes.get(end);
                else endVertex = new Vertex(end);

                Arc newArc = new Arc(beginVertex, endVertex, weight);
                arcs.add(newArc);

                if (!endVertex.incArc.containsKey(end)) endVertex.incArc.put(end, new ArrayList<>());
                endVertex.incArc.get(end).add(newArc);

                if (!beginVertex.outArc.containsKey(begin)) beginVertex.outArc.put(begin, new ArrayList<>());
                beginVertex.outArc.get(begin).add(newArc);
            }
        }
    }

    public Vertex getVertex(String name) {
        return vertexes.get(name);
    }

    public void addVertex(Vertex vertex) {
        vertexes.put(vertex.name, vertex);
    }

    public void addVertex(String name) {
        addVertex(new Vertex(name));
    }

    public void deleteVertex(Vertex vertex) {
        if (vertex != null) {
            arcs.removeAll(getIncomingArcs(vertex));
            arcs.removeAll(getOutcomingArcs(vertex));
            vertexes.remove(vertex.name);
        }
    }

    public void setNameVertex(Vertex vertex, String newName) {
        if (vertex != null) {
            vertexes.remove(vertex.name);
            vertex.name = newName;
            vertexes.put(vertex.name, vertex);
        }
    }

    public Arc getArcByName(String begin, String end) {
        if (vertexes.containsKey(begin) && vertexes.containsKey(end) && getVertex(begin).outArc.get(begin) != null) {
            List<Arc> arcList = getVertex(begin).outArc.get(begin);
            for (Arc arc: arcList) {
                if (Objects.equals(arc.end.name, end)) return arc;
            }
        }
        return null;
    }

    public Arc getArcByVertexes(Vertex begin, Vertex end) {
        return getArcByName(begin.name, end.name);
    }

    public void addArc(String begin, String end, int weight) {
        Vertex beginVertex;
        Vertex endVertex;
        if (vertexes.get(begin) != null) {
            beginVertex = getVertex(begin);
        } else {
            beginVertex = new Vertex(begin);
            addVertex(beginVertex);
        }
        if (vertexes.get(end) != null) {
            endVertex = getVertex(end);
        } else {
            endVertex = new Vertex(end);
            addVertex(endVertex);
        }
        Arc newArc = new Arc(beginVertex, endVertex, weight);
        arcs.add(newArc);

        if (!endVertex.incArc.containsKey(end)) endVertex.incArc.put(end, new ArrayList<>());
        endVertex.incArc.get(end).add(newArc);

        if (!beginVertex.outArc.containsKey(begin)) beginVertex.outArc.put(begin, new ArrayList<>());
        beginVertex.outArc.get(begin).add(newArc);
    }

    public void deleteArc(String begin, String end) {
        arcs.remove(getArcByName(begin, end));
    }

    public Set<Arc> getIncomingArcs(Vertex vertex) {
        return vertex.incArc.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public Set<Arc> getOutcomingArcs(Vertex vertex) {
        return vertex.outArc.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedGraph that = (DirectedGraph) o;
        return Objects.equals(vertexes, that.vertexes) && Objects.equals(arcs, that.arcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexes, arcs);
    }
}
