package org.example.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int[] resList = new int[nums.length]; // to store the  count of data present in an subsequence at individual index

        Arrays.fill(resList, 1); // filling the resList initially with 1, as assuming there will be at least self subsequence

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) { // here j is used to see the next index data from the current index i, and check
                // if the jth index is greater than the prev index which is i, only then  index val of i and the next index val of j,  will be considered as a
                // increasing subsequence

                if (nums[i] < nums[j]) {
                    resList[i] = Math.max(resList[i], 1 + resList[j]); // here 1 +  resList[j] is used , why 1 + --> it's coz we take every single element in the index as 1,
                    // hence i had it prefilled the resList array with 1 at starting, now 1 + means we know that the next element which is jth index val is higher than the ith
                    // index val, and that means it has another index which can be included as the subsequence in an increasing fashion from ith index val, and resList[j] is added to 1
                    // to get to know is there any data other than 1 is present in resList[j], i.e, is it memorized.
                }
            }
        }

        int maxLengthOfSubSequence = 1;

        for (int obtainedSubSequenceLength : resList) {
            maxLengthOfSubSequence = Math.max(maxLengthOfSubSequence, obtainedSubSequenceLength);
        }
        return maxLengthOfSubSequence;

    }
}
