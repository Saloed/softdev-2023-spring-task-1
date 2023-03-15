package task1;

import static java.lang.Math.max;

public class TicTacToe {
    private final int fieldString;
    private final int fieldColumn;
    private final Sign[][] field;

    public TicTacToe(int line, int column) {
        fieldString = line;
        fieldColumn = column;
        field = new Sign[fieldString][fieldColumn];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                field[i][j] = Sign.N;
            }
        }
    }

    public void additionCross(int line, int column) {
        if (line <= fieldString && column <= fieldColumn && field[line][column] != Sign.O) {
            field[line][column] = Sign.X;
        }
    }

    public void additionZero(int line, int column) {
        if (line <= fieldString && column <= fieldColumn && field[line][column] != Sign.X) {
            field[line][column] = Sign.O;
        }
    }

    public Sign symbolByPosition(int line, int column) {
        if (line <= fieldString && column <= fieldColumn) {
            return field[line][column];
        }
        return Sign.N;
    }

    public void delete(int line, int column) {
        if (line <= fieldString && column <= fieldColumn) {
            field[line][column] = Sign.N;
        }
    }

    public int maxCross() {
        return maximum(Sign.X);
    }

    public int maxZero() {
        return maximum(Sign.O);
    }
    private int maximum(Sign lok){
        int maxx = maxi(lok);
        for (int i = 0; i < fieldColumn - 1; i++) {
            maxx = max(maxx, rat1(0, i, lok));
            maxx = max(maxx, rat1(i, 0, lok));
            maxx = max(maxx, rat2(i, fieldColumn - 1, lok));
        }
        for (int i = fieldColumn - 1; i > 0; i--) {
            maxx = max(maxx, rat2(0, i, lok));
        }
        return maxx;
    }
    public Sign[][] getField() {
        return field;
    }

    private int maxi(Sign lok) {
        int maxx = -1;
        int coun = 0;
        for (int i = 0; i < fieldString; i++) {
            for (int j = 0; j < fieldColumn; j++) {
                if (field[i][j] == lok) {
                    coun++;
                } else {
                    maxx = max(coun, maxx);
                    coun = 0;
                }
            }
            maxx = max(coun, maxx);
            coun = 0;
        }
        for (int j = 0; j < fieldColumn; j++) {
            for (int i = 0; i < fieldString; i++) {
                if (field[i][j] == lok) {
                    coun++;
                } else {
                    maxx = max(coun, maxx);
                    coun = 0;
                }
            }
            maxx = max(coun, maxx);
            coun = 0;
        }

        return maxx;
    }

    private int rat1(int ci, int di, Sign lok) {
        int count = 0;
        int maxx = -1;
        int c = ci;
        int d = di;
        while (c < fieldString && d < fieldColumn) {
            if (field[c][d] == lok) {
                count++;
            } else {
                maxx = max(count, maxx);
                count = 0;
            }
            c++;
            d++;
        }
        maxx = max(count, maxx);
        return maxx;
    }

    private int rat2(int c, int d, Sign lok) {
        int maxx = -1;
        int count = 0;
        while (c < fieldString && d > 0) {
            if (field[c][d] == lok) {
                count++;
            } else {
                maxx = max(count, maxx);
                count = 0;
            }
            c++;
            d--;
        }
        maxx = max(count, maxx);
        return maxx;
    }
}

enum Sign {
    X, O, N
}