package org.example.DynamicProgramming;

public class TrappingRainWater {

    // USING DP -->2nd approach in editorial : using two arrays to store the maximum height of bar (elevation). Foe left we use left_max array to store the height of the
    // bar at every index, so what i mean by left is --> starting from 0 to height.length, we try to find the max height pf the bar between two indes, i.e., the current
    // index and prev index.

    // for right side --> to find the right sided nbar height we start from the last index of the right to first index  of the height array, and compare between the
    // 2 index , to populate right_max array.

    // why we are doing this , is to get away from brute force , where we use to find maximum height of the bar from the index towards left and populating it as
    // left_max (which was integer not an array in brute force), and also we use to find in similar way the maximum of height of the bar towards right from the pointed
    // index i, and this was donw is nested looo\p, check the 1st approcah in editorial

    /**
     *THE BELOW IS USING DP : TIME COMPLEXITY IS O(N) , SPACE COMPLEXITY --> O(N)
     */

    public int trapUsingDP(int[] height) {
        int ans = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        int size = height.length;

        left_max[0] = height[0]; // initially height[0] is added to left_max[0] index, so it can be used to compare between the heights of the bar

        // finding the height of bar and storing the maximum height by comparing between two index on the go, like current index and prev index, if any of the index has
        // superior height of the bar the same will be maintained in all the left_max indexes

        for (int i = 1; i < size; i++) {// why i =1 as i have already assigned height[0] on top to leftMax[0], so start from height[1] and fill left_max[1] and so on

            left_max[i] = Math.max(height[i], left_max[i - 1]); // as i said left_max[i - 1] the 0th index is used to compare , which indexed bar hasd better height.
            // and that bar height val will be placed in left_max[i].

        }

        right_max[size - 1] = height[size - 1];

        for (int i = size - 2; i >= 0; i--) { // why i = size - 2 , as height[size - 1] is already used above which will be used to compare the height of bar from right
            // side of array

            right_max[i] = Math.max(height[i], right_max[i + 1]); // at first time right_max[size - 1] will be used
        }

        // Now populating the ans by adding the water stored at all the index from 1 to size - 2, why 0 and size - 1 is not considered , it's coz it's already used to
        // calcualte left_max and right_max (size - 1) is used, and if 0th bar height is heigher than the 1st or 2nd or any upcomind index, the same would have been
        // updated in respective index of left_max. The same for size -1 for right_max

        for (int i = 1; i < size - 1; i++) {
            ans = ans + Math.min(left_max[i], right_max[i]) - height[i];

            // Now here Math.min(left_max[i], right_max[i]) , is nothing at every ith index i know what will be the max height of the bar towards from the index i, and
            // what will be the max height of the bar at right from the index i. Once we get the max height from the both the end of index i (i mean i ko beech me
            // rakhkey uskey left side dekho for max height if bar , and uskey right side for max height of the bar , and that's stored in left_max and right_max array
            // in the same index i.), take the minimum of two height , and separate that height with current index height, you'll get to know how much of water the
            // current index can store, if -ve no water is stored by that index.
        }

        return ans;

    }




    /**
     * The below solution is BRUTE FORCE solution--> O(n^2) - time complexity and O(1) as Space complexity --> which is just for understanding
     */

    public int trap(int[] height) {
        int ansMax = 0;

        for (int i = 1; i < height.length - 1; i++) { // why i = 1 and i < height.length - 1 coz 0 is a left most extremist we do not have anything beyond 0, so 0 will
            // be point to say ok what's the elevation till 0, now index 0 cannot store anywater coz, there's nothing left to it to support the 0th elevation,
            // same thing goes the right last extremist.

            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >= 0; j--) {// here we are searching till 0th index is there any elevation which is of larger height than the current index elevation
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {// here we are searching rill the last of index of array of there's any elevation of a greater height than the current
                // index elevation, if no then we do the max of rightmax and current height.
                rightMax = Math.max(rightMax, height[j]);
            }

            // once we found leftmax and right max from the current index , like is there any elevation on left side which is of greater height than the current index
            // elevation and is there any elevation on right side of current index which is of greater height than the current index, Now we find the water storage between
            // these two heights and removing the current index--> this will give the amount od water stored by current index

            ansMax = ansMax + Math.min(leftMax, rightMax) - height[i];
        }

        return ansMax;

    }
}
