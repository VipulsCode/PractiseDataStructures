package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        List<Integer> currValList = new ArrayList<>(); // This will hold the current data , i.e., ith val of for loop, to do so i
        // have taken data structure as array
        boolean[] isAlreadyMarked = new boolean[nums.length];// to mark while running in loop to say that i have already considered this
        // current data

        gerThePermutation(currValList, isAlreadyMarked, nums, resList);
        return resList;

    }

    public void gerThePermutation( List<Integer> currValList, boolean[] isAlreadyMarked, int[] nums,
                                   List<List<Integer>> resList) {
        // base condition

        if (currValList.size() == nums.length) {
            resList.add(new ArrayList<>(currValList)); // why am i doing a deep copy as i am altering currValList at every recursion by removing the last data,
            // so the currValList keeps on changing
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isAlreadyMarked[i]) {// if false, that means i haven't considered this ith val yet
                isAlreadyMarked[i] = true;

                currValList.add(nums[i]);
                gerThePermutation(currValList, isAlreadyMarked, nums, resList);

                currValList.remove(currValList.size() - 1); // here i am removing the last data from the list once the base condition is reached, which is done once the
                // data structure size is equal to length of nums, reason behind to this is if i have considered one kind of permutation which is (1,2,3) then i also need
                // to consider in the same currValList other type of permutation which is (1,3,2) and next (2,1,3) (2,3,1) and so on, this can only be done the dataStructure which
                // yo chose(currValList) has the same to occupy that ith place

                isAlreadyMarked[i] = false;// and also we need to revert the true to false so a new val can be occupied in DS as they are dependent because of condn, if(!isAlreadyMarked[i])
            }
        }
    }
}
