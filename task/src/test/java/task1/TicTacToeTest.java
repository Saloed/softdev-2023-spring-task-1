package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void test1() {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, TicTacToe.Marker.X);
        ticTacToe.add(2, 1, TicTacToe.Marker.X);
        ticTacToe.add(1, 2, TicTacToe.Marker.X);
        ticTacToe.add(0, 0, TicTacToe.Marker.O);
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
        ticTacToe.add(1, 0, TicTacToe.Marker.X);
        assertThrows( IllegalArgumentException.class, () -> ticTacToe.add(1, 0, TicTacToe.Marker.O) );

    }

    @Test
    public void test4() {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, TicTacToe.Marker.X);

        assertThrows( IllegalArgumentException.class, () -> ticTacToe.add(-2, 1, TicTacToe.Marker.X) );

    }

    @Test
    public void test5() {
        TicTacToe ticTacToe = new TicTacToe(8);
        assertEquals( 0, ticTacToe.length(TicTacToe.Marker.X) );
    }

    @Test
    public void test6() {
        TicTacToe ticTacToe = new TicTacToe(4);
        ticTacToe.add(1, 0, TicTacToe.Marker.X);
        ticTacToe.add(2, 0, TicTacToe.Marker.X);
        ticTacToe.add(2, 1, TicTacToe.Marker.X);
        ticTacToe.add(2, 2, TicTacToe.Marker.X);
        ticTacToe.add(1, 2, TicTacToe.Marker.X);
        ticTacToe.add(1, 3, TicTacToe.Marker.X);
        ticTacToe.add(0, 0, TicTacToe.Marker.O);
        ticTacToe.remove(1, 3);
        assertEquals( 3, ticTacToe.length(TicTacToe.Marker.X) );
    }
}