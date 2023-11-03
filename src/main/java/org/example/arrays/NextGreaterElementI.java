package org.example.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0 ; i < nums2.length; i++) {
            hmap.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (hmap.get(nums1[i]) == nums2.length - 1) {
                nums1[i] = -1;
            } else if (nums1[i] < nums2[hmap.get(nums1[i]) + 1]) {
                nums1[i] = nums2[hmap.get(nums1[i]) + 1];
            }

            else  {
                int temp = nums1[i];
                nums1[i] = -1;
                for (int j = hmap.get(temp) + 2; j < nums2.length; j++) { // as we have checked already for hmap.get(nums1[i]) + 1, in the above step
                    if (temp < nums2[j]) {
                        nums1[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1};
        int[] nums2 = {3,2,1};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
