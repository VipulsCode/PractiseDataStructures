package org.example.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class longestConsecutiveSequenceArray {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutiveBestApproach(nums)); // O(n) complexity

        System.out.println(longestConsecutive(nums));//O(nlogn) * N --> complexity
    }

    public static int longestConsecutiveBestApproach(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1; // if above length is not 0, then will be min of 1 longest, hence at first it longest = 1

        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]); // this is to get rid of duplicates so stack allows no duplicates
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st.contains(nums[i] - 1)) {
                // if stack isn't containing the nums[i]-1 data that means thats the first number in
                // that particular sequence, for 103,101,102, if 101 - 1 = 100 and stack does not contain 100, then probably 101 is staring number in this sequence.

                int count = 1;
                int startingNumber = nums[i]; // now i have got 1st starting number, now like a brute force linearly will check the presence of startingNumber + 1 data,
                                                // present in set, till it's present in stack, the below while loop will run, and count will be incremented
                while (st.contains(startingNumber + 1)) {
                    count = count + 1;
                    startingNumber = startingNumber + 1; // this is coz, to check how many numbers are present continuously in stack
                }
                longest = Math.max(count, longest); // lastly maintaining the longest.
            }
        }
        return longest;
    }


    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int longest = 0; // THIS GIVES LONGEST RESULT
        int count = 0; // THIS KEEPS THE COUNT OF CONSECUTIVITY
        int lastSmall = Integer.MIN_VALUE; // THIS IS TO ENSURE WE ARE MAINTAINING CONSECUTIVE FORM,
                                            // THIS DATA WILL be reinitialised in LATER PART OF THE PROGARM.

        Arrays.sort(nums);
        // why sorting as we know the consecutive will be one after the other in contionous fashion, like 1,2,3,4
        // can be considered but not 1,2,3,5, so if we sort thr array it will be easy for us, as consecutive means need a count
        //of continuous numbers, and continuous number mean 123456...


        for (int i = 0; i < nums.length; i++) {

            /**  THE BELOW IF STATEMENT expln: as wkt the current indexed data - 1 , if it says it's equal to the previous data,
             * that means we are in consecutive form, for eg., 1,2,3 --> now if index is 1st if 2-1 == 1,
             * and for index 2 , 3-1 == 2, it previous number , that means we are in continous form
             reintialize lastSmall to the current before moving to next */

            if (nums[i] - 1 == lastSmall) {
                count++;
                lastSmall = nums[i];
            }

            /** THE ELSE IF STMT expl : In here why we haven't considered nums[i] - 1 is coz if we get duplicates do not do anything,
             * if no duplicate and there is a 1 leap or more in continous number we reintialize count to 1 and
             * lastsmall becomes that particular index*/

            else if (nums[i] != lastSmall) {
                count = 1;
                lastSmall = nums[i];
            }
            longest = Math.max(longest, count);  // at last we keep track of longest at every iteration.

        }
        return longest;

    }
}
