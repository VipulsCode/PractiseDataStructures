package org.example.arrays;

public class MinInRotatedSortedArray {
    /** approach: it should be done using binary search but the condition for incrementing left and decrementing right will not be typical like Binary Search , need to tweak
     * the binary search, 1st step : we check, is the last indexed data greater than 1st indexed data, is yes that mean's either the array is rotated to arrays's length times ,
     * it isn't totated ata all, so the min will be nums[0].
     * 2nd step: Now we need to find , if the array is rotated say by 3 times, there will be that point where the array's data will stop increasing in compare to the previous value,
     * i.e., we have to find the index let's say n is the index, where n-1 is greater than n. Now this point is said to be Inflection point. This means there is a point in the array at which you would notice a change.
     * This is the point which would help us in this question.
     * calculate mid using Binary search, Now if nums[mid] > than the starting index value of the rotated array, then the Inflection point to be found is after nums[mid] so here left will change tp
     * left = mid +1, similarly if the nums[mid] < than the starting index value of the rotated array, then the minimum is somewhere to left
     *
     */
    public static int findMin(int[] nums) {

        if (nums.length != 0) {
            if (nums[nums.length - 1] >= nums[0]) { // this says the array isn't rotated at all, and it's a default sorted array as per question so nums[o] is the min val to be returned
                return nums[0];
            }

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid + 1] < nums[mid]) {
                    return nums[mid + 1]; // so mid + 1 is the inflection val
                }
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid]; // here nums[mid] is the inflection point
                }

                // Now changing the value of left and right is as shown
                if (nums[mid] > nums[0]) { // still the inflection point isn't reached as the value till mid is still increasing, so the min val will be on the right side of the mid
                    left = mid + 1;
                } else {
                    right = mid - 1; // here i am stating if nums[mid] is less than nums[0], then the probability of finding min is towards left of mid. Do not worry what if the mid is at
                    // min value, these things are already checked with condition if (nums[mid - 1] > nums[mid]).
                }
            }
        }

        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) {
        int[] nums = new int[0];
        System.out.println("The min value is " + findMin(nums));
    }
}
