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
        else if (!Pole[y][x].equals("_")) throw new IllegalArgumentException();
        else Pole[y][x] = el;
    }

    public void del(int x, int y) {
        if (x >= size || y >= size || x < 0 || y < 0) throw new IllegalArgumentException();
        else Pole[y][x] = m[2];
    }

    public int checklen(String x) {
        for (String[] row: Pole) {
            System.out.println(Arrays.toString(row));
        }
        int l = 0, l2, l3, res = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Pole[i][j].equals(x)) {
                    l2 = j;
                    while (Pole[i][l2].equals(x) && l2 < size - 1) {
                        l++;
                        l2++;
                    }
                    res = Math.max(l, res);
                    l = 0;
                    System.out.println(res);
                    l3 = i;
                    while (Pole[l3][j].equals(x) && l3 < size - 1) {
                        l++;
                        l3++;
                    }
                    res = Math.max(l, res);
                    l = 0;
                    System.out.println(res);
                    while (Pole[l3][l2].equals(x) && l2 < size - 1 && l3 < size - 1) {
                        l++;
                        l3++;
                        l2++;
                    }
                    res = Math.max(l, res);
                    l = 0;
                    System.out.println(res);
                }
            }
        }
        return res;
    }
}