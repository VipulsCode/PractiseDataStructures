package org.example.arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        System.out.println(maxSubArray(arr)); // complexity is O(n^3)
        System.out.println("better solution " + maxSubArrayBetterSolution(arr)); // complexity is O(n^2)
        System.out.println("optimal solution " + maxSubArrayOptimalSolution(arr)); // complexity is O(n)

       printMaxSubArray(arr); // It's an additional do, but it's good to know how to print the sub array which participated in max sub array
    }

    // Brute Force : 0(n^3)
    public static int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) { // why j is i, as we know we want sub array being contiguous, so 0th index is a sub array,
                // the next sub array is 0,1, then next sub arry 0,1,2, and so on, once i becomes1, then 1st sub arry is 1, the next sub array is
                // 1,2 and then next sub array 1,2,3 and so on
                int sum = 0;
                for (int k = i; k <= j; k++) { // why k is i to j, coz we know that the sub array ranges from i to j,
// so if i = 0, and j keeps moving, we need to check 0 to j, and when i = 1 , j keeps moving, we need to check 1 to j, hence k is i to j
                    sum += arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // for an optimal solution, as we see that inside the k for loop above in brute force, at every increment of j, we
    // need to sum again from ith index, though we would have calculated that already for the previous j, so what if we store the
    // sum already in a variable and reuse it so we wont be needing k loop at all

    public static int maxSubArrayBetterSolution(int[] arr) { // 0(n^2) and space is O(1)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j]; // sum is already calculated for the previous j, so we can reuse it
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Optimal solution
    public static int maxSubArrayOptimalSolution(int[] arr) {
        // Use Kaden's Algo
        // so we follow kaden's alorithm, the algorithm tells not to consider the index while iterating as part of sub array
        // till we get the sum of the indexes lesser than 0. so consider only from those indexes where u start getting positive values
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIndexOfSubArray = -1;
        int endIndexOfSubArray = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                startIndexOfSubArray = i;
            }
            sum += arr[i];

            if (sum > max) {
                max = sum; // this we do before hand for inputs like [-1] so if we do this part after checking is sum <= 0
                // and assign sum as 0 then result we get for input [-1] will be 0, but we need output as -1.
// AND also we do this to get to know the last index, if they also wants to know which is the subarray which participate to give max sub array
                endIndexOfSubArray = i;
            }
            if (sum <= 0) {
                sum = 0; // This is where Kadens algo tells to not consider the index till we get there sum as lessr than 0
                // while iterating as part of sub array
            }
        }
        System.out.println("Start index of subarray " + startIndexOfSubArray + " end index of subarray " + endIndexOfSubArray);
        return max;

    }

    //TODO NOTES: Now we found already the maximum sub array summed number using kadens algorithm,
    // now if it asked to print the sub array which participated in max sub array use the below one

    public static void printMaxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIndexOfSubArray = -1;
        int endIndexOfSubArray = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                startIndexOfSubArray = i; // this is for start point of Max sub array
            }
            sum += arr[i];

            if (sum > max) {
                max = sum;
                endIndexOfSubArray = i; // this is for end point of Max sub array, so till the sum is rising and
                // positive we know that till that the index qualifies to be part of max sub array. and we change the sum,
                // so typically its like till when the max gets updated of the entire iteration those will be the indexes
                // as a part of end Index ax sub array
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        // Just iterate from start index of sub array to end index of sub array
        System.out.println("Now Printing the sub array which participated in max sub array");
        for (int i = startIndexOfSubArray; i <= endIndexOfSubArray; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
