package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    public void test1TicTacToe() {
        TicTacToe fir = new TicTacToe(5, 5);
        fir.additionCross(3, 3);
        Sign expected = Sign.X;
        assertEquals(expected, fir.symbolByPosition(3, 3));
    }

    @Test
    public void test2TicTacToe() {
        TicTacToe sec = new TicTacToe(5, 5);
        sec.additionCross(3, 3);
        sec.additionCross(3, 4);
        assertEquals(2, sec.maxCross());
    }

    @Test
    public void test3TicIacToe() {
        TicTacToe fer = new TicTacToe(5, 5);
        fer.additionCross(3, 3);
        fer.additionCross(4, 4);
        assertEquals(2, fer.maxCross());
    }

    @Test
    public void test4TicTacToe() {
        TicTacToe fo = new TicTacToe(8, 8);
        fo.additionZero(0, 3);
        fo.additionZero(1, 2);
        fo.additionZero(2, 1);
        assertEquals(3, fo.maxZero());
    }

    @Test
    public void test5TicTacToe() {
        TicTacToe five = new TicTacToe(1, 4);
        five.additionZero(0, 0);
        five.additionZero(0, 1);
        five.additionZero(0, 2);
        five.additionZero(0, 3);
        five.additionCross(0, 2);
        assertEquals(4, five.maxZero());
    }

    @Test
    public void test6TicTacToe() {
        TicTacToe six = new TicTacToe(1, 4);
        six.additionZero(0, 0);
        six.additionZero(0, 1);
        six.delete(0, 0);
        assertEquals(1, six.maxZero());
    }

    @Test
    public void test7TicTacToe() {
        TicTacToe sev = new TicTacToe(8, 5);
        sev.additionCross(0, 0);
        sev.additionCross(0, 1);
        sev.additionCross(0, 2);
        sev.additionCross(0, 3);
        sev.additionCross(1, 2);
        sev.additionCross(2, 1);
        sev.additionCross(3, 0);
        sev.additionCross(4, 1);
        sev.additionCross(5, 2);
        sev.additionCross(6, 3);
        sev.additionCross(7, 4);
        assertEquals(5, sev.maxCross());
    }
}