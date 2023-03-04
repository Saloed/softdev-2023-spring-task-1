package task1;

import static java.lang.Math.max;

public class TicTacToe {

    //    private ArrayList<ArrayList<Character>> field = new ArrayList<>();
    private final int a;
    private final int b;
    private final char[][] key;


    public TicTacToe(int line, int colum) {
        a = line;
        b = colum;
        key = new char[a][b];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < colum; j++) {
                key[i][j] = '-';
            }
        }

    }

    public void addition(int line, int colum, char simb) {
        if (line <= a && colum <= b) {
            key[line][colum] = simb;
        }
    }

    public Character symbolByPosition(int line, int colum) {
        return key[line][colum];
    }

    public void delete(int line, int colum) {
        key[line][colum] = '-';
    }

    public int maxCross() {
        int maxx = -1;
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (key[i][j] == 'x') {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int j = 0; j < b - 1; j++) {
            for (int i = 0; i < a; i++) {
                if (key[i][j] == 'x') {
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
        for (int i = 0; i < b - 1; i++) {
            c = 0;
            d = i;
            while (c < a && d < b) {
                if (key[c][d] == 'x') {
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
        for (int i = 0; i < a - 1; i++) {
            c = i;
            d = 0;
            while (c < a && d < b) {
                if (key[c][d] == 'x') {
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
        for (int i = b - 1; i > 0; i--) {
            c = 0;
            d = i;
            while (c < a && d > 0) {
                if (key[c][d] == 'x') {
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
        for (int i = 0; i < a - 1; i++) {
            c = i;
            d = b - 1;
            while (c < a && d > 0) {
                if (key[c][d] == 'x') {
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
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (key[i][j] == 'O') {
                    count++;
                } else {
                    maxx = max(count, maxx);
                    count = 0;
                }
            }
            maxx = max(count, maxx);
            count = 0;
        }
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                if (key[i][j] == 'O') {
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
        for (int i = 0; i < b - 1; i++) {
            c = 0;
            d = i;
            while (c < a && d < b) {
                if (key[c][d] == 'O') {
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
        for (int i = 0; i < a - 1; i++) {
            c = i;
            d = 0;
            while (c < a && d < b) {
                if (key[c][d] == 'O') {
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
        for (int i = b - 1; i > 1; i--) {
            c = 0;
            d = i;
            while (c < a && d > 0) {
                if (key[c][d] == 'O') {
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
        for (int i = 0; i < a - 1; i++) {
            c = i;
            d = b - 1;
            while (c < a && d > 0) {
                if (key[c][d] == 'O') {
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

    public char[][] getField() {
        return key;
    }
}
