package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    @Test
    public void test1TicTacToe() {
        TicTacToe k = new TicTacToe(5,5);
        k.addition(3,3,'x');
        char expectedSquare = 'x';
        assertEquals(expectedSquare, k.symbolByPosition(3,3));
    }

    @Test
    public void test2TicTacToe(){
        TicTacToe sec = new TicTacToe(5,5);
        sec.addition(3,3,'x');
        sec.addition(3,4,'x');
        assertEquals(2,sec.maxCross());
    }

    @Test
    public void test3TicIacToe(){
        TicTacToe fer = new TicTacToe(5,5);
        fer.addition(3,3,'x');
        fer.addition(4,4,'x');
        assertEquals(2,fer.maxCross());
    }

    @Test
    public void test4TicTacToe(){
        TicTacToe fo = new TicTacToe(8,8);
        fo.addition(0,3,'O');
        fo.addition(1,2,'O');
        fo.addition(2,1,'O');
        assertEquals(3,fo.maxZero());
    }
}