package task1;

class Edge {
    public String start;
    public String end;
    public int weight;

    public Edge(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        if (start != edge.start) return false;
        if (end != edge.end) return false;
        return true;
    }
}
