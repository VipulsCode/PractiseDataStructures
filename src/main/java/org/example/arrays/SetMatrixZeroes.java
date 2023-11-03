package org.example.arrays;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};

       /* System.out.println(Arrays.deepToString(setZeroes(arr)));
        System.out.println(Arrays.deepToString(getTheResultantMatrix(arr)));*/

        markArrayWithOne(arr);

    }

    public static void markArrayWithOne(int[][] matrix) {
        int[] col = new int[matrix[0].length];
        int[] row = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col[j] = 1;
                    row[i] = 1;
                }
            }
        }
        System.out.println("The col val = " + Arrays.toString(col));

        System.out.println("The row val = " + Arrays.toString(row));

        System.out.println("The final answer " + Arrays.deepToString(replaceWithZeroes(matrix, col, row)));
    }

    public static int[][] replaceWithZeroes(int[][] matrix, int[] col, int[] row) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (col[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }


    public static int[][] setZeroes(int[][] matrix) {
        //brute fore method
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    replaceRow(i, matrix.length, matrix);
                    replaceCol(j, matrix[0].length, matrix);
                }
            }
        }
        return matrix;
    }
    public static void replaceRow(int index, int length, int[][] matrix) {
        for (int j = 0; j < length; j++) {
            if (matrix[index][j] != 0) {
                matrix[index][j] = -1;
            }
        }
    }

    public static void replaceCol(int index, int length, int[][] matrix) {
        for (int j = 0; j < length; j++) {
            if (matrix[j][index] != 0) {
                matrix[j][index] = -1;
            }
        }
    }

    public static int[][] getTheResultantMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

}
