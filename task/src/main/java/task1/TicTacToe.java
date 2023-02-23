package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class TicTacToe {
    private final int a;
    private static String[][] field;
    public TicTacToe(int a) {
        if (a > 0) {
        this.a = a;
        field = new String[a][a];
        } else throw new IllegalArgumentException();
    }
    public void add(int x, int y, String p){
        if (field[x][y] == null && (p == "X" || p == "O")) {
            if (x <= a && y <= a && x >= 0 && y >= 0) {
                field[x][y] = p;
            } else throw new ArrayIndexOutOfBoundsException();
        } else throw new IllegalArgumentException();
    }
    public void remove(int x, int y){
        if (x <= a && y <= a && x >= 0 && y >= 0) field[x][y] = null;
        else throw new IllegalArgumentException();
    }
    public int length(String p) {
        if (p == "X" || p == "O") {
            int x = 0;
            int y = 0;
            int control = 0;
            int[][] hor = new int[a][a];
            int[][] ver = new int[a][a];
            int[][] diaN = new int[a][a];
            int[][] diaZ = new int[a][a];
            ArrayList<Integer> list = new ArrayList<>();
            list.add(-1);
            for (int j = 0; j < a; j++) {
                for (int i = 0; i < a; i++) {
                    if (Objects.equals(field[i][j], p)) {
                        if (control == 0) {
                            x = i;
                            y = j;
                            list.add(0);
                            control = 1;
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
                                control = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(list);
            return Collections.max(list) + 1;
        } else throw new IllegalArgumentException();
    }

}
