package task1;

public class Triangle {

    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcSquare() {
        int p = calcPerimeter();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public int calcPerimeter() {
        return a + b + c;
    }
}
