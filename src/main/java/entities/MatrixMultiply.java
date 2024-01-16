package entities;

public class MatrixMultiply {

    /*
     * since we use matrix in this section, I will use A, B, C (etc.) naming for
     * matrix names instead of arr1, arr2 (etc.)
     */

    public int[][] multiplyBruteForce(final int[][] A, final int[][] B) {
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

    public int[][] multiplyRecursive(final int[][] A, final int[][] B) {
        if (!isValidForMultiply(A, B)) {
            System.out.println("Provided matrixed are not valid for multiplying");
            return new int[1][1];
        }
        int[][] squareA, squareB;
        squareA = makeSquareMatrix(A);
        squareB = makeSquareMatrix(B);
        int[][] ans = new int[A.length][B[0].length];
        ans = getArrWithNewBounds(multiplyMatrixRecursive(squareA, squareB), 0, 0, A.length, B[0].length);
        return ans;
    }

    public int[][] multiplyStrassen(final int[][] A, final int[][] B) {
        if (!isValidForMultiply(A, B)) {
            System.out.println("Provided matrixed are not valid for multiplying");
            return new int[1][1];
        }
        int[][] squareA, squareB;
        squareA = makeSquareMatrix(A);
        squareB = makeSquareMatrix(B);
        int[][] ans = new int[A.length][B[0].length];
        ans = getArrWithNewBounds(multiplyMatrixStrassen(squareA, squareB), 0, 0, A.length, B[0].length);
        return ans;
    }

    private int[][] makeSquareMatrix(final int[][] M) {
        int max = Math.max(M.length, M[0].length);
        int size = 2;
        while (size < max) {
            size = size << 1;
        }
        int[][] C = new int[size][size];
        for (int i = 0; i < M.length; i += 1) {
            System.arraycopy(M[i], 0, C[i], 0, M[i].length);
        }
        return C;
    }

    private int[][] getArrWithNewBounds(final int[][] M, int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return new int[0][0];
        }
        int[][] C = new int[y2 - y1][x2 - x1];
        for (int i = 0; i < (y2 - y1); i += 1) {
            System.arraycopy(M[y1 + i], x1, C[i], 0, (x2 - x1));
        }
        return C;
    }

    private int[][] multiplyMatrixStrassen(final int[][] A, final int[][] B) {
        if (A.length == 1 && A[0].length == 1 && B.length == 1 && B[0].length == 1) {
            int[][] ans = new int[1][1];
            ans[0][0] = A[0][0] * B[0][0];
            return ans;
        }
        int[][] C11, C12, C21, C22;
        int[][] S1, S2, S3, S4, S5, S6, S7, S8, S9, S10;
        int[][] P1, P2, P3, P4, P5, P6, P7;

        int[][][] mA = splitM(A);
        int[][][] mB = splitM(B);

        S1 = addWithSign(mB[1], mB[3], -1);
        S2 = addWithSign(mA[0], mA[1], 1);
        S3 = addWithSign(mA[2], mA[3], 1);
        S4 = addWithSign(mB[2], mB[0], -1);
        S5 = addWithSign(mA[0], mA[3], 1);
        S6 = addWithSign(mB[0], mB[3], 1);
        S7 = addWithSign(mA[1], mA[3], -1);
        S8 = addWithSign(mB[2], mB[3], 1);
        S9 = addWithSign(mA[0], mA[2], -1);
        S10 = addWithSign(mB[0], mB[1], 1);

        P1 = multiplyMatrixStrassen(mA[0], S1);
        P2 = multiplyMatrixStrassen(S2, mB[3]);
        P3 = multiplyMatrixStrassen(S3, mB[0]);
        P4 = multiplyMatrixStrassen(mA[3], S4);
        P5 = multiplyMatrixStrassen(S5, S6);
        P6 = multiplyMatrixStrassen(S7, S8);
        P7 = multiplyMatrixStrassen(S9, S10);

        C11 = addWithSign(P5, P4, 1);
        C11 = addWithSign(C11, P2, -1);
        C11 = addWithSign(C11, P6, 1);

        C12 = addWithSign(P1, P2, 1);
        C21 = addWithSign(P3, P4, 1);

        C22 = addWithSign(P5, P1, 1);
        C22 = addWithSign(C22, P3, -1);
        C22 = addWithSign(C22, P7, -1);

        int[][] ans = new int[A.length][B[0].length];
        collect(ans, C11, C12, C21, C22);
        return ans;

    }

