package com.cube.cube;

import java.lang.Math;

public final class ColorDefiner {
    // Colors
    private static final int GREEN = 0;
    private static final int BLUE = 1;
    private static final int RED = 2;
    private static final int ORANGE = 3;
    private static final int YELLOW = 4;
    private static final int WHITE = 5;

    // Getters for colors
    public static int getGREEN() {
        return GREEN;
    }

    public static int getBLUE() {
        return BLUE;
    }

    public static int getRED() {
        return RED;
    }

    public static int getORANGE() {
        return ORANGE;
    }

    public static int getYELLOW() {
        return YELLOW;
    }

    public static int getWHITE() {
        return WHITE;
    }

    // First symbol of color's name
    public static char getColor(int number, int size) {
        if (0 <= number && number < 1 * Math.pow(size, 2)) {
            return 'G';
        } else if (Math.pow(size, 2) <= number && number < 2 * Math.pow(size, 2)) {
            return 'B';
        } else if (2 * Math.pow(size, 2) <= number && number < 3 * Math.pow(size, 2)) {
            return 'R';
        } else if (3 * Math.pow(size, 2) <= number && number < 4 * Math.pow(size, 2)) {
            return 'O';
        } else if (4 * Math.pow(size, 2) <= number && number < 5 * Math.pow(size, 2)) {
            return 'Y';
        }
        return 'W';
    }

}
