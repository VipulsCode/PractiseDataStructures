package org.example.arrays;

/* Question description
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

        0 <= a, b, c, d < n
        a, b, c, and d are distinct.
        nums[a] + nums[b] + nums[c] + nums[d] == target
        You may return the answer in any order.

        Example 1:

        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]*/

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums != null || nums.length != 0) {
            // The 1st step is to sort the array
            Arrays.sort(nums);

            // The 2nd step is to create a Set so there's no duplicates
            Set<List<Integer>> set = new HashSet<>();

            // the 3rd step is to keep 1st digit of the array constant and iterate it over the time using for loop
            for (int i = 0; i < nums.length; i++) {

                // The fourth step is to keep the 2nd digit of the array constant and iterate it inside the 1st for loop
                for (int j = i + 1; j < nums.length; j++) {

                    // The 5th step is to follow two pointer approach

                    int left = j + 1;
                    int right = nums.length - 1;

                    // to check the the sum of left and right is equal to target - (nums[i] + nums[j])
                    // i.e., nums[left] + nums[right] == target - (nums[i] + nums[j]) Can u relate this to
                    // 3 Sum now;

                    long comparingData = (long) target - nums[i] - nums[j];

                    while (left < right) {
                        if (nums[left] + nums[right] > comparingData) {
                            right--;
                        } else if (nums[left] + nums[right] < comparingData) {
                            left++;
                        } else {
                            // when you find the sum equivalent to comparingData in the array then those are our quads
                            //i.e., nums[i],nums[j],nums[left], nums[right]

                            List<Integer> list1 = new ArrayList<>();
                            list1.add(nums[i]);
                            list1.add(nums[j]);
                            list1.add(nums[left]);
                            list1.add(nums[right]);
                            set.add(list1);
                            left++;
                            right--;
                        }
                    }
                }
            }
            List<List<Integer>> anslist = new ArrayList<>(set);
            return anslist;
        } else {
            return new ArrayList<>();
        }
    }
}

/*
//NOTE The below two while loop can be skipped as well
                while (j+1 < nums.length && nums[j + 1] == nums[j]) ++j;

// to skip The duplicates and restrict the J loop to again compare those duplicates
// why j+1 and  nums[j+1] because if pre increment is done then even in for loop the j++ is done
// so you will miss an element,
// and also in the 1st comparison if i use J like if (j < nums.length) then there's index out of bound

        // Similarly to skip The duplicates and restrict the i loop to again compare those duplicates
        // and the above explanation holds for i also

        while (i+1 < nums.length && nums[i + 1] == nums[i]) ++i;*/
