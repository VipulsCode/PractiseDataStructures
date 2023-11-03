package org.example.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0, i = 0, j = 0;
        int[] arr = new int[m+n];

        while (i < m && j < n) {
            // && was to make sure there's no array of outbound one value reaches it's
            //max we need to stop the loop, so if theres "||" so there's out of bound'

            if (nums1[i] < nums2[j]) {
                // to sort here ot self and avoid using Arrays.sort()
                arr[index++] = nums1[i++];
            } else {
                arr[index++] = nums2[j++];
            }
        }

        // This is to check left overs of nums1, once the main while loop is false
        while (i < m) {
            arr[index++] = nums1[i++];
        }

        // This is to check left overs of nums2, once the main while loop is false
        while (j < n) {
            arr[index++] = nums2[j++];
        }

        // The below execution is to transfer the data from additional used array arr to nums1
        i = 0;
        while (i < m+n) {
            nums1[i] = arr[i++];
        }
    }
}
