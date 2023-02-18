package com.cube.cube;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;


public final class Cube {
    // Edge types
    private static final int F = 0;
    private static final int B = 1;
    private static final int L = 2;
    private static final int R = 3;
    private static final int U = 4;
    private static final int D = 5;

    // Size of edge
    private final int size;

    // Getter
    public int getSize() {
        return this.size;
    }

    // Key : edge type, value - edge itself
    private final Map<Integer, Matrix> allEdges = new HashMap<>();

    // Filling allEdges
    private void colorEdgesOfTheCube() {
        allEdges.put(F, new Matrix(ColorDefiner.getGREEN(), size));
        allEdges.put(B, new Matrix(ColorDefiner.getBLUE(), size));
        allEdges.put(L, new Matrix(ColorDefiner.getRED(), size));
        allEdges.put(R, new Matrix(ColorDefiner.getORANGE(), size));
        allEdges.put(U, new Matrix(ColorDefiner.getYELLOW(), size));
        allEdges.put(D, new Matrix(ColorDefiner.getWHITE(), size));
    }

    private void rotateY(boolean inClockWiseDirection) {
        Map<Integer, Matrix> listOfMatrix = new HashMap<>();
        listOfMatrix.put(U, allEdges.get(U));
        listOfMatrix.put(B, allEdges.get(B));
        listOfMatrix.put(D, allEdges.get(D));
        listOfMatrix.put(F, allEdges.get(F));
        listOfMatrix.put(R, allEdges.get(R));
        listOfMatrix.put(L, allEdges.get(L));
        if (inClockWiseDirection) {
            allEdges.put(L, listOfMatrix.get(F));
            allEdges.put(B, listOfMatrix.get(L));
            allEdges.put(R, listOfMatrix.get(B));
            allEdges.put(F, listOfMatrix.get(R));
            allEdges.get(B).rotateTwice();
            allEdges.get(U).rotate(true);
            allEdges.get(D).rotate(false);
            allEdges.get(R).rotateTwice();
        } else {
            allEdges.get(B).rotateTwice();
            allEdges.get(U).rotate(false);
            allEdges.get(D).rotate(true);
            allEdges.get(R).rotateTwice();
            allEdges.put(F, listOfMatrix.get(L));
            allEdges.put(L, listOfMatrix.get(B));
            allEdges.put(B, listOfMatrix.get(R));
            allEdges.put(R, listOfMatrix.get(F));
        }
    }

    private void rotateX(boolean inClockWiseDirection) {
        Map<Integer, Matrix> listOfMatrix = new HashMap<>();
        listOfMatrix.put(U, allEdges.get(U));
        listOfMatrix.put(B, allEdges.get(B));
        listOfMatrix.put(D, allEdges.get(D));
        listOfMatrix.put(F, allEdges.get(F));
        listOfMatrix.put(R, allEdges.get(R));
        listOfMatrix.put(L, allEdges.get(L));
        if (inClockWiseDirection) {
            allEdges.put(U, listOfMatrix.get(F));
            allEdges.put(F, listOfMatrix.get(D));
            allEdges.put(D, listOfMatrix.get(B));
            allEdges.put(B, listOfMatrix.get(U));
            allEdges.get(R).rotate(true);
            allEdges.get(L).rotate(false);
        } else {
            allEdges.get(R).rotate(false);
            allEdges.get(L).rotate(true);
            allEdges.put(F, listOfMatrix.get(U));
            allEdges.put(D, listOfMatrix.get(F));
            allEdges.put(B, listOfMatrix.get(D));
            allEdges.put(U, listOfMatrix.get(B));
        }
    }

    private void rotateZ(boolean inClockWiseDirection) {
        Map<Integer, Matrix> listOfMatrix = new HashMap<>();
        listOfMatrix.put(U, allEdges.get(U));
        listOfMatrix.put(B, allEdges.get(B));
        listOfMatrix.put(D, allEdges.get(D));
        listOfMatrix.put(F, allEdges.get(F));
        listOfMatrix.put(R, allEdges.get(R));
        listOfMatrix.put(L, allEdges.get(L));
        if (inClockWiseDirection) {
            allEdges.put(R, listOfMatrix.get(U));
            allEdges.put(D, listOfMatrix.get(R));
            allEdges.put(L, listOfMatrix.get(D));
            allEdges.put(U, listOfMatrix.get(L));
            allEdges.get(F).rotate(true);
            allEdges.get(B).rotate(false);
            allEdges.get(R).rotate(true);
            allEdges.get(D).rotate(true);
            allEdges.get(L).rotate(true);
            allEdges.get(U).rotate(true);

        } else {
            allEdges.get(F).rotate(false);
            allEdges.get(B).rotate(true);
            allEdges.get(R).rotate(false);
            allEdges.get(D).rotate(false);
            allEdges.get(L).rotate(false);
            allEdges.get(U).rotate(false);
            allEdges.put(U, listOfMatrix.get(R));
            allEdges.put(R, listOfMatrix.get(D));
            allEdges.put(D, listOfMatrix.get(L));
            allEdges.put(L, listOfMatrix.get(U));
        }
    }

