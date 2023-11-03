package org.example.arrays;

import java.util.Arrays;

public class FirstAndLastElementSortedArray {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] arr = {-1, -1};

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                arr[0] = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                arr[1] = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr;
    }
}