package org.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    // Solving using sliding window.
    // using Set to store the data , at a time we are storing k indexed value in SET, if  any element of the array found to be present in the set, since we are storing the
    // data only till the range of k at a short in set, then it can be said that there was the duplicate with in the asked range.
    // Now to proceed further with the element , once the i value i iteration exceeds the k range, we remove the oth indexed value from set, then 1st then 2nd , as the
    // value of i increases, this is to make sure at every there are only k indexed range of values are there in SET, this can be done using set.remove(i-k).
    // and then add the new ith array value in set

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            if (hashSet.contains(nums[i])) {
                return true; // stating there's a duplicate with in the k index range of set
            }
            // now add , so to maintain k indexed range of values in set, as the data from the set will be removed below, after adding
            hashSet.add(nums[i]);

            // if we remove the data from hash set before adding it will not pass for the i/p array {1,2,1}, and k = 0, as the real O/p should be false,
            // but the O/p according the code will be true.

            if (i >= k) {
                hashSet.remove(nums[i - k]); //suppose k = 4 and i = 4 , so i-k gives 0 , so remove 0th indexed store value in set, if i = 5 and k = 4, then i - k = 1,
                // then remove 1st indexed val
            }
        }
        return false;
    }
}

// COMPLEXITY - TIME --> O(N) , SPACE COMPLEXITY --> O(R)  WHERE R --> RANGE
