package entities;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMultiplyTest {

    @Test
    public void multiply1x4and4x1() {
        int[][] A = { { 1, 2, 3, 4 } };
        int[][] B = { { 1 }, { 2 }, { 3 }, { 4 } };
        MatrixMultiply multiplier = new MatrixMultiply();

        int[][] brute = multiplier.multiplyBruteForce(A, B);
        int[][] recursive = multiplier.multiplyRecursive(A, B);
        Assert.assertTrue(isMatrixesAreEqual(brute, recursive));
    }

    @Test
    public void multiply4x1and1x4() {
        int[][] A = { { 1, 2, 3, 4 } };
        int[][] B = { { 1 }, { 2 }, { 3 }, { 4 } };
        MatrixMultiply multiplier = new MatrixMultiply();

        int[][] brute = multiplier.multiplyBruteForce(B, A);
        int[][] recursive = multiplier.multiplyRecursive(B, A);
        Assert.assertTrue(isMatrixesAreEqual(brute, recursive));
    }

    @Test
    public void multiply4x4and4x4() {
        int[][] A = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
        int[][] B = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
        MatrixMultiply multiplier = new MatrixMultiply();

        int[][] brute = multiplier.multiplyBruteForce(A, B);
        int[][] recursive = multiplier.multiplyRecursive(A, B);

        Assert.assertTrue(isMatrixesAreEqual(brute, recursive));
    }

    @Test
    public void multiply2x5and5x2() {
        int[][] A = { { 1, 2, 3, 4, 5 }, { 5, 4, 3, 2, 1 } };
        int[][] B = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 } };
        MatrixMultiply multiplier = new MatrixMultiply();

        int[][] brute = multiplier.multiplyBruteForce(A, B);
        int[][] recursive = multiplier.multiplyRecursive(A, B);

        Assert.assertTrue(isMatrixesAreEqual(brute, recursive));
    }

    @Test
    public void multiply5x2and2x5() {
        int[][] A = { { 1, 2, 3, 4, 5 }, { 5, 4, 3, 2, 1 } };
        int[][] B = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 } };
        MatrixMultiply multiplier = new MatrixMultiply();

        int[][] brute = multiplier.multiplyBruteForce(B, A);
        int[][] recursive = multiplier.multiplyRecursive(B, A);

        Assert.assertTrue(isMatrixesAreEqual(brute, recursive));
    }

    
    private boolean isMatrixesAreEqual(final int[][] A, final int[][] B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.length == 0 && B.length == 0) {
            return true;
        }
        if (A.length != B.length || A[0].length != B[0].length) {
            return false;
        }
        for (int i = 0; i < A.length; i += 1) {
            for (int j = 0; j < A[0].length; j += 1) {
                if (A[j][i] != B[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

}