    private void makeRMove(int place, boolean inClockWiseDirection) {
        // Moving all columns
        Map<Integer, List<Integer>> listOfColumnsToChange = new HashMap<>();
        listOfColumnsToChange.put(U, allEdges.get(U).getColumn(place));
        listOfColumnsToChange.put(B, allEdges.get(B).getColumn(place));
        listOfColumnsToChange.put(D, allEdges.get(D).getColumn(place));
        listOfColumnsToChange.put(F, allEdges.get(F).getColumn(place));
        if (inClockWiseDirection) {
            allEdges.get(B).setColumn(place, listOfColumnsToChange.get(U));
            allEdges.get(D).setColumn(place, listOfColumnsToChange.get(B));
            allEdges.get(F).setColumn(place, listOfColumnsToChange.get(D));
            allEdges.get(U).setColumn(place, listOfColumnsToChange.get(F));
            if (place == 0) allEdges.get(R).rotate(true);
        } else {
            allEdges.get(U).setColumn(place, listOfColumnsToChange.get(B));
            allEdges.get(B).setColumn(place, listOfColumnsToChange.get(D));
            allEdges.get(D).setColumn(place, listOfColumnsToChange.get(F));
            allEdges.get(F).setColumn(place, listOfColumnsToChange.get(U));
            if (place == 0) allEdges.get(R).rotate(false);
        }
    }

    private void makeLMove(int place, boolean inClockWiseDirection) {
        rotateY(true);
        rotateY(true);
        makeRMove(place, inClockWiseDirection);
        rotateY(true);
        rotateY(true);
    }

    private void makeFMove(int place, boolean inClockWiseDirection) {
        rotateY(false);
        makeRMove(place, inClockWiseDirection);
        rotateY(true);
    }

    private void makeBMove(int place, boolean inClockWiseDirection) {
        rotateY(true);
        makeRMove(place, inClockWiseDirection);
        rotateY(false);
    }

    private void makeDMove(int place, boolean inClockWiseDirection) {
        rotateZ(false);
        makeRMove(place, inClockWiseDirection);
        rotateZ(true);
    }

    private void makeUMove(int place, boolean inClockWiseDirection) {
        rotateZ(true);
        makeRMove(place, inClockWiseDirection);
        rotateZ(false);
    }

    private String scrambleCube() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size * 6; i++) {
            sb.append((int) Math.round(Math.random() * (size - 2)));
            sb.append(new String[]{"F", "B", "R", "L", "D", "U"}[(int) Math.round(Math.random() * 5)]);
            sb.append(new String[]{"'", ""}[(int) Math.round(Math.random() * 1)]);
            sb.append((int) Math.round(Math.random() * 2)).append(" ");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public void doSequenceOfMoves(String moves) throws IllegalArgumentException {
        String[] res = moves.split("[ ]+");
        for (String now : res) {
            // Rotation
            if (now.matches("[ ]*rotate[XYZ][*-][ ]*")) {
                boolean d;
                d = now.trim().charAt(7) == '*';
                switch (now.trim().charAt(6)) {
                    case 'X':
                        rotateX(d);
                        break;
                    case 'Y':
                        rotateY(d);
                        break;
                    case 'Z':
                        rotateZ(d);
                        break;
                }
            }
            // Scramble cube
            else if (now.matches("[ ]*scramble[ ]*") && size > 1) {
                doSequenceOfMoves(scrambleCube());
            }
            // Stop program
            else if (now.matches("[ ]*exit[ ]*")) {
                System.exit(0);
            }
            // Print state of cube
            else if (now.matches("[ ]*print[ ]*")) {
                printStateOfTheCube(System.out);
            }
            // Make moves
            else if (now.matches("[\\d]+[FBRLUD][']?[\\d]+")) {
                boolean d;
                d = now.indexOf('\'') == -1;
                // Getting rid of empty strings
                List<Integer> nums = Arrays.stream(now.split("[RFBLUD']"))
                        .filter(it -> it.length() > 0)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                // Checking whether edge exists
                if (nums.get(0) < 0 || nums.get(0) >= size - 1) {
                    throw new IllegalArgumentException();
                }
                // Moving edge
                for (int i = 0; i < nums.get(1) % 4; i++) {
                    for (char type : new char[]{'R', 'L', 'B', 'F', 'D', 'U'}) {
                        if (now.indexOf(type) != -1) {
                            switch (type) {
                                case 'R':
                                    makeRMove(nums.get(0), d);
                                    break;
                                case 'L':
                                    makeLMove(nums.get(0), d);
                                    break;
                                case 'B':
                                    makeBMove(nums.get(0), d);
                                    break;
                                case 'F':
                                    makeFMove(nums.get(0), d);
                                    break;
                                case 'U':
                                    makeUMove(nums.get(0), d);
                                    break;
                                case 'D':
                                    makeDMove(nums.get(0), d);
                                    break;
                            }
                        }
                    }
                }
            } else {
                System.out.format("%s is undefined command\n", now);
            }
        }
    }


    // Prints row in printStateOfTheCube function
    public void printRow(int color, int i, PrintStream out) {
        for (int j = 0; j < size; j++) {
            out.print(
                    ColorDefiner.getColor(allEdges.get(color).getColor(j, i), size) + " ");
        }
    }

    public void printStateOfTheCube(PrintStream out) {
        // D
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size * 2; k++) out.print(" ");
            printRow(D, i, out);
            for (int k = 0; k < size * 2; k++) out.print(" ");
            out.println();
        }
        // B
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size * 2; k++) out.print(" ");
            printRow(B, i, out);
            for (int k = 0; k < size * 2; k++) out.print(" ");
            out.println();
        }
        // L U R
        for (int i = 0; i < size; i++) {
            allEdges.get(L).rotate(true);
            printRow(L, i, out);
            allEdges.get(L).rotate(false);
            printRow(U, i, out);
            allEdges.get(R).rotate(false);
            printRow(R, i, out);
            out.println();
            allEdges.get(R).rotate(true);
        }
        // F
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size * 2; k++) out.print(" ");
            printRow(F, i, out);
            for (int k = 0; k < size * 2; k++) out.print(" ");
            out.println();
        }
    }

    public Cube(int size) throws CanNotExistException {
        if (size < 1) throw new CanNotExistException();
        this.size = size;
        colorEdgesOfTheCube();
    }
}
