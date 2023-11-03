package org.example.SpiralMatrixVersions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,11}, {4,5,6,12}, {7,8,9,13}};
/*          1   2   3   11
            4   5   6   12
            7   8   9   13  */
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; // row size
        int n = matrix[0].length; // column size
        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int left = 0;
        List<Integer> ls = new ArrayList<>();

        while (top <= bottom && left <= right) { // to get the spiral done this will be the condition

            // let's iterate from left to right
            for (int i = left; i <= right; i++) {
                ls.add(matrix[top][i]);
                // top being constant
            }
            top++;
            //let's iterate from top to bottom
            for (int i = top; i <= bottom; i++) {
                ls.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                //let's iterate from right to left
                for (int i = right; i >= left; i--) {
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                //let's iterate from bottom to top
                for (int i = bottom; i >= top; i--) {
                    ls.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ls;
    }
}
