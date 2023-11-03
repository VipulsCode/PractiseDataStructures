package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

        List<List<Integer>> ls = new ArrayList<>();



        /** 1st step : sort the 2d array using comparator
         * The idea behind sorting is yiu come to know that the meging intevals are adjacent to each other, and once if both the
         * interval at any stage do not qualify to merge, no need to look further for next data which can qualify to merge with in
         * the previous interval.
         */

        Arrays.sort(intervals, new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) { // using compare method to sort , so this basically takes 1st element of 1st and
                // 1st element of 2nd row, if a[0] - b[0] is -1 then a should be placed before b, if a[0] - b[0] is + 1 then a
                // should be placed after B, if 0 then they are equal
                return a[0] - b[0];
            }
        });

        /** 2 STEP: Use just a single for loop to iterate over the 2d array, and with in the for loop 2 condition comes in a picture
         * condn 1: Check if the list is empty and also consider if the 0th parameter of the current interval is larger than the 1st
         * index of prev interval, if so then these intervals are not suppose to overlap, so just add this interval directly in the list.
         *
         * condn 2: if the above condn does not pass that means , the data will overlap, if the data overlap , we need to replace the
         * 1st index in the prev interval with the value of 1st index of current interval.
         * Now whats the idea behind over lap is if the 0th index of current inteval is lesser to the 1st index of prev innterval array
         *
         * NOW here i am talking about 0th index and 1st index , so 0th index is nothing but 0th column and dynamic incremental row
         * eg : 0,0, 1,0, 2,0, 3,0, and when i say 1st index its nothing 1st column associated with incremental rows, for eg: 0,1, 1,1,
         * 2,1, 3,1 etc .. so if you see here the m *n matrix where n will be always in size 2, that's the reason interval, from 1 place to othe place
         */

        for(int i = 0; i < intervals.length; i++) {
            // if the current interval does not
            // lie in the last interval:

            if (ls.isEmpty() || intervals[i][0] > ls.get(ls.size() -1).get(1)) {

                ls.add(Arrays.asList(intervals[i][0], intervals[i][1]));

            } else {
                ls.get(ls.size()-1).set(1, Math.max(ls.get(ls.size()-1).get(1), intervals[i][1]));

                // i can just checked if last(1st) index of current interval is it greater than last index of prev interval,
                // but no need to add this condn, as above condn has already justified this else statement is coz, the data will
                // be over lapped. NOW Math.max(ls.get(ls.size()-1).get(1), intervals[i][1]) why a i doing this, it's coz if i just blindly
                // write the last index will replace the last index of prev interval, then what if the case comes as for intevals (3,9) and the next
                // interval is (4,8), so it is over lapping, but if i had replaced 9 by 8 , then the answer would have gone wrong.
            }
        }


        // Converting list to int[][] arr
        int[][] ansArr = new int[ls.size()][2];


        for (int i = 0; i < ls.size(); i++) {
           for(int j = 0; j < 2; j++) {
               ansArr[i][j] = ls.get(i).get(j);
           }
        }
        System.out.println("THe list data below is >>>>>>>");
        System.out.println(ls);


        System.out.println("THe int[][] data below is >>>>>>>");
        System.out.println(Arrays.deepToString(ansArr));

        return ansArr;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}
