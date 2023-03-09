package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessTest {
    @Test
    public void testChess() {
        Board chess = new Board(4, 3, 4, 7);
        Board blank = new Board(4, 3, 4, 7);
        Board.Figure rook = new Board.Figure(true, "Rook", 2, 6);
        chess.add(rook);
        chess.move(rook, 3, 7);
        chess.clear(3, 7);
        assertEquals(chess, blank);
    }
    @Test
    public void testChessExceptions() {
        Board chess = new Board(4, 3, 4, 7);
        //конструктор

        Throwable exception1 = assertThrows(IllegalArgumentException.class, () -> {
            Board chess1 = new Board(4, 3, 4, 4);
        });
        assertEquals("Неверные входные данные", exception1.getMessage());
        Throwable exception2 = assertThrows(IllegalArgumentException.class, () -> {
            Board chess1 = new Board(-1, 3, 4, 8);
        });
        assertEquals("Неверные входные данные", exception2.getMessage());


        //поставить новую фигуру

        Throwable exception3 = assertThrows(IllegalArgumentException.class, () -> {
            chess.add(new Board.Figure(false, "Pawn", 1, 1));
            chess.add(new Board.Figure(false, "Pawn", 1, 2));
            chess.add(new Board.Figure(false, "Pawn", 1, 3));
            chess.add(new Board.Figure(false, "Pawn", 5, 4));
            chess.add(new Board.Figure(false, "Pawn", 5, 5));
            chess.add(new Board.Figure(false, "Pawn", 5, 6));
            chess.add(new Board.Figure(false, "Pawn", 6, 6));
            chess.add(new Board.Figure(false, "Pawn", 5, 7));
            chess.add(new Board.Figure(false, "Pawn", 5, 0));

        });
        assertEquals("Слишком много пешек", exception3.getMessage());

        Throwable exception4 = assertThrows(IllegalArgumentException.class, () -> {
            chess.add(new Board.Figure(true, "King", 5, 6));
        });
        assertEquals("Нельзя добавить фигуру", exception4.getMessage());

        Throwable exception5 = assertThrows(IllegalArgumentException.class, () -> {
            chess.add(new Board.Figure(true, "Bishop", 4, 3));
        });
        assertEquals("Нельзя добавить фигуру", exception5.getMessage());


        //переместить существующую фигуру на другую клетку

        Throwable exception6 = assertThrows(IllegalArgumentException.class, () -> {
            chess.move(chess.blackKing, 5, 3);
        });
        assertEquals("Невозможно передвинуть фигуру", exception6.getMessage());

        Throwable exception7 = assertThrows(IllegalArgumentException.class, () -> {
            chess.move(chess.blackKing, -5, 3);
        });
        assertEquals("Невозможно передвинуть фигуру", exception7.getMessage());


    }
    @Test
    public void testBonus() {
        Board chessboard = new Board(3, 3, 4, 7);
        chessboard.add(new Board.Figure(true, "Pawn", 5, 7));
        chessboard.add(new Board.Figure(true, "Knight", 2, 3));
        chessboard.add(new Board.Figure(false, "Bishop", 5, 4));
        chessboard.add(new Board.Figure(false, "Rook", 3, 0));
        chessboard.add(new Board.Figure(false, "Queen", 7, 7));
        chessboard.add(new Board.Figure(false, "Knight", 5, 5));
        assertEquals(true, chessboard.isKingInCheck(true));
        assertEquals(false, chessboard.isKingInCheck(false));
    }
}



