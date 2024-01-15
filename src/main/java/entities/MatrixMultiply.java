package entities;

public class MatrixMultiply {

    /*
     * since we use matrix in this section, I will use A, B, C (etc.) naming for
     * matrix names instead of arr1, arr2 (etc.)
     */

    public int[][] matrixMultipleyBruteForce(final int[][] A, final int[][] B) {

        if (!isValidForMultiply(A, B)) {
            System.out.println("Provided matrixed are not valid for multiplying");
            return new int[1][1];
        }

        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i += 1) {
            for (int j = 0; j < B[0].length; j += 1) {
                C[i][j] = multiplyRows(A, B, i, j);
            }
        }

        return C;
    }

    private int multiplyRows(final int[][] A, final int[][] B, int colA, int rowB) {
        int summ = 0;
        for (int i = 0; i < A[0].length; i += 1) {
            summ += A[colA][i] * B[i][rowB];
        }
        return summ;
    }

    public int[][] devideThem(final int[][] A, final int[][] B) {
        if (!isValidForMultiply(A, B)) {
            System.out.println("Provided matrixed are not valid for multiplying");
            return new int[1][1];
        }

        return matrixMultiplyDivide(A, B);
    }

    private boolean isValidForMultiply(final int[][] A, final int[][] B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.length < 1 || B.length < 1 || A[0].length < 1 || B[0].length < 1) {
            return false;
        }
        if (A[0].length != B.length) {
            return false;
        }
        return true;
    }

    private int[][] matrixMultiplyDivide(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        if (A.length == 1 && A[0].length == 1 && B.length == 1 && B[0].length == 1) {
            int[][] ans = new int[1][1];
            ans[0][0] = A[0][0] * B[0][0];
            return ans;
        } else {
            int midXA, midYA, midXB, midYB;

            midXA = A[0].length / 2;
            midYA = A.length / 2;
            midXB = B[0].length / 2;
            midYB = B.length / 2;

            if (midXA == 0)
                midXA++;
            if (midYA == 0)
                midYA++;
            if (midXB == 0)
                midXB++;
            if (midYB == 0)
                midYB++;

            int[][] X1, X2, C11, C12, C21, C22;
            int[][] A11, A12, A21, A22, B11, B12, B21, B22;

            A11 = getArrWithNewBounds(A, 0, 0, midXA, midYA);
            A12 = getArrWithNewBounds(A, midXA, 0, A[0].length, midYA);
            A21 = getArrWithNewBounds(A, 0, midYA, midXA, A.length);
            A22 = getArrWithNewBounds(A, midXA, midYA, A[0].length, A.length);

            B11 = getArrWithNewBounds(B, 0, 0, midXB, midYB);
            B12 = getArrWithNewBounds(B, midXB, 0, B[0].length, midYB);
            B21 = getArrWithNewBounds(B, 0, midYB, midXB, B.length);
            B22 = getArrWithNewBounds(B, midXB, midYB, B[0].length, B.length);

            X1 = matrixMultiplyDivide(A11, B11);
            X2 = matrixMultiplyDivide(A12, B21);
            C11 = summOfMatrix(X1, X2);

            X1 = matrixMultiplyDivide(A11, B12);
            X2 = matrixMultiplyDivide(A12, B22);
            C12 = summOfMatrix(X1, X2);

            X1 = matrixMultiplyDivide(A21, B11);
            X2 = matrixMultiplyDivide(A22, B21);
            C21 = summOfMatrix(X1, X2);

            X1 = matrixMultiplyDivide(A21, B12);
            X2 = matrixMultiplyDivide(A22, B22);
            C22 = summOfMatrix(X1, X2);

            int[][] ans = new int[A.length][B[0].length];
            fillAns(ans, C11, 0, 0);
            fillAns(ans, C12, C11[0].length, 0);
            fillAns(ans, C21, 0, C11.length);
            fillAns(ans, C22, C11[0].length, C11.length);

            return ans;
        }
    }

    private void fillAns(int[][] C, int[][] M, int x, int y) {
        if (M.length == 0 || M[0].length == 0) {
            return;
        }
        for (int i = 0; i < M[0].length; i += 1) {
            for (int j = 0; j < M.length; j += 1) {
                C[y + j][x + i] = M[j][i];
            }
        }
    }

    private int[][] getArrWithNewBounds(int[][] M, int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return new int[0][0];
        }
        int[][] C = new int[y2 - y1][x2 - x1];
        for (int i = 0; i < (x2 - x1); i += 1) {
            for (int j = 0; j < (y2 - y1); j += 1) {
                C[j][i] = M[y1 + j][x1 + i];
            }
        }
        return C;
    }

    private int[][] summOfMatrix(int[][] A, int[][] B) {
        if (A.length == 0 && B.length == 0) {
            return new int[0][0];
        } else {

            if (A.length == 0) {
                return B;
            } else if (B.length == 0) {
                return A;
            } else {
                int[][] C = new int[A.length][A[0].length];
                for (int i = 0; i < C.length; i += 1) {
                    for (int j = 0; j < C[0].length; j += 1) {
                        C[i][j] = A[i][j] + B[i][j];
                    }
                }
                return C;
            }
        }
    }

}
