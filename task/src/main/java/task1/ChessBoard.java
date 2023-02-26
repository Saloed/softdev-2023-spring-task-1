package task1;


import javax.naming.InvalidNameException;
import java.util.Arrays;


class Piece { // вспомогательный класс для фигур

    String name;
    public Piece (String name) {
        this.name = name;
    }

}


public class ChessBoard {


    protected final String[] availablePieces = { // список доступных фигур
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
    protected String[][] board = { // доска, реализовать нотацию, которая соотносится с индексами массива, вместо этих черточек непонятных
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_"},
    };

    public ChessBoard() throws InvalidNameException { // конструктор
        Piece bKing = new Piece("bKing");
        Piece wKing = new Piece("wKing");
        this.put(bKing, 0, 4);
        this.put(wKing, 7, 4);
    }

    public void put(Piece piece, int x, int y) throws InvalidNameException { // метод постановки фигуры на доску
        isNameAvailable(piece.name);
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
                    System.out.println("Не может быть больше 8-ми пешек одного цвета!"); // заменить бросанием исключения
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
                    System.out.println("Не может быть больше 8-ми пешек одного цвета!"); // заменить бросанием исключения
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
                    System.out.println("Такой король уже есть на доске"); // заменить бросанием исключения
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
                    System.out.println("Такой король уже есть на доске"); // заменить бросанием исключения
                }
            }
            default -> board[x][y] = piece.name;
        }
    }

    public void move(int xf, int yf, int xt, int yt) { // метод передвижения фигур
        if(!board[xf][yf].equals("_")) {
            if(board[xt][yt].equals("_")) {
                String curPiece = board[xf][yf];
                board[xf][yf] = "_";
                board[xt][yt] = curPiece;
            }
            else {
                System.out.println("Ставить фигуру некуда"); // заменить бросанием исключения
            }
        }
        else {
            System.out.println("Нечего двигать"); // заменить бросанием исключения
        }

    }

    public void remove(int x, int y) { // метод очистки клетки
        if(!board[x][y].equals("_")) {
            board[x][y] = "_";
        } else {
            System.out.println("Клетка уже пуста!"); // заменить бросанием исключения
        }

    }

    public void printBoard() { // вывести в консоль текущую ситуацию на доске
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void isNameAvailable(String name) throws InvalidNameException{ // проверка имени фигуры, стоит перенести
        // (вместе со списком доступных) в класс фигур
        if(!Arrays.asList(availablePieces).contains(name)){
            throw new InvalidNameException("Такой фигуры в наборе нет. Правила: первый символ указывает цвет (b/w)," +
                    " дальше идёт название фигуры");
        }
    }

}