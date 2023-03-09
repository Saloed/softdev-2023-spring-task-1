package task1;
/*Вариант 20 -- поле для шахмат [Java]
меет размер 8х8, на каждой клетке может стоять белая или чёрная фигура.
Фигур шесть видов: пешка, конь, слон, ладья, ферзь, король.

Ограничения (инварианты), которые требуется соблюсти: ровно один белый король,
ровно один чёрный король, не более восьми белых пешек, не более восьми чёрных пешек,
короли не могут находиться на соседних клетках.

                           Операции:
 конструктор (сразу же указывает положение белого и чёрного короля),
 очистить клетку, поставить новую фигуру (кроме короля)
 переместить существующую фигуру на другую клетку (соблюдать правила ходов не надо).
Бонус: проверить, находится ли определённый король под шахом (можно поддержать все или часть фигур).*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.*;


public class Board {
    public static Figure[][] board;
    private static int BPawnCount;
    private static int WPawnCount;
    Figure whiteKing;
    Figure blackKing;

    ArrayList<Figure> figures = new ArrayList<>();

    public boolean areKingsClose(int x1, int y1, int x2, int y2) {
        int dx = abs(x2 - x1);
        int dy = abs(y2 - y1);
        return ((dx + dy) < 2 || (dx == 1 && dy == 1));
    }

    public Board(int xWKing, int yWKing, int xBKing, int yBKing) {
        if (areKingsClose(xWKing, yWKing, xBKing, yBKing) || !check(xWKing, yWKing) || !check(xBKing, yBKing))
            throw new IllegalArgumentException("Неверные входные данные");
        else {
            board = new Figure[8][8];
            BPawnCount = 0;
            WPawnCount = 0;
            Figure whiteKing = new Figure(true, "King", xWKing, yWKing);
            this.whiteKing = whiteKing;
            Figure blackKing = new Figure(false, "King", xBKing, yBKing);
            this.blackKing = blackKing;
            board[xWKing][yWKing] = whiteKing;
            board[xBKing][yBKing] = blackKing;
        }
    }

    public static boolean check(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < 8) && (y < 8);
    }

    public void add(Figure f) throws IllegalArgumentException {
        if (!Objects.equals(f.type, "King") && board[f.x][f.y] == null) {
            if (f.type.equals("Pawn")) {
                if (f.isWhite && WPawnCount < 8) {
                    WPawnCount++;
                } else if (!f.isWhite && BPawnCount < 8) {
                    BPawnCount++;
                } else throw new IllegalArgumentException("Слишком много пешек");
            }
            board[f.x][f.y] = f;
            figures.add(f);
        } else throw new IllegalArgumentException("Нельзя добавить фигуру");
    }

    public void clear(int x, int y) {
        Figure f = board[x][y];
        if ((f != null)) {
            if (!f.type.equals("King")) {
                if (f.type.equals("Pawn")) {
                    if (f.isWhite) {
                        WPawnCount--;
                    } else
                        BPawnCount--;
                }
                board[x][y] = null;
                figures.remove(f);
            } else throw new IllegalArgumentException("Нельзя снять короля с поля");
        }
    }

    public void move(Figure f, int x2, int y2) throws IllegalArgumentException {
        if (board[f.x][f.y] == f && check(x2, y2) && board[x2][y2] == null) {
            if (f.type.equals("King")) {
                if (f.isWhite) {
                    if (areKingsClose(x2, y2, blackKing.x, blackKing.y)) {
                        throw new IllegalArgumentException("Невозможно передвинуть фигуру");
                    } else {
                        blackKing.x = x2;
                        blackKing.y = y2;
                    }
                } else if (areKingsClose(x2, y2, whiteKing.x, whiteKing.y)) {
                    throw new IllegalArgumentException("Невозможно передвинуть фигуру");
                } else {
                    whiteKing.x = x2;
                    whiteKing.y = y2;
                }
            }
            board[f.x][f.y] = null;
            board[x2][y2] = f;
            f.x = x2;
            f.y = y2;

        } else
            throw new IllegalArgumentException("Невозможно передвинуть фигуру");

    }

    public Boolean isKingInCheck(boolean isWhite) {
        int x;
        int y;
        if (isWhite) {
            x = whiteKing.x;
            y = whiteKing.y;
        } else {
            x = blackKing.x;
            y = blackKing.y;
        }
        for (Figure fig : figures) {
            if (fig.isWhite != isWhite) {
                int dx = x - fig.x;
                int dy = y - fig.y;
                int dif = abs(fig.y - y);
                switch (fig.type) {
                    case "Pawn":
                        if ((isWhite && (dx == -1) && (dy == -1)) ||
                                (isWhite && (dx == 1) && (dy == -1)) ||
                                (!isWhite && (dx == -1) && (dy == 1)) ||
                                (!isWhite && (dx == 1) && (dy == 1))) return true;
                        break;
                    case "Knight":
                        if ((abs(dx) == 1 && abs(dy) == 2) || (abs(dx) == 2 && abs(dy) == 1)) return true;
                        break;
                    case "Rook":
                        if (x == fig.x) {
                            return figuresBetweenStraight(x, y, fig.y);
                        }
                        if (y == fig.y) {
                            return figuresBetweenStraight(y, x, fig.x);
                        }
                        break;
                    case "Bishop":
                        if (x - y == fig.x - fig.y) {
                            return figuresBetweenSecDiagonal(dif, min(x, fig.x), min(y, fig.y));
                        }
                        if (x + y == fig.x + fig.y) {
                            return figuresBetweenPrimDiagonal(dif, min(x, fig.x), max(y, fig.y));
                        }
                        break;
                    case "Queen":
                        if (x == fig.x) {
                            if (figuresBetweenStraight(x, y, fig.y)) return true;
                        }
                        if (y == fig.y) {
                            if(figuresBetweenStraight(y, x, fig.x)) return true;
                        }
                        if (x - y == fig.x - fig.y) {
                            if(figuresBetweenSecDiagonal(dif, min(x, fig.x), min(y, fig.y))) return true;
                        }
                        if (x + y == fig.x + fig.y) {
                           if(figuresBetweenPrimDiagonal(dif, min(x, fig.x), max(y, fig.y))) return true;
                        }
                        break;
                    default:
                }
            }
        }
        return false;
    }


    private Boolean figuresBetweenStraight(int con, int var1, int var2) {
        boolean flag = true;
        int start = min(var1, var2);
        int end = max(var1, var2);
        for (int i = start + 1; i < end; i++) {
            if (board[con][i] != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Boolean figuresBetweenSecDiagonal(int dif, int x, int y) {
        boolean flag = true;
        for (int i = 1; i < dif; i++) {
            if (board[x + i][y + i] != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Boolean figuresBetweenPrimDiagonal(int dif, int x, int y) {
        boolean flag = true;
        for (int i = 1; i < dif; i++) {
            if (board[x + i][y - i] != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    static class Figure {
        boolean isWhite;
        String type;
        int x;
        int y;

        public Figure(boolean isWhite, String type, int x, int y) throws IllegalArgumentException {
            List<String> figures = new ArrayList<>(Arrays.asList( //зачем заносить в конструктор?
                    "King", "Queen", "Bishop", "Knight", "Rook", "Pawn"));
            if (figures.contains(type)) {
                this.type = type;
                this.isWhite = isWhite;
                this.x = x;
                this.y = y;
                if (board[x][y] != null || !check(x, y)) System.out.println("Нельзя cоздать фигуру");
            } else throw new IllegalArgumentException("Неправильный тип фигуры");
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (getClass() == obj.getClass()) {
                Figure other = (Figure) obj;
                return type == other.type && isWhite == other.isWhite && x == other.x && y == other.y;
            }
            return false;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() == obj.getClass()) {
            Board other = (Board) obj;
            for (Figure fig : figures) {
                if (!other.figures.contains(fig)) return false;
            }
            return blackKing.equals(other.blackKing) && whiteKing.equals(other.whiteKing) && figures.size() == other.figures.size();
        }
        return false;
    }
}

