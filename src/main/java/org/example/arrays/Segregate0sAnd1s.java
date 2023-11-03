package org.example.arrays;


import java.util.Arrays;

/** You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the
 * array [Basically you have to sort the array]. Traverse array only once.

 Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] */

public class Segregate0sAnd1s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};

        System.out.println(Arrays.toString(segregateFunction(arr)));
    }

    public static int[] segregateFunction(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            if (arr[left] != 0) {
                if (arr[right] != 1) {
                    swap(arr, left, right);
                }
                right--; // so it's like keep left on hold here and decrement right, as now left would be 0 and right 1, and from the above
                // condition th if wont be executed for left = 0, and loop will carry on
            } else {
                left++; // now here if left = 0 =, then just increment left side, no need to do anything on right, as the next iteration will be finding again for
                // left and right data
            }
        }
        return arr;
    }

    public static void swap (int[] arr, int left, int right) {
        arr[left] = arr[left] + arr[right];
        arr[right] = arr[left] - arr[right];
        arr[left] = arr[left] - arr[right];
    }

}