    private int multiplyRows(final int[][] A, final int[][] B, int colA, int rowB) {
        int summ = 0;
        for (int i = 0; i < A[0].length; i += 1) {
            summ += A[colA][i] * B[i][rowB];
        }
        return summ;
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

    private int[][] multiplyMatrixRecursive(final int[][] A, final int[][] B) {
        if (A.length == 1 && A[0].length == 1 && B.length == 1 && B[0].length == 1) {
            int[][] ans = new int[1][1];
            ans[0][0] = A[0][0] * B[0][0];
            return ans;
        }
        int[][] X1, X2, C11, C12, C21, C22;
        int[][][] mA = splitM(A);
        int[][][] mB = splitM(B);

        X1 = multiplyMatrixRecursive(mA[0], mB[0]);
        X2 = multiplyMatrixRecursive(mA[1], mB[2]);
        C11 = addWithSign(X1, X2, 1);

        X1 = multiplyMatrixRecursive(mA[0], mB[1]);
        X2 = multiplyMatrixRecursive(mA[1], mB[3]);
        C12 = addWithSign(X1, X2, 1);

        X1 = multiplyMatrixRecursive(mA[2], mB[0]);
        X2 = multiplyMatrixRecursive(mA[3], mB[2]);
        C21 = addWithSign(X1, X2, 1);

        X1 = multiplyMatrixRecursive(mA[2], mB[1]);
        X2 = multiplyMatrixRecursive(mA[3], mB[3]);
        C22 = addWithSign(X1, X2, 1);

        int[][] ans = new int[A.length][B[0].length];
        collect(ans, C11, C12, C21, C22);
        return ans;
    }

    // split matrix M to 4 sub-matrixes: M11 = M[0], M12 = M[1], M21 = M[2], M22 =
    // M[3]
    private int[][][] splitM(final int[][] M) {
        int[][][] mM = new int[4][M.length][M[0].length];
        int midX = M[0].length / 2;
        int midY = M.length / 2;
        mM[0] = getArrWithNewBounds(M, 0, 0, midX, midY);
        mM[1] = getArrWithNewBounds(M, midX, 0, M[0].length, midY);
        mM[2] = getArrWithNewBounds(M, 0, midY, midX, M.length);
        mM[3] = getArrWithNewBounds(M, midX, midY, M[0].length, M.length);
        return mM;
    }

    private void collect(int[][] M, final int[][] C11, final int[][] C12, final int[][] C21, final int[][] C22) {
        fillAns(M, C11, 0, 0);
        if (M.length > 1 && C11.length > 0) {
            fillAns(M, C12, C11[0].length, 0);
        }
        if (M[0].length > 1) {
            fillAns(M, C21, 0, C11.length);
        }
        if (M.length > 1 && M[0].length > 1 && C11.length > 0) {
            fillAns(M, C22, C11[0].length, C11.length);
        }
    }

    private void fillAns(final int[][] C, final int[][] M, int x, int y) {
        if (M.length == 0 || M[0].length == 0) {
            return;
        }
        for (int i = 0; i < M.length; i += 1) {
            System.arraycopy(M[i], 0, C[i + y], x, M[i].length);
        }
    }

    // sign = 1 to add B to A
    // sign = -1 to subtract B from A
    private int[][] addWithSign(final int[][] A, final int[][] B, int sign) {
        if (A.length == 0) {
            return B;
        }
        if (B.length == 0) {
            return A;
        }
        int[][] C = new int[A.length][A[0].length];
        for (int i = 0; i < C.length; i += 1) {
            for (int j = 0; j < C[0].length; j += 1) {
                int a = 0;
                int b = 0;
                if (i < A.length && j < A[0].length) {
                    a = A[i][j];
                }
                if (i < B.length && j < B[0].length) {
                    b = B[i][j];
                }
                C[i][j] = a + b * sign;
            }
        }
        return C;
    }

}
