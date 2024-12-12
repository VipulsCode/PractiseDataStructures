package org.example.InterviewCodes.EpamInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaxSumSub {
    public static void main(String[] args) {
/*        list of integers - 1,2,3,4,100,200

        use java8 streams - print the min and max*/
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(100);
        ls.add(200);

        Optional<Integer> min = ls.stream().min(Integer::compareTo);

        Optional<Integer> max = ls.stream().max(Integer::compareTo);

        System.out.println("The min value " + min);
        System.out.println("the max value " + max);


    }

}
