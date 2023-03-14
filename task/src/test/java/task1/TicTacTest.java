package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacTest {

    @Test
    public void test1() {
        TicTac tictac = new TicTac(3);
        tictac.add(1, 0, "x");
        tictac.add(2, 1, "x");
        tictac.add(1, 2, "x");
        tictac.add(0, 0, "o");
        tictac.del(2, 1);
        assertEquals( 1, tictac.checklen("x") );
    }
    @Test
    public void test6() {
        TicTac tictac = new TicTac(4);
        tictac.add(1, 0, "x");
        tictac.add(2, 0, "x");
        tictac.add(2, 1, "x");
        tictac.add(2, 2, "x");
        tictac.add(1, 2, "x");
        tictac.add(1, 3, "x");
        tictac.add(0, 0, "o");
        tictac.del(1, 3);
        assertEquals( 3, tictac.checklen("x") );
    }
    @Test
    public void test4() {
        TicTac tictac = new TicTac(3);
        tictac.add(1, 0, "x");

        assertThrows(IllegalArgumentException.class, () -> tictac.add(-2, 1, "x"));
    }
}
