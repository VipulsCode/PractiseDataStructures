package org.example.arrays;

// Question:
/*A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

        For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
        The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally,
        if all the permutations of the array are sorted in one container according to their lexicographical order,
        then the next permutation of that array is the permutation that follows it in the sorted container.
        If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

        For example, the next permutation of arr = [1,2,3] is [1,3,2].
        Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
        While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
        Given an array of integers nums, find the next permutation of nums.

        The replacement must be in place and use only constant extra memory.

        Example 1:

        Input: nums = [1,2,3]
        Output: [1,3,2]*/



import java.util.Arrays;
public class NextPermutation {
    public static void main(String[] args) {
        int[] n = {2,1,5,4,3,0,0};
       findTheNextPermutation(n);
    }

    private static void findTheNextPermutation(int[] arr) {
//1st step i'll take a variable called index
        int index = -1;
// 2nd step find the break point by iterating from the end and check where there's a dip in an array
        // i.e, find the first index in an array  which is lesser than i+1;

        for (int i = arr.length - 2; i >= 0; i--) {
            // why n-2 because we use i+1 if i consider arr.length-1 array index of bound occurs

            if (arr[i] < arr[i+1]) {
                index = i;
                // Now i got the breaking point
                break;
            }
        }
        // Now just check if there was a dip or if any index i was lesser than i+1 or not , if yes then there
        //was a dip, if no just reverse the array and return it.

        if (index == -1) {
            reverse(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }

        // 3rd step Again iterate from right side and find the 1st number which is larger than the indexed value of the array
        // Once found swap the found 1st number with the indexed valued number
        for (int i = arr.length -1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(arr, i, index);
                break;
            }
        }
        // 4th Step is to reverse the leftover data in an array i.e., after index
        reverse(arr, index +1, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }
    public static void swap (int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
