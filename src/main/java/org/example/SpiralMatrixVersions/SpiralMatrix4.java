package org.example.SpiralMatrixVersions;

import java.util.Arrays;

public class SpiralMatrix4 {
    private class ListNode {
        private int val;
        private ListNode next;

        private ListNode() {
        }

        private ListNode(int val) {
            this.val = val;
        }

        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
        SpiralMatrix4 sp = new SpiralMatrix4();
        int[][] arr = sp.spiralMatrix(1,4);
        System.out.println(Arrays.deepToString(arr));
    }

    public int[][] spiralMatrix(int m, int n) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next= new ListNode(0);
        int[][] matrix = new int[m][n];
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;// row size
        int right = matrix[0].length - 1;

        ListNode temp = head;

        while (left <= right && top <= bottom) {
            // iterating from left to right
            for (int i = left; i <= right; i++) {
                if (temp == null) {
                    matrix[top][i] = -1;
                } else {
                    matrix[left][i] = temp.val;
                    temp = temp.next;
                }
            }
            top++;

            // iterating from righttop to bottom
            for (int i = top; i <= bottom; i++) {
                if (temp == null) {
                    matrix[i][right] = -1;
                } else {
                    matrix[i][right] = temp.val;
                    temp = temp.next;
                }
            }
            right--;
            // iterating from right to left
            if (top < bottom) {
                for (int i = right; i >= left; i--) {
                    if (temp == null) {
                        matrix[bottom][i] = -1;
                    } else {
                        matrix[bottom][i] = temp.val;
                        temp = temp.next;
                    }
                }
                bottom--;
            }

            // iterating from bottom to top
            if (left < right) {
                for (int i = bottom; i >= top; i--) {
                    if (temp == null) {
                        matrix[i][left] = -1;
                    } else {
                        matrix[i][left] = temp.val;
                        temp = temp.next;
                    }
                }
                left++;
            }
        }
        return matrix;
    }
}
