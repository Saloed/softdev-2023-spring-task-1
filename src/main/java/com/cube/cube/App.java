package com.cube.cube;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            try {
                System.out.println("Write type of cube:");
                int n;
                n = Integer.parseInt(in.nextLine());
                Cube cube = new Cube(n);
                while (true) {
                    try {
                        System.out.println("Command:");
                        String input = in.nextLine();
                        cube.doSequenceOfMoves(input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong command");
                    }
                }
            } catch (CanNotExistException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println("Size of cube should be number");
            }
        } catch (Exception e) {
            System.out.println("Can't use stream");
        }
    }
}
