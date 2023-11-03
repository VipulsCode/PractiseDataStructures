package org.example.Queue.PriorityQueue;

import java.util.PriorityQueue;

/**Given an integer array nums and an integer k, return the kth largest element in the array.
        Note that it is the kth largest element in the sorted order, not the kth distinct element.
        Can you solve it without sorting?

        Example 1:

        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5 */

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        findKthLargest(nums, k);
    }
    public static int findKthLargest(int[] nums, int k) {

        // first create a PriorityQueue which implements min heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // now iterate till k - 1
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // Now iterate from k to last --> the idea is to create a min heap representational tree of size of k
        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();// this gives the peek of the parent
    }
}

// The intuition is As we know that if we sort the array, the last 2nd index in largest element as per the above question
// But here we will use Priority Queue which take min heap as default impl, here min HEAP is most important word-->
// MIN HEAP is the balanced tree in which the parent value should be lesser than child.
// So to solve the problem we should form MIN heap tree structure of value k once you form this the
//  kth largest element will form as a parent data, as per min heap concept.
// This video will explain it to you --> https://www.youtube.com/watch?v=yAs3tONaf3s
