package org.example.DynamicProgramming;

import java.util.Arrays;

// kanden's algorithm
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int maxiSubArray = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) { // following kadanes algorithm here, what it states , is just keep on iterating
            // and keep on adding the current indexed val to sum, now if the sum is -ve just set it back to 0, i.e., not carrying forward
            // the sum of sum and next index value is negative
            sum += nums[i];

            if (sum > maxiSubArray) {// here when ever i get the positive value and will check if sum data greater than maximum sub array
                maxiSubArray = sum;
            }

            if ( sum < 0) { // checkinhg if sum is negative
                sum = 0;
            }
        }
        if (maxiSubArray <= 0) {
            return 0;
        }

        return maxiSubArray;
    }

    //********************** DONE with the leigit question***********************************





    /**
     * FOLLOW UP QUESTION : CAN YOU PRINT ANY SUBARRAY (THERE CAN BE MULTIPLE SUBARRAYS ) WHOSE MAXIMUM VALUE YOU HAVE RETURNED USING ABOVE METHOD
     */

    public static int[] printMaxSubArray(int[] nums) {
        // Use Kanden's algorithm

        int sum = 0;
        int maxSubArray = Integer.MIN_VALUE;

        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (sum == 0) {
                startIndex = i; // this says, the index from where the  sum value starts being greater than 0, till we reach that index the sum will be 0, as it is put below if
                // sum < 0 put sum = 0; so this means once sum start's being greater than 0, the subArray will start taking place and keep on moving forward
            }

            sum = sum + nums[i];

            if (sum > maxSubArray) {
                endIndex = i;
                maxSubArray = sum;
            }

            if (sum < 0) {
                sum = 0; //as we are not considering the negative values in sum , as it bring down the maxSubarray value
            }

        }

        if (maxSubArray <= 0) {
            return new int[0];
        }

        int length = (endIndex + 1) - startIndex; // we know start index we know end index , now we need to return an array , we need to form the size of the array, so this
        int [] subArray = new int[length];

        for (int i = 0; i < length; i++) {
            subArray[i] = nums[startIndex++];
        }
        return subArray;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);

        // the below is for follow up
        System.out.println(Arrays.toString(printMaxSubArray(nums)));
    }

}

/** KANDEN's ALGORITHM working flow Explanation
 *
 * Here's how Kadane's algorithm works and what it does:
 *
 * Initialization: The algorithm starts by initializing two variables:
 *
 * maxSum (initially set to negative infinity): This variable keeps track of the maximum subarray sum found so far.
 * currentSum (initially set to zero): This variable keeps track of the sum of the current subarray being examined.
 * Iterative Process: The algorithm then iterates through the array from left to right, one element at a time. For each element:
 *
 * It adds the element to currentSum, effectively extending the current subarray.
 * If currentSum becomes negative, it means that the subarray's sum is dragging down the overall sum, so the algorithm resets currentSum to zero.
 * It updates maxSum to be the maximum of maxSum and currentSum at each step. This way, maxSum stores the maximum subarray sum found so far.
 * Result: After processing all elements of the array, the maxSum variable holds the maximum subarray sum.
 */




