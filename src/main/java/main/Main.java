package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;

public class Main {

    public static void main(String[] args) {

        int[][] A = { { 1, 2, 3, 4 } };
        int[][] B = { { 1 }, { 2 }, { 3 }, { 4 } };
        

        int[][] A1 = {   { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 } };

        int[][] B1 = {   { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 }, 
                        { 1, 2, 3, 4 } };
        

        int[][] A2 = { { 1, 2, 3, 4, 5 },
                       { 5, 4, 3, 2, 1 } };
        int[][] B2 = { { 1, 2 }, 
                       { 2, 3 }, 
                       { 3, 4 }, 
                       { 4, 5 }, 
                       { 5, 6 } };

        MatrixMultiply multiplier = new MatrixMultiply();
        
        printMatrix(multiplier.multiplyBruteForce(B2, A2));
        System.out.println("================");
        printMatrix(multiplier.multiplyRecursive(B2, A2));
        System.out.println("================");
        printMatrix(multiplier.multiplyStrassen(B2, A2));


    }


    public static void printMatrix(int[][] M) {
        for (int i = 0; i < M.length; i += 1) {
            System.out.print("{ ");
            for (int j = 0; j < M[0].length; j += 1) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println("}");
        }
    }

    public static <T> void printAsLine(List<T> list) {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <T> void printAsList(List<T> list) {
        for (T t : list) {
            System.out.println(t + " ");
        }
    }

    public static List<Entity> generateListOfEntities(int size) {
        if (size <= 0) {
            return new ArrayList<Entity>(0);
        }
        List<Entity> list = new ArrayList<>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i += 1) {
            list.add(new Entity(Data.getNextName(), rand.nextInt(10, 50)));
        }
        return list;
    }

}
