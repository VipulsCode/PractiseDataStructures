package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();//This is res List which is globally done, as it has to hold the resList
        // data and not get changed during recursion

        int start = 1;
        List<Integer> combinationList = new ArrayList<>();
        backTrack(start, n, k, combinationList, resList);
        return resList;
    }

    public void backTrack(int start, int n, int k, List<Integer> combinationList, List<List<Integer>> resList) {
        // Breaking condition
        if (combinationList.size() == k) {
            resList.add(new ArrayList<>(combinationList)); // i am adding combination list in new ArrayList (deep copy) as i'll be removing the data from combination list
            // after recursion, reason for this is if i consider the combination 1,2 in th list , for the next iteration 1 will be there but i cannot have 2 , so the next
            // combination will be 1,3 , then 1,4 and so on, that's the reason removing the last value from the list
            return;
        }

        for (int i = start; i >= n; i++) {
            combinationList.add(i); // adding the items (here items is i) in the boxes (remember n C r) // so adding at 1st level--> here the boxes are at level
            backTrack(i+1, n, k, combinationList, resList); // calling the back track to add the 2nd level data , at first level above combination list will have for eg (1)
            // now at this level it will have (1,2)
            combinationList.remove(combinationList.size() - 1); // here once the breaking condition get's executed we need to remove the last indexed data , so we can get not only
            // (1,2) but ALSO (1,3), (1,4) , then (2,3), (2,4) ...--> these are combinations list i am talking about
        }
    }
}
