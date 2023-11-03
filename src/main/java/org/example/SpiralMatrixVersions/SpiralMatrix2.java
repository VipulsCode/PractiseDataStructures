package org.example.SpiralMatrixVersions;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 1;
        int[][] matrix = new int[n][n];
        // Spiral need to be framed and add the data matrix : the data will be n*n
        // for eg if n= 3 :- then data need's to be input in n*n matrix is 3 * 3 = 9 i.e., (1,2,3,4....9) in spiral form
        int[][] matrixRes = getTheSpiralFramed(matrix, n);

        System.out.println(Arrays.deepToString(matrixRes));
    }
    public static int[][] getTheSpiralFramed(int[][] matrix, int n) {
        int top = 0;
        int left = 0;
        int m = n;
        int right = n - 1; // column's length
        int bottom = m - 1; // row's length
        int count = 0;

        while (left <= right && top <= bottom) {
            // iterating left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++count;
            }
            top++;

            // iterating from rightTop to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++count;
            }
            right--;

            // iterating from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = ++count;
                }
                bottom--;
            }
            // iterating from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = ++count;
                }
                left++;
            }
        }
        return matrix;
    }
}
