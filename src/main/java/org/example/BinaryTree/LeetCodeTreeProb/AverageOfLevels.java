package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {


    /**Definition for a binary tree node. */
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
    /**END of Definition for a binary tree node. */

    public List<Double> averageOfLevels(TreeNode root) {
        // BFS of tree
        List<Double> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }

        double sum = 0.0;
        double count = 0.0;
        double result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode == null) {

                result = sum/count;
                ls.add(result);
                sum = 0.0;
                count = 0.0;

                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            } else {
                sum = sum + curNode.val;
                count++;
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if(curNode.right != null) {
                    q.add(curNode.right);
                }
            }
        }
        return ls;
    }
}
