package org.example.InterviewCodes.Wallmart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;

public class InterViewSolving {

    public static int myReduce(Integer initialValue, BinaryOperator<Integer> accumulator, int[] array) {
        return myReduce (initialValue, accumulator, array, 0);
    }
    public static  int myReduce(Integer initialValue, BinaryOperator<Integer> accumulator, int[] array, int index) {
        if (index == array.length) {
            return initialValue;
        } else {
            return myReduce(accumulator.apply(initialValue, array[index]), accumulator, array, index +1);
        }
    }

        public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};
        int sum = myReduce(5, (x,y) -> x + y, numbers);
            System.out.println("Sum :" +  sum);

    }

}
