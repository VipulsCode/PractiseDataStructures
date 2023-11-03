package org.example.arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(findThePivotIndex(arr));
    }
    public static int findThePivotIndex(int[] arr) {
        int wholeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            wholeSum += arr[i];
        }
        int itrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (wholeSum - (itrSum + arr[i]) == itrSum) {
                return i;
            }
            itrSum = itrSum + arr[i];
        }
        return -1;
    }
}
