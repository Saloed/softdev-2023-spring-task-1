package task1;

import java.util.Arrays;


// Вариант 15 -- поле для крестиков-ноликов [Java]
// Хранит квадратное поле для игры в крестики-нолики заданного в конструкторе размера.
// Методы: добавление крестика / нолика в заданную клетку, очистка заданной клетки, поиск самой
// длинной последовательности крестиков (непрерывной линии по горизонтали / вертикали / диагонали),
// то же для ноликов.


public class TicTac {
    final String[] m = {"x", "o", "_"};
    final int size;
    String[][] Pole;

    public TicTac(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        this.size = size;
        Pole = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pole[i][j] = m[2];
            }
        }
    }

    public void add(int x, int y, String el) {
        if (x >= size || y >= size || x < 0 || y < 0 || !Arrays.asList(m).contains(el))
            throw new IllegalArgumentException();
        else if (!Pole[x][y].equals("_")) throw new IllegalArgumentException();
        else Pole[x][y] = el;
    }

    public void del(int x, int y) {
        if (x >= size || y >= size || x < 0 || y < 0) throw new IllegalArgumentException();
        else Pole[x][y] = m[2];
    }

    public int checklen(String x) {
        for (String[] r : Pole) {
            System.out.println(Arrays.toString(r));
        }
        int l = 1, vs, sh, res = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sh = j;
                while (Pole[i][sh].equals(x) && sh < size - 1) {
                    l++;
                    sh++;
                }
                res = Math.max(l, res);
                l = 1;
                vs = i;
                while (Pole[vs][j].equals(x) && vs < size - 1) {
                    l++;
                    vs++;
                }
                res = Math.max(l, res);
                l = 1;
                sh = j;
                vs = i;
                while (Pole[vs][sh].equals(x) && sh < size - 1 && vs < size - 1) {
                    l++;
                    vs++;
                    sh++;
                }
                res = Math.max(l, res);
                l = 1;
                sh = j;
                vs = i;
                while (Pole[vs][sh].equals(x) && sh < size - 1 && vs < size - 1 && sh > 0) {
                    Pole[vs][sh] = m[2];
                    sh--;
                    vs++;
                    l++;
                }
                res = Math.max(l, res);
            }
        }
        return res;
    }
}