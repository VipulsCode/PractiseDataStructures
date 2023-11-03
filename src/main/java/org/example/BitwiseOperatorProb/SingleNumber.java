package org.example.BitwiseOperatorProb;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i]; // so here i am using XOR logic, so XOR logic says if any one of the inputs is true then
            // the o/p is true, IF both are TRUE or both are FALSE then the o/p is false.

        }
        return result;
        // So the logic is, the array of nums will be given and every individual data  will be converted internally in bianary series
        // while doing the xor series , so at start it's result is 0 --> in binary 0 0 0 0 and nums[i] take it as 4 --> binary series
        // 0 1 0 0, now (0 0 0 0) ^ (xor) (0 1 0 0) --> ans is 0 1 0 0, this ans will be stored in result, and again at the next iteration the result
        // will be xored with i = 2 and this will continue till the end of array, and at last the result will be single number.
        // And also they say there are 2 duplicates and only one single element , so if you xor two same element the answer will be 0.
        // the left over will be single.
    }

    public static void main(String[] args) {

    }
}
