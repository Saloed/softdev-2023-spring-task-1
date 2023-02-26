package task1;

import javax.naming.InvalidNameException;

public class main {

    public static void main(String[] args) throws InvalidNameException {

        ChessBoard myChess = new ChessBoard();
        Piece bPawn = new Piece("bPawn");
        Piece wPawn = new Piece("wPawn");
        Piece wKing = new Piece("wKing");
        for(int i = 0; i < 8; i++) {
            myChess.put(bPawn, 1, i);
            myChess.put(wPawn, 6, i);
        }
        myChess.remove(6, 0);
        myChess.remove(5, 0);
        myChess.put(bPawn, 3, 5);
        myChess.put(wKing, 6, 0);
        myChess.printBoard();
    }

}
