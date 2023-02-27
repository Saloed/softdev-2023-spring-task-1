package task1;


import java.util.Arrays;
import java.util.NoSuchElementException;


class Piece {
    // вспомогательный класс для фигур

    String name;
    public Piece (String name) {
        this.name = name;
    }

    protected static final String[] availablePieces = {
            // список доступных фигур
            "bPawn",
            "wPawn",
            "bKnight",
            "wKnight",
            "bBishop",
            "wBishop",
            "bRook",
            "wRook",
            "bQueen",
            "wQueen",
            "bKing",
            "wKing"
    };

    protected static void isNameAvailable(String name) throws IllegalArgumentException {
        if(!Arrays.asList(availablePieces).contains(name)){
            throw new IllegalArgumentException(
                    "Такой фигуры в наборе нет. Правила: первый символ указывает цвет (b/w), дальше идёт название фигуры"
            );
        }
    }
}



class PutException extends Exception {
    private String message;

    public PutException(String s) {
        this.message = s;
    }

    public String toString(String s) {
        return message;
    }
}

class MoveException extends Exception {

    private String message;

    public MoveException(String s) {
        this.message = s;
    }

    public String toString(String s) {
        return message;
    }

}

public class ChessBoard {
    // добавить проверку на то, что короли не стоят на соседних клетках
    // проверка находится ли король под шахом
    // добавить метод дефолтной расстановки фигур ну так по приколу

    protected String[][] board = {
            // доска
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
    };

    public ChessBoard() throws IllegalArgumentException, PutException{
        // конструктор
        Piece bKing = new Piece("bKing");
        Piece wKing = new Piece("wKing");
        this.put(bKing, 0, 4);
        this.put(wKing, 7, 4);
    }

    public void put(Piece piece, int x, int y) throws IllegalArgumentException, PutException {
        // метод постановки фигуры на доску
        Piece.isNameAvailable(piece.name);
        if(!board[x][y].equals("_")) {
            throw new PutException("Клетка уже занята");
        }
        switch (piece.name) {
            case ("bPawn") -> {
                int bpCount = 0;
                for (String[] line : board) {
                    for (String square : line) {
                        if (square.equals("bPawn")) {
                            bpCount++;
                        }
                    }
                }
                if (bpCount <= 7) {
                    board[x][y] = piece.name;
                } else {
                    throw new PutException("Не может быть больше 8-ми пешек одного цвета");
                }
            }
            case ("wPawn") -> {
                int wpCount = 0;
                for (String[] line : board) {
                    for (String square : line) {
                        if (square.equals("wPawn")) {
                            wpCount++;
                        }
                    }
                }
                if (wpCount <= 7) {
                    board[x][y] = piece.name;
                } else {
                    throw new PutException("Не может быть больше 8-ми пешек одного цвета");
                }
            }
            case ("bKing") -> {
                int bkCount = 0;
                for (String[] line : board) {
                    for (String square : line) {
                        if (square.equals("bKing")) {
                            bkCount++;
                            break;
                        }
                    }
                }
                if (bkCount == 0) {
                    board[x][y] = piece.name;
                } else {
                    throw new PutException("Такой король уже есть на доске");
                }
            }
            case ("wKing") -> {
                int wkCount = 0;
                for (String[] line : board) {
                    for (String square : line) {
                        if (square.equals("wKing")) {
                            wkCount++;
                            break;
                        }
                    }
                }
                if (wkCount == 0) {
                    board[x][y] = piece.name;
                } else {
                    throw new PutException("Такой король уже есть на доске");
                }
            }
            default -> board[x][y] = piece.name;
        }
    }

    public void move(int xf, int yf, int xt, int yt) throws MoveException, NoSuchElementException {
        // метод передвижения фигур
        if(!board[xf][yf].equals("_")) {
            if(board[xt][yt].equals("_")) {
                String curPiece = board[xf][yf];
                board[xf][yf] = "_";
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

    public void remove(int x, int y) {
        // метод очистки клетки
        if(!board[x][y].equals("_")) {
            board[x][y] = "_";
        } else {
            throw new NoSuchElementException("исходная клетка пуста");
        }

    }

    public void printBoard() {
        // вывести в консоль текущую позицию(±красиво и с нотацией)
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                StringBuilder s = new StringBuilder(board[i][j]);
                while(s.length() < 7) {
                    s.append(" ");
                }
                System.out.print(s);
            }
            System.out.print(8 - i + "\n\n");
        }
        System.out.println("a      b      c      d      e      f      g      h      \n");
    }

}