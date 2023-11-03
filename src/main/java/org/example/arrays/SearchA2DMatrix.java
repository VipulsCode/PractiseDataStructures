package org.example.arrays;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 34;
        System.out.println(searchMatrix(arr, target));
        searchTargetIn2dMatrix(arr, target);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[i].length;
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                int l = 0;
                int r = j;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (target > matrix[i][mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

            }
        }
        return false;
    }


    // NEED TO DO IN O(log(n*m)) complexity
    public static boolean searchTargetIn2dMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = matrix.length; // represent row size
        int m = matrix[0].length; // represents column size

       //you have to get the first index of the matrix and last index of the matrix, by assuming all the data are in linear
        int l = 0; // 0th index
        int r = (n * m) - 1; // this gives you the last index of the matrix for eg n= 3 and m = 4 so last index will be 11th index

        while (l <= r) {

            int mid = l + (r-l)/2; // i got imaginary mid index

            // you get the imaginary mid index value by imagining a matrix in one linear form, now you have to get the indexes in matrix form of this imaginary mid index
            // aur is mid index ka jo value tha uska matrix form me index kya hai

            if (matrix[mid/m][mid%m] == target) { // here you are getting real index in 2d form of imaginary indexed mid value
                return true;
                //   mid/m -> gives you row pointing index (where m is length of column)
                //   mid%m -> gives you Column pointing index
            } else if (target > matrix[m/mid][m%mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
