package DirectedGraph;

import java.util.*;

public class DirectedGraph {

    public static class Vertex {
        private String name;

        public Vertex(String name) {
            this.name = name;
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

    public DirectedGraph(Set<Vertex> vertexSet, Set<Arc> arcs) {
        this.arcs.addAll(arcs);
        for (Vertex vertex : vertexSet) this.vertexes.put(vertex.name, vertex);
        for (Arc i : arcs) {
            this.vertexes.put(i.begin.name, i.begin);
            this.vertexes.put(i.end.name, i.end);
        }
    }

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

                arcs.add(new Arc(beginVertex, endVertex, weight));
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
        for (Arc i : arcs) {
            if (Objects.equals(i.begin.name, begin) && Objects.equals(i.end.name, end)) return i;
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
        arcs.add(new Arc(beginVertex, endVertex, weight));
    }

    public void deleteArc(String begin, String end) {
        arcs.remove(getArcByName(begin, end));
    }

    public Set<Arc> getIncomingArcs(Vertex vertex) {
        Set<Arc> result = new HashSet<>();
        for (Arc arc : arcs) {
            if (Objects.equals(arc.end, vertex)) result.add(arc);
        }
        return result;
    }

    public Set<Arc> getOutcomingArcs(Vertex vertex) {
        Set<Arc> result = new HashSet<>();
        for (Arc arc : arcs) {
            if (Objects.equals(arc.begin, vertex)) result.add(arc);
        }
        return result;
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
