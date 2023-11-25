package org.example.arrays;
import java.util.*;

/* Question description:

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.*/

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> listData = getThe3SumData(nums);
        for (List<Integer> sublist : listData) {
            for (Integer value : sublist) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getThe3SumData(int[] nums) {

        Set<List<Integer>> set = new HashSet<>(); // Set is used so that you do not considered Duplicate list
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            int target = -first;
            // so why target = (-)ve coz as per quest it's
            //nums[i] + nums[j] + nums[k] = 0, if you reform in two sum it becomes
            //nums[j] + nums[k] = (-) nums[i] --> hence -ve

            while (left < right) {
                // while loop coz  we need all the triplets of held target,
                // and for loop coz after holding 1 target value, we came to know that we have
                //found all the possible triplets , but we need to keep on searching for other
                //possible triplets, so hold next ith indexed value as target. we iterated all the elements of array.
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    left++;
                    right--;
                    set.add(list);
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>(set);
        return resList;
    }
}
