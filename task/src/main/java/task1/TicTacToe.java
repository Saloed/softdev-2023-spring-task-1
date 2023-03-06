package task1;
import static java.lang.Math.max;
public class TicTacToe {
    private final int fieldString;
    private final int fieldColumn;
    private final sign[][] field;
    public TicTacToe(int line, int column) {
        fieldString = line;
        fieldColumn = column;
        field = new sign[fieldString][fieldColumn];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                field[i][j] = sign.N;
            }
        }
    }
    public void additionCross(int line, int column) {
        if (line <= fieldString && column <= fieldColumn && field[line][column]!=sign.O) {
            field[line][column] = sign.X;
        }
    }
    public void additionZero(int line, int column) {
        if (line <= fieldString && column <= fieldColumn && field[line][column]!=sign.X) {
            field[line][column] = sign.O;
        }
    }
    public sign symbolByPosition(int line, int column) {
        return field[line][column];
    }
    public void delete(int line, int column) {
        field[line][column] = sign.N;
    }
    public int maxCross() {
        int maxx = -1;
        int count = 0;
        for (int i = 0; i < fieldString; i++) {
            for (int j = 0; j < fieldColumn; j++) {
                if (field[i][j] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int j = 0; j < fieldColumn - 1; j++) {
            for (int i = 0; i < fieldString; i++) {
                if (field[i][j] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        int c;
        int d;
        for (int i = 0; i < fieldColumn - 1; i++) {
            c = 0;
            d = i;
            while (c < fieldString && d < fieldColumn) {
                if (field[c][d] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d++;
            }
            maxx = max(count, maxx);
            count = 0;
            c = i;
            d = fieldColumn - 1;
            while (c < fieldString && d > 0) {
                if (field[c][d] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d--;
            }
            maxx = max(count, maxx);
            count = 0;
            c = i;
            d = 0;
            while (c < fieldString && d < fieldColumn) {
                if (field[c][d] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d++;
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int i = fieldColumn - 1; i > 0; i--) {
            c = 0;
            d = i;
            while (c < fieldString && d > 0) {
                if (field[c][d] == sign.X) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d--;
            }
            maxx = max(count, maxx);
            count = 0;
        }
        return maxx;
    }
    public int maxZero() {
        int maxx = -1;
        int count = 0;
        for (int i = 0; i < fieldString; i++) {
            for (int j = 0; j < fieldColumn; j++) {
                if (field[i][j] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int j = 0; j < fieldColumn; j++) {
            for (int i = 0; i < fieldString; i++) {
                if (field[i][j] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        int c;
        int d;
        for (int i = 0; i < fieldColumn - 1; i++) {
            c = 0;
            d = i;
            while (c < fieldString && d < fieldColumn) {
                if (field[c][d] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d++;
            }
            maxx = max(count, maxx);
            count = 0;
            c = i;
            d = fieldColumn - 1;
            while (c < fieldString && d > 0) {
                if (field[c][d] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d--;
            }
            maxx = max(count, maxx);
            count = 0;
            c = i;
            d = 0;
            while (c < fieldString && d < fieldColumn) {
                if (field[c][d] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d++;
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int i = fieldColumn - 1; i > 0; i--) {
            c = 0;
            d = i;
            while (c < fieldString && d > 0) {
                if (field[c][d] == sign.O) {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
                c++;
                d--;
            }
            maxx = max(count, maxx);
            count = 0;
        }
        return maxx;
    }
    public sign[][] getField() {
        return field;
    }
}
enum sign{
    X,O,N
}