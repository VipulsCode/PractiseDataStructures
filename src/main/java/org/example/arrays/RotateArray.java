package org.example.arrays;


import java.sql.SQLOutput;
import java.util.Arrays;

//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
/*eg :
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4] */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 5;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        System.out.print("reversing first >>>>> ");
        System.out.println(Arrays.toString(reverse(nums, 0, nums.length-1))); // reversing from start to end for the 1st time

        if (k > nums.length) {
            k = k % nums.length;
        }
        System.out.print("reversing SECOND >>>>> ");
        System.out.println(Arrays.toString(reverse(nums, 0, k-1))); // reversing only till k from 0 to k -1 index;

        System.out.print("reversing THIRD >>>>> ");
        System.out.println(Arrays.toString(reverse(nums, k, nums.length-1))); // reversing from kth index till last;


    }

    public static int[] reverse(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

}
