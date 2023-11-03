package org.example.DynamicProgramming;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
 * ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;

        while (left < right) {
            int constructedArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(constructedArea, maxArea);

            if (height[left] < height[right]) {
                left++; // if you do right-- the area will further decrease no matter if the container is of bigger height than the previous one ( as the breadth decreases), so
                // it's better to do left++ there's a possibility of increase in area
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
