package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TicTacToe {
    private final int a;
    private final Marker[][] field;
    public enum Marker {
        EMPTY,
        X,
        O
    }
    public TicTacToe(int a) {
        if (a <= 0) throw new IllegalArgumentException();
        this.a = a;
        field = new Marker[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = Marker.EMPTY;
            }
        }
    }
    public void add(int x, int y, Marker q) {
        if (x <= a && y <= a && x >= 0 && y >= 0) {
            if (field[x][y] == Marker.EMPTY) field[x][y] = q;
            else throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();
    }
    public void remove(int x, int y){
        if (x <= a && y <= a && x >= 0 && y >= 0) field[x][y] = Marker.EMPTY;
        else throw new IllegalArgumentException();
    }
    public int length(Marker p) {
        int x = 0;
        int y = 0;
        boolean control = false;
        int[][] hor = new int[a][a];
        int[][] ver = new int[a][a];
        int[][] diaN = new int[a][a];
        int[][] diaZ = new int[a][a];
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int j = 0; j < a; j++) {
            for (int i = 0; i < a; i++) {
                if (Objects.equals(field[i][j], p)) {
                    if (!control) {
                        x = i;
                        y = j;
                        list.add(0);
                        control = true;
                    } else {
                        if (i == (x + 1) && j == y) {
                            hor[i][j] = hor[x][y] + 1;
                            list.add(hor[i][j]);
                        } else if (i == x && j == (y + 1)) {
                            ver[i][j] = ver[x][y] + 1;
                            list.add(ver[i][j]);
                        } else if (i == (x - 1) && j == (y + 1)) {
                            diaN[i][j] = diaN[x][y] + 1;
                            list.add(diaN[i][j]);
                        } else if (i == (x + 1) && j == (y + 1)) {
                            diaZ[i][j] = diaZ[x][y] + 1;
                            list.add(diaZ[i][j]);
                        } else {
                            i = x;
                            j = y;
                            control = false;
                        }
                    }
                }
            }
        }
        return Collections.max(list) + 1;
    }

}
