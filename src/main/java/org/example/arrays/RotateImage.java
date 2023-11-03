package org.example.arrays;


import java.util.Arrays;

/*Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]*/

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        //rotate(arr);// brute force
        rotateArray(arr);
    }

    public static void rotateArray(int[][] arr) {
        // 1st step get the transpose of the matrix, reason is, it can be seen in the problem the 1st column
        // of question is similar to that of 1st row of the answer but in reversed order,
        // so the 1st step is to make a transpose of the question matrix

        for (int i = 0 ; i < arr.length - 1; i++) {
            // why arr.length - 2 is coz if we see the diagonal of the transpose which you will frame in paper
            // u need not to do anything to them, but the opposite data on either side needs to be swapped,
            // so if u take upper part, not the last part of the diagonal, we need to iterate till arr.length - 2, which is like the last row - 1
            for (int j = i+1; j < arr.length; j++) {
                swap(arr, i, j); // so here the transpose of the matrix is done.
            }
        }

        for (int i = 0; i <= arr.length-1; i++) {
            // to get the rotation done
            reverse(arr[i]);//It's a 2D matrix , so when you say arr[i] just think arr = [[1,2,3],[4,5,6],[7,8,9]] , so arr[0] = {1,2,3}, so similarly arr[1] = {4,5,6} and so on.
        }
        System.out.println("In 0(1) space data");
        System.out.println(Arrays.deepToString(arr));
    }

    public static void reverse(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l <= r) {
          int temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          l++;
          r--;
        }

    }

    public static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }


    public static void rotate(int[][] matrix) {
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copyMatrix[j][n-i-1] = matrix[i][j];
            }
        }
        System.out.println( "The data is " + Arrays.deepToString(copyMatrix));
    }
}
