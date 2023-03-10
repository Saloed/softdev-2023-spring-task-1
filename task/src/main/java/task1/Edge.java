package task1;

public class Edge {

    private String start;
    private String end;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    void setStart(String start) {
        this.start = start;
    }

    void setEnd(String end) {
        this.end = end;
    }

    public Edge(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Edge(String start, String end) {
        this.start = start;
        this.end = end;
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