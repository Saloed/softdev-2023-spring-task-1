package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void test1() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, "X");
        ticTacToe.add(2, 1, "X");
        ticTacToe.add(1, 2, "X");
        ticTacToe.add(0,0, "O");
        ticTacToe.remove(2, 1);
        assertEquals(1, ticTacToe.length("X"));
    }

    @Test
    public void test2() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TicTacToe(-4));
    }
    @Test
    public void test3() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, "X");

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () ->
                    ticTacToe.add(2, 1, "i"));

    }

    @Test
    public void test4() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, "X");

        ArrayIndexOutOfBoundsException thrown = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () ->
                        ticTacToe.add(-2, 1, "X"));

    }
    @Test
    public void test5() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(3);
        ticTacToe.add(1, 0, "X");

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () ->
                        ticTacToe.length("a"));

    }

    @Test
    public void test6() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(8);
        assertEquals(0, ticTacToe.length("X"));
    }

    @Test
    public void test7() {
        TicTacToe ticTacToe ;
        ticTacToe = new TicTacToe(4);
        ticTacToe.add(1, 0, "X");
        ticTacToe.add(2, 0, "X");
        ticTacToe.add(2, 1, "X");
        ticTacToe.add(2, 2, "X");
        ticTacToe.add(1, 2, "X");
        ticTacToe.add(1, 3, "X");
        ticTacToe.add(0,0, "O");
        ticTacToe.remove(1, 3);
        assertEquals(3, ticTacToe.length("X"));
    }
}