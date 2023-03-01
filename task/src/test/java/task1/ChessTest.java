package task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ChessTest {

    @Test
    public void pawnCountTest() throws PutException {
        ChessBoard myChess = new ChessBoard();
        Piece bPawn = new Piece("bPawn");
        Piece wPawn = new Piece("wPawn");
        for(int i = 0; i < 8; i++) {
            myChess.put(bPawn, 1, i);
            myChess.put(wPawn, 6, i);
        }
        assertThrows(PutException.class, () -> myChess.put(bPawn, 5,5));
        assertThrows(PutException.class, () -> {
            for(int i = 0; i < 8; i++) {
                myChess.put(bPawn, 3, i);
            }
        });
    }

    @Test
    public void wrongPositionTest() throws IllegalArgumentException, PutException {
        ChessBoard myChess = new ChessBoard();
        Piece bPawn = new Piece("bPawn");
        Piece wKnight = new Piece("wKinght");
        assertThrows(IllegalArgumentException.class, () -> myChess.put(wKnight, -1, 5));
    }
}