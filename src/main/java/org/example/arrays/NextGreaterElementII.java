package org.example.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this number.
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] nextGenArray = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = (2 * n) - 1; i >= 0; i--) { // why 2 * n , kyunki hume circular array me data check karna padega, just imagine last index ka next greater element
            // circularly dhoodna hoga, aur hum 2 for loops nahi lena chahtey, so we say let's take the length 2 * length of given array, and circle back the array again,
            // by creating an imaginary array like if input array is {1,2,1} --> we see array as {1,2,1, 1,2,1}, lekin hum ye array bannayegey nahi,
            // if u see we are repeating again the same array, so we will traverse back to 0 again once we reach the end by using (i % n) so length is 3 for {1,2,1},
            // now if i = 3 --> i % length --> 3 % 3 = 0, so again start from 0, by this we get imaginary array
            while (!st.isEmpty() && st.peek() <= nums[i % n]) { // This is important
                    st.pop();

    //we are checking  in while loop, if in stack is there any value which is lesser than current index val,
    // if yes then remove it, as they will not be in use, as this current index is greater than those values, so any value left to the current index will only refer,
    // current index as there next index, they won't look at removed value, and more over those values are already processed for ef 3 2 8 1 2 3, this 1 2 3 is already
    // processed, at 3 is -1 , and it will again be replaced once u circle back, 2's next greater elem is 3, and 1's next great element is 2, but if u delete 1 2 3 ,
    // now if u see before 8, there's 2 it's greater element can only be 8
            }
            if (!st.isEmpty()) {
                nextGenArray[i % n] = st.peek(); // This says this will be my next greater element for the current index
            } else {
                nextGenArray[i % n] = -1; // this is 1st element if u do a back ward traversal, then 1st element from back ward, if front traversal then front for front traversal
            }
            st.push(nums[i % n]); // and after all that we need to push the current index data in stack
        }
        return nextGenArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
