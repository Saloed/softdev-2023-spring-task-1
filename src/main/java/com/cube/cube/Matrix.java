package com.cube.cube;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is responsible for storage of all colors situated
 * on the edge and convenience of moving columns to change the
 * state of the cube as well as of rotating the edges
 */

public final class Matrix {
    private final int size;
    private final List<List<Integer>> columns = new ArrayList<>();

    private void fillColumns(int color) {
        int elementInMatrix = (int) Math.pow(size, 2);
        for (int i = color * elementInMatrix; i < color * elementInMatrix + size; i++) {
            List<Integer> now = new ArrayList<>();
            for (int j = i; j < (color + 1) * elementInMatrix; j += size) {
                now.add(j);
            }
            columns.add(now);
        }
    }

    public void setColumn(int place, List<Integer> newColumn) {
        columns.set(size - place - 1, newColumn);
    }

    public List<Integer> getColumn(int place) {
        return columns.get(size - place - 1);
    }

    public int getColor(int column, int place) {
        return columns.get(column).get(place);
    }

    public void rotate(boolean inClockWiseDirection) {
        if (inClockWiseDirection) {
            Matrix newOne = new Matrix(0, size);
            for (int i = 0; i < columns.size(); i++) {
                for (int j = 0; j < size; j++) {
                    newOne.getColumn(size - 1 - j).set(i, columns.get(i).get(j));
                }
            }
            for (int i = 0; i < columns.size(); i++) {
                columns.set(i, newOne.getColumn(i));
            }
        } else {
            Matrix newOne = new Matrix(0, size);
            for (int i = 0; i < columns.size(); i++) {
                for (int j = 0; j < size; j++) {
                    newOne.getColumn(j).set(size - 1 - i, columns.get(i).get(j));
                }
            }
            for (int i = 0; i < columns.size(); i++) {
                columns.set(i, newOne.getColumn(i));
            }
        }
    }

    public void rotateTwice() {
        Matrix newOne = new Matrix(0, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < columns.size(); j++) {
                newOne.getColumn(size - 1 - i).set(size - 1 - j, columns.get(i).get(j));
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            columns.set(i, newOne.getColumn(i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < size; j++) {
            for (List<Integer> column : columns) {
                sb.append(ColorDefiner.getColor(column.get(j), size)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Matrix(int color, int size) throws IllegalArgumentException {
        this.size = size;
        if (size < 0) throw new IllegalArgumentException();
        fillColumns(color);
    }
}
