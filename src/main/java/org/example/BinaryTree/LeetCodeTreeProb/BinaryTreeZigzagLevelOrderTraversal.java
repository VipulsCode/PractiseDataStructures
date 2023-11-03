package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    /** Definition for a binary tree node.  GIVEN IN LEET CODE */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /** END OF Definition for a binary tree node.  GIVEN IN LEET CODE */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size(); // do not use q.size() directly in for loop , as you will be doing q.poll() and if you use q.size() directly in for loop then the size will be decreasing
            List<Integer> ls = new ArrayList<>(); // at every level creating a new List, so once we reach a while loop we say 1 of the level is done
            for (int i = 0; i < size; i++) {
                if (q.isEmpty()) {
                    break;
                }
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                ls.add(q.poll().val);

            }
            if (!leftToRight) { // if this condition is true , then take the list of that level which is populated using normal BFS, Reverse that list and then add to the res List
                //  so for adding the data in Queue we use normal BFS, the zigzag can be shown in the way of reversing the current list anf adding to the resList, reversing can be seen below
                Collections.reverse(ls); // Here the Collections.reverse() uses two pointer approach of complexity O(n) , so i add all the node val of that level in the framed list
                // and at last i check if this time i need to maintain data from right to left, to make sure the shown data represents zigzag movement , i reverse the list then add to the
                // main list which is ansList
            }
            leftToRight = !leftToRight; // toggling, if 1st iter is true the next will be false, and then again true , and again false so on
            ansList.add(ls);// Need to add as the asked form is ( (1st levl), (2nd levl), (3rd level) )
        }

        return ansList;


    }
}
