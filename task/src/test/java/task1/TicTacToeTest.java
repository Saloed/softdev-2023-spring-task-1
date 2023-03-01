package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void test1() {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.addX(1, 0);
        ticTacToe.addX(2, 1);
        ticTacToe.addX(1, 2);
        ticTacToe.addO(0, 0);
        ticTacToe.remove(2, 1);
        assertEquals( 1, ticTacToe.length(TicTacToe.Marker.X) );
    }

    @Test
    public void test2() {
        assertThrows( IllegalArgumentException.class, () -> new TicTacToe(-4) );
    }
    @Test
    public void test3() {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.addX(1, 0);
        assertThrows( IllegalArgumentException.class, () -> ticTacToe.addO(1, 0) );

    }

    @Test
    public void test4() {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.addX(1, 0);

        assertThrows( IllegalArgumentException.class, () -> ticTacToe.addX(-2, 1) );

    }

    @Test
    public void test5() {
        TicTacToe ticTacToe = new TicTacToe(8);
        assertEquals( 0, ticTacToe.length(TicTacToe.Marker.X) );
    }

    @Test
    public void test6() {
        TicTacToe ticTacToe = new TicTacToe(4);
        ticTacToe.addX(1, 0);
        ticTacToe.addX(2, 0);
        ticTacToe.addX(2, 1);
        ticTacToe.addX(2, 2);
        ticTacToe.addX(1, 2);
        ticTacToe.addX(1, 3);
        ticTacToe.addO(0, 0);
        ticTacToe.remove(1, 3);
        assertEquals( 3, ticTacToe.length(TicTacToe.Marker.X) );
    }
}