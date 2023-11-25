package org.example.arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(getTheTwoSumData(nums, target)));
    }

    // For Unsorted Array




    // This is for Sorted array
    public static int[] getTheTwoSumData(int[] nums, int target) {
        int left = 1;
        int right = nums.length;
        while (left < right) {
            int sum = nums[left - 1] + nums[right - 1];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
