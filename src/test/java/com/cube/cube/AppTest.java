package com.cube.cube;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;


public class AppTest {
    @AfterClass
    public static void deleteBuferFile() {
        try {
            new File("./buferFile.txt").delete();
        } catch (Exception e) {
            System.out.println(1);
        }
    }

    @Test
    public void checkSize() {
        try {
            Cube cube = new Cube(123);
            Assert.assertEquals(cube.getSize(), 123);
        } catch (CanNotExistException e) {
            Assert.fail();
        }
    }

    @Test
    public void checkWorkForFourEdges() {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("checkWorkForFourEdges.txt"))
        );
             PrintStream out = new PrintStream("buferFile.txt")) {
            Cube cube = new Cube(4);
            cube.doSequenceOfMoves(in.readLine());
            cube.printStateOfTheCube(out);
        } catch (CanNotExistException e) {
            Assert.fail();
        } catch (FileNotFoundException e) {
            Assert.fail();
        } catch (IOException e) {
            Assert.fail();
        }

        try (BufferedReader in1 = new BufferedReader(
                new FileReader("buferFile.txt"));
             BufferedReader in2 = new BufferedReader(
                     new InputStreamReader(getClass().getClassLoader().getResourceAsStream("checkWorkForFourEdgesResult.txt")))) {
            while (true) {
                String st1 = in1.readLine();
                String st2 = in2.readLine();
                if (st1 == null || st2 == null) break;
                st1 = st1.trim();
                st2 = st2.trim();
                if (!st1.equals(st2)) Assert.fail();
                ;
            }
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Test
    public void checkWorkForThreeEdges() {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("checkWorkForThreeEdges.txt"))
        );
             PrintStream out = new PrintStream("buferFile.txt")) {
            Cube cube = new Cube(3);
            cube.doSequenceOfMoves(in.readLine());
            cube.printStateOfTheCube(out);
        } catch (CanNotExistException e) {
            Assert.fail();
        } catch (FileNotFoundException e) {
            Assert.fail();
        } catch (IOException e) {
            Assert.fail();
        }

        try (BufferedReader in1 = new BufferedReader(
                new FileReader("buferFile.txt"));
             BufferedReader in2 = new BufferedReader(
                     new InputStreamReader(getClass().getClassLoader().getResourceAsStream("checkWorkForThreeEdgesResult.txt")))) {
            while (true) {
                String st1 = in1.readLine();
                String st2 = in2.readLine();
                if (st1 == null || st2 == null) break;
                st1 = st1.trim();
                st2 = st2.trim();
                if (!st1.equals(st2)) Assert.fail();
                ;
            }
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.fail();
        }
    }
}
