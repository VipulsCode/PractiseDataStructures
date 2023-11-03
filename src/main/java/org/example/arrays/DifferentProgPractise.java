package org.example.arrays;

import java.util.*;

public class DifferentProgPractise {
    public static void main(String[] args) {
        int[] nums1 = {2,4,5,6,0,0,0};
        int[] nums2 = {3,5,7};
        int m = 3;
        int n = 3;
        mergeSortedArray(nums1, nums2, m, n);
    }
    public static int[] mergeSortedArray(int[] nums1, int[] nums2, int m, int n) {
        int[] arr = new int[m+n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[index++] = nums1[i++];
            } else {
                arr[index++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[index++] = nums1[i++];
        }
        while (j < n) {
            arr[index++] = nums2[j++];
        }
        i = 0;
        while (i < m+n) {
            nums1[i] = arr[i++];
        }
        return nums1;
    }

}
