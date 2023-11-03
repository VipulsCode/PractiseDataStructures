package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
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

    // RECURSIVE approach STARTs *******************
    public int maxDepthThroughRecursion(TreeNode root) {
        return getTheMaxDepth(root);
    }
    public int getTheMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTheMaxDepth(root.left);
        int rightHeight = getTheMaxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight); // 1+ is for even to count the node on which you are standing and trying
        // to find the height
    }

    // recursive approach DONE ******************* Complexity O(N) space O(N)



    // This is Iterative Approach BEGINS ################
        public int maxDepth(TreeNode root) {

            int count = 0;
            if (root == null) {
                return count;
            }

            Queue<TreeNode> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {

                TreeNode currNode = q.poll();

                if (currNode == null) {

                    if (q.isEmpty()) {
                        break;
                    }
                    q.add(null);
                    count++;
                } else {

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }

                }
            }
            return count;
        }
    // The Iterative Approach id DONE ################
}
