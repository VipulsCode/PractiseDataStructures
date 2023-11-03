package org.example.arrays;

public class ElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {6,4,5};
        int target = 6;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 1st apply binary search on whole array
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // Now Check whether the left of the array is sorted from mid
            if (nums[left] <= nums[mid]) {
                // This is to check whether the target element is present with in the left of the array
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= right) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
