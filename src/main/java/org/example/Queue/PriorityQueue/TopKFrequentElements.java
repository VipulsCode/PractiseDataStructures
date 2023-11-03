package org.example.Queue.PriorityQueue;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]*/
public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // 1st step ->get the frequency of occurrence of each element using HashMap

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i : nums) {
            hmap.put(i, hmap.getOrDefault(i, 0) + 1);
            // if the i's value which is the freq count is present then +1 will be added along with the got frq count val,  else if
            // the key is 1st time occurence then by default val is 0 + 1
        }

        // 2nd step --> form a Min heap priority Queue with the comparator condition of its sorting in its parameter and the
        // condition is based on frequency

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hmap.get(a) - hmap.get(b));

        //3rd step --> add the key in priority queue , once the size of Priority Queue is more than k,
        // remove the element which is minimum, which is taken care by poll() method.

        for (int i : hmap.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4th step for an array of size k and get the data of priority Q on it, and Priority Q will be of size k

        int[] arr = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll();
        }
        return arr;
    }

}
