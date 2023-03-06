package task1;


import java.util.NoSuchElementException;


enum Piece {
    bPawn,
    wPawn,
    bKnight,
    wKnight,
    bBishop,
    wBishop,
    bRook,
    wRook,
    bQueen,
    wQueen,
    bKing,
    wKing,
    empty
}


class PutException extends Exception {

    public PutException(String message) {
        super(message);
    }

}

class MoveException extends Exception {

    public MoveException(String message) {
        super(message);
    }


}

public class ChessBoard {

    protected Piece[][] board = {
            // доска
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
            {Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty, Piece.empty},
    };

    public ChessBoard() throws PutException, IllegalArgumentException{
        // конструктор
        Piece bKing = Piece.bKing;
        Piece wKing = Piece.wKing;
        this.put(bKing, 0, 4);
        this.put(wKing, 7, 4);
    }

    public void put(Piece piece, int x, int y) throws PutException, IllegalArgumentException {
        // метод постановки фигуры на доску
        indexChecking(x, y);
        if(!board[x][y].equals(Piece.empty)) {
            throw new PutException("Клетка уже занята");
        }
        switch (piece) {
            case bPawn -> {
                int bpCount = 0;
                for (Piece[] line : board) {
                    for (Piece square : line) {
                        if (square.equals(Piece.bPawn)) {
                            bpCount++;
                        }
                    }
                }
                if (bpCount <= 7) {
                    board[x][y] = piece;
                } else {
                    throw new PutException("Не может быть больше 8-ми пешек одного цвета");
                }
            }
            case wPawn -> {
                int wpCount = 0;
                for (Piece[] line : board) {
                    for (Piece square : line) {
                        if (square.equals(Piece.wPawn)) {
                            wpCount++;
                        }
                    }
                }
                if (wpCount <= 7) {
                    board[x][y] = piece;
                } else {
                    throw new PutException("Не может быть больше 8-ми пешек одного цвета");
                }
            }
            case bKing -> {
                int bkCount = 0;
                for (Piece[] line : board) {
                    for (Piece square : line) {
                        if (square.equals(Piece.bKing)) {
                            bkCount++;
                            break;
                        }
                    }
                }
                if (bkCount == 0) {
                    kingChecking("wKing", x, y);
                    board[x][y] = piece;
                } else {
                    throw new PutException("Такой король уже есть на доске");
                }
            }
            case wKing -> {
                int wkCount = 0;
                for (Piece[] line : board) {
                    for (Piece square : line) {
                        if (square.equals(Piece.wKing)) {
                            wkCount++;
                            break;
                        }
                    }
                }
                if (wkCount == 0) {
                    kingChecking("bKing", x, y);
                    board[x][y] = piece;
                } else {
                    throw new PutException("Такой король уже есть на доске");
                }
            }
            default -> board[x][y] = piece;
        }
    }

    public void move(int xf, int yf, int xt, int yt)
            throws MoveException, NoSuchElementException, IllegalArgumentException, PutException {
        // метод передвижения фигур
        indexChecking(xf, yf);
        indexChecking(xt, yt);
        if(!board[xf][yf].equals(Piece.empty)) {
            if(board[xt][yt].equals(Piece.empty)) {
                Piece curPiece = board[xf][yf];
                switch (curPiece) {
                    case bKing -> kingChecking("wKing", xt, yt);
                    case wKing -> kingChecking("bKing", xt, yt);
                }
                board[xf][yf] = Piece.empty;
                board[xt][yt] = curPiece;
            }
            else {
                throw new MoveException("Некуда ставить");
            }
        }
        else {
            throw new NoSuchElementException("исходная клетка пуста");
        }

    }

    public void remove(int x, int y) throws IllegalArgumentException {
        // метод очистки клетки
        indexChecking(x, y);
        if(!board[x][y].equals(Piece.empty)) {
            board[x][y] = Piece.empty;
        } else {
            throw new NoSuchElementException("исходная клетка пуста");
        }

    }

    public void printBoard() {
        // вывести в консоль текущую позицию(±красиво и с нотацией)
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                StringBuilder s = new StringBuilder();
                if (board[i][j].equals(Piece.empty)){
                    s.append("_");
                } else {
                    s.append(String.valueOf(board[i][j]));
                }
                while(s.length() < 7) {
                    s.append(" ");
                }
                System.out.print(s);
            }
            System.out.print(8 - i + "\n\n");
        }
        System.out.println("a      b      c      d      e      f      g      h      \n");
    }

    private void indexChecking(int x, int y) throws IllegalArgumentException {
        // проверка координат
        if(x < 0 | x > 7 | y < 0 | y > 7) {
            throw new IllegalArgumentException("Неверные координаты");
        }
    }

    private void kingChecking(String name, int x, int y) throws PutException {
        // проверка на соседство королей
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].equals(Piece.valueOf(name))) {
                    if ((Math.abs(x - i) == 1 & Math.abs(y - j) == 1) | (Math.abs(x - i) == 1 & y - j == 0) |
                            (x - i == 0 & Math.abs(y - j) == 1)) {
                        throw new PutException("Короли не могут стоять на соседних клетках");
                    }
                }
            }
        }
    }

}