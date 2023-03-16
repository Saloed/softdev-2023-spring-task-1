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
        tictac.add(0, 2, "o");
        tictac.del(0, 1);
        tictac.add(0, 1, "o");
        assertEquals(3, tictac.checklen("o"));
    }

    @Test
    public void test2() {
        TicTac tictac = new TicTac(4);
        tictac.add(1, 0, "x");
        tictac.add(2, 0, "x");
        tictac.add(2, 1, "x");
        tictac.add(2, 2, "x");
        tictac.add(1, 2, "x");
        tictac.add(1, 3, "x");
        tictac.add(0, 0, "o");
        tictac.del(1, 3);
        assertEquals(3, tictac.checklen("x"));
    }

    @Test
    public void test3() {
        TicTac tictac = new TicTac(3);
        tictac.add(1, 0, "x");

        assertThrows(IllegalArgumentException.class, () -> tictac.add(-2, 1, "x"));
    }

    @Test
    public void test4() {
        TicTac tictac = new TicTac(4);
        tictac.add(0, 3, "o");
        tictac.add(1, 2, "x");
        tictac.add(2, 1, "x");
        tictac.add(3, 0, "x");
        assertEquals(3, tictac.checklen("x"));
    }

    @Test
    public void test5() {
        TicTac tictac = new TicTac(5);
        tictac.add(1, 1, "o");
        tictac.add(2, 2, "o");
        tictac.add(3, 3, "o");
        tictac.add(4, 4, "o");
        tictac.add(0, 4, "x");
        tictac.add(1, 3, "x");
        tictac.add(3, 1, "x");
        assertEquals(4, tictac.checklen("o"));
    }

    @Test
    public void test6() {
        TicTac tictac = new TicTac(5);
        tictac.add(0, 4, "o");
        tictac.add(1, 4, "o");
        tictac.add(2, 4, "o");
        tictac.add(3, 4, "o");
        tictac.add(4, 4, "o");
        tictac.add(3, 3, "o");
        tictac.add(3, 1, "x");
        assertEquals(5, tictac.checklen("o"));
    }
}
