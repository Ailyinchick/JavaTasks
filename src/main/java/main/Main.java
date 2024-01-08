package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;

public class Main {

    public static void main(String[] args) {

        int[][] arr1 = { { 0, 5, 4, 2}, { -1, 0, 1, 3 }, { 0, 5, 4, 2}, { -1, 0, 1, 3 }};

        int[][] arr2 = { { -1, 0, 8, 0 }, { 5, -2, 0, 4 }, { -1, 0, 8, 0 }, { 5, -2, 0, 4 }};

        int[][] ans = squareMatrixMultiply(arr1, arr2);

        printMatrix(ans);

    }

    public static void printMatrix(int[][] M) {
        int width = M.length;
        int height = M[0].length;
        for (int i = 0; i < height; i += 1) {
            System.out.print("{ ");
            for (int j = 0; j < width; j += 1) {
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

    // accepts square matrix with side 1, 2, 4, 8... etc. (x^2)
    public static int[][] squareMatrixMultiply(final int[][] arr1, final int[][] arr2) {
        if (arr1 == null || arr2 == null) {
            return new int[1][1];
        }
        if (!isPowOfTwo(arr1.length) || !isPowOfTwo(arr2.length) || !isPowOfTwo(arr1[0].length)
                || !isPowOfTwo(arr2[0].length)) {
            return new int[1][1];
        }
        if (!(arr1.length == arr1[0].length && arr1.length == arr2.length && arr1.length == arr2[0].length)) {
            return new int[1][1];
        }
        return pow2MatrixMultiply(arr1, arr2, 0, 0, 0, 0, arr1.length);
    }

    private static int[][] pow2MatrixMultiply(final int[][] A, final int[][] B, int x1, int y1, int x2, int y2,
            int len) {

        if (len == 1) {
            int[][] ans = new int[1][1];
            ans[0][0] = A[x1][y1] * B[x2][y2];
            return ans;
        } else {
            int newLen = len / 2;
            int[][] X1, X2;
            // 1 block
            X1 = pow2MatrixMultiply(A, B, x1, y1, x2, y2, newLen);
            X2 = pow2MatrixMultiply(A, B, x1, y1 + newLen, x2 + newLen, y2, newLen);
            int[][] C11 = summOfSqareMatrix(X1, X2);
            // 2 block
            X1 = pow2MatrixMultiply(A, B, x1, y1, x2, y2 + newLen, newLen);
            X2 = pow2MatrixMultiply(A, B, x1, y1 + newLen, x2 + newLen, y2 + newLen, newLen);
            int[][] C12 = summOfSqareMatrix(X1, X2);        
            // 3 block
            X1 = pow2MatrixMultiply(A, B, x1 + newLen, y1, x2, y2, newLen);
            X2 = pow2MatrixMultiply(A, B, x1 + newLen, y1 + newLen, x2 + newLen, y2, newLen);
            int[][] C21 = summOfSqareMatrix(X1, X2);
            // 4 block
            X1 = pow2MatrixMultiply(A, B, x1 + newLen, y1, x2, y2 + newLen, newLen);
            X2 = pow2MatrixMultiply(A, B, x1 + newLen, y1 + newLen, x2 + newLen, y2 + newLen, newLen);
            int[][] C22 = summOfSqareMatrix(X1, X2);
            // collect four blocks together
            int[][] ans = new int[len][len];
            fillFirst(ans, 0, 0, C11, newLen);
            fillFirst(ans, 0, 0  + newLen, C12, newLen);
            fillFirst(ans, 0 + newLen, 0, C21, newLen);
            fillFirst(ans, 0 + newLen, 0 + newLen, C22, newLen);
            return ans;
        }

    }

    // write values to C[][] from A[][] in specific block
    private static void fillFirst(int[][] C, int x, int y, final int[][] A, int len) {
        for (int i = 0; i < len; i += 1) {
            for (int j = 0; j < len; j += 1) {
                C[x + i][y + j] = A[i][j];
            }
        }
    }

    // only square matrix are valid
    private static int[][] summOfSqareMatrix(final int[][] A, final int[][] B) {
        int len = A.length;
        int[][] C = new int[len][len];
        for (int i = 0; i < len; i += 1) {
            for (int j = 0; j < len; j += 1) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // 1 is also correct value
    // negative values are not allowed
    private static boolean isPowOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int div = number;
        while (div > 1) {
            if (div % 2 == 1) {
                return false;
            }
            div = div / 2;
        }
        return true;
    }

}
