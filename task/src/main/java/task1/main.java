package task1;

import javax.naming.InvalidNameException;
import java.util.NoSuchElementException;

public class main {

    public static void main(String[] args)
            throws IllegalArgumentException, PutException, MoveException, NoSuchElementException
    {

        ChessBoard myChess = new ChessBoard();
        Piece bPawn = new Piece("bPawn");
        Piece wPawn = new Piece("wPawn");
        for(int i = 0; i < 8; i++) {
            myChess.put(bPawn, 1, i);
            myChess.put(wPawn, 6, i);
        }
        myChess.printBoard();
        myChess.remove(6, 7);
        myChess.printBoard();
    }

}
