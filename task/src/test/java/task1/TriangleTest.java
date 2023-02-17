package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testTriangleSquare() {
        Triangle triangle = new Triangle(1, 1, 1);
        double expectedSquare = 5;
        assertEquals(expectedSquare, Math.round(triangle.calcSquare()));
    }
}
