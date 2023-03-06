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

}
