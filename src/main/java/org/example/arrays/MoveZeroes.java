package org.example.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {

/*
        for (int i = 1; i < nums.length; i++) {
            if (i > 0 && nums[i] != 0 && nums[i-1] == 0) {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                i = i-2;
            }
        }*/
        int l = 0;
        int r = 0;

        while (l <= r && r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            } else if (nums[r] == 0) {
                r++;
            }
        }

        System.out.println(Arrays.toString(nums));

        /*
        int count = 0;
        int k = 0;
*/

/*


        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                hmap.put(k++, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - count) {
                nums[i] = hmap.get(i);
            } else {
                nums[i] = 0;
            }
        }*/
    }
     //System.out.println(Arrays.toString(nums));
}

