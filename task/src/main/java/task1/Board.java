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


import java.util.HashSet;
import java.util.Objects;

import static java.lang.Math.*;


public class Board {
    public Figure[][] board;
    private int bPawnCount;
    private int wPawnCount;
    Figure whiteKing;
    Figure blackKing;

    HashSet<Figure> figures = new HashSet<>();

    public static boolean areKingsClose(int x1, int y1, int x2, int y2) {
        int dx = abs(x2 - x1);
        int dy = abs(y2 - y1);
        return ((dx + dy) < 2 || (dx == 1 && dy == 1));
    }

    public Board(int xWKing, int yWKing, int xBKing, int yBKing) {
        if (areKingsClose(xWKing, yWKing, xBKing, yBKing) || check(xWKing, yWKing) || check(xBKing, yBKing))
            throw new IllegalArgumentException("Неверные входные данные");
        board = new Figure[8][8];
        bPawnCount = 0;
        wPawnCount = 0;
        Figure whiteKing = new Figure(true, Type.King, xWKing, yWKing);
        this.whiteKing = whiteKing;
        Figure blackKing = new Figure(false, Type.King, xBKing, yBKing);
        this.blackKing = blackKing;
        board[xWKing][yWKing] = whiteKing;
        board[xBKing][yBKing] = blackKing;

    }

    public static boolean check(int x, int y) {
        return (x < 0) || (y < 0) || (x >= 8) || (y >= 8);
    }

    public void add(Figure f) {
        if (Objects.equals(f.type, Type.King) || board[f.x][f.y] != null) {
            throw new IllegalArgumentException("Нельзя добавить фигуру");
        }

        if (f.type.equals(Type.Pawn)) {
            if (f.isWhite && wPawnCount < 8) {
                wPawnCount++;
            } else if (!f.isWhite && bPawnCount < 8) {
                bPawnCount++;
            } else throw new IllegalArgumentException("Слишком много пешек");
        }
        board[f.x][f.y] = f;
        figures.add(f);
    }

    public void clear(int x, int y) {
        Figure f = board[x][y];
        if ((f != null)) {
            if (f.type.equals(Type.King)) {
                throw new IllegalArgumentException("Нельзя снять короля с поля");
            } else {
                if (f.type.equals(Type.Pawn)) {
                    if (f.isWhite) {
                        wPawnCount--;
                    } else
                        bPawnCount--;
                }
                board[x][y] = null;
                figures.remove(f);
            }
        }
    }

    public void move(Figure f, int x2, int y2) {
        if (board[f.x][f.y] != f || check(x2, y2) || board[x2][y2] != null) {
            throw new IllegalArgumentException("Невозможно передвинуть фигуру");
        } else {
            if (f.type.equals(Type.King)) {
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
            Figure newFig = new Figure(f.isWhite, f.type, x2, y2);
            figures.add(newFig);
            board[x2][y2] = newFig;
            figures.remove(f);
        }
    }

    public boolean isKingInCheck(boolean isWhite) {
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
                int minX = min(x, fig.x);
                int minY = min(y, fig.y);
                int maxY = max(y, fig.y);
                int maxX = max(x, fig.x);
                switch (fig.type) {
                    case Pawn:
                        if ((isWhite && (dx == -1) && (dy == -1)) ||
                                (isWhite && (dx == 1) && (dy == -1)) ||
                                (!isWhite && (dx == -1) && (dy == 1)) ||
                                (!isWhite && (dx == 1) && (dy == 1))) return true;
                        break;
                    case Knight:
                        if ((abs(dx) == 1 && abs(dy) == 2) || (abs(dx) == 2 && abs(dy) == 1)) return true;
                        break;
                    case Rook:
                        if (x == fig.x) {
                            return figuresBetweenStraightVer(x, minY, maxY);
                        }
                        if (y == fig.y) {
                            return figuresBetweenStraightHor(y, minX, maxX);
                        }
                        break;
                    case Bishop:
                        if (x - y == fig.x - fig.y) {
                            return figuresBetweenDiagonal(dif, minX, minY, 1);
                        }
                        if (x + y == fig.x + fig.y) {
                            return figuresBetweenDiagonal(dif, minX, maxY, -1);
                        }
                        break;
                    case Queen:
                        if (x == fig.x) {
                            if (figuresBetweenStraightVer(x, minY, maxY)) return true;
                        }
                        if (y == fig.y) {
                            if (figuresBetweenStraightHor(y, minX, maxX)) return true;
                        }
                        if (x - y == fig.x - fig.y) {
                            if (figuresBetweenDiagonal(dif, minX, minY, 1)) return true;
                        }
                        if (x + y == fig.x + fig.y) {
                            if (figuresBetweenDiagonal(dif, minX, maxY, -1)) return true;
                        }
                        break;
                }
            }
        }
        return false;
    }


    private Boolean figuresBetweenStraightVer(int con, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (board[con][i] != null) {
                return false;
            }
        }
        return true;
    }

    private Boolean figuresBetweenStraightHor(int con, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (board[i][con] != null) {
                return false;
            }
        }
        return true;
    }

    private Boolean figuresBetweenDiagonal(int dif, int x, int y, int sign) {
        for (int i = 1; i < dif; i++) {
            if (board[x + i][y + i * sign] != null) {
                return false;
            }
        }
        return true;
    }

    static class Figure {
        boolean isWhite;
        Type type;
        int x;
        int y;

        public Figure(boolean isWhite, Type type, int x, int y) {
            if (check(x, y)) throw new IllegalArgumentException("Нельзя cоздать фигуру");
            this.type = type;
            this.isWhite = isWhite;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int total = 31;

            total = total * 31 + type.hashCode();
            total = total * 31 + (isWhite ? 1 : 0);
            total = total * 31 + x + y;

            return total;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null) {
                if (this == obj) return true;
                if (getClass() == obj.getClass()) {
                    Figure other = (Figure) obj;
                    return type.equals(other.type) && isWhite == other.isWhite && x == other.x && y == other.y;
                }
            }
            return false;
        }

    }

    @Override
    public int hashCode() {
        int total = 31;

        total = total * 31 + blackKing.hashCode();
        total = total * 31 + whiteKing.hashCode();
        total = total * 31 + figures.hashCode();

        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) return true;
            if (getClass() == obj.getClass()) {
                Board other = (Board) obj;
                return blackKing.equals(other.blackKing) && whiteKing.equals(other.whiteKing) && figures.equals(other.figures);
            }
        }
        return false;
    }


}

enum Type {
    King, Queen, Bishop, Knight, Rook, Pawn
}
