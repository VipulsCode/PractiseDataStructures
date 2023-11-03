package org.example.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesSortedArray {
    public static int[] removeDuplicates(int[] nums) {
        //HashSet<Integer> dupEle = new HashSet<>();
        HashSet<Integer> uniEle = new HashSet<>();
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
                if (uniEle.add(nums[i])) {
                    uniEle.add(nums[i]);
                    nums[j++] = nums[i];
                }
            }
        System.out.println("The value of j is " + j);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,3,2,2,3};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
