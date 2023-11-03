package org.example.arrays;

public class BinarySearchIntro {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 10;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
