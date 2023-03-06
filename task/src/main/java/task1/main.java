package task1;


import java.util.NoSuchElementException;

public class main {

    public static void main(String[] args) throws IllegalArgumentException, PutException, MoveException,
            NoSuchElementException, IllegalArgumentException
    {

        ChessBoard myChess = new ChessBoard();
        Piece bPawn = Piece.bPawn;
        Piece wPawn = Piece.wPawn;
        Piece wKing = Piece.wKing;
        for(int i = 0; i < 8; i++) {
            myChess.put(bPawn, 1, i);
            myChess.put(wPawn, 6, i);
        }
        myChess.remove(6, 7);
        myChess.move(7, 4, 0, 6);
        myChess.printBoard();
    }

}
