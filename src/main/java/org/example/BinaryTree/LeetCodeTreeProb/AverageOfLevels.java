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


    /**
     *Consider the below program rather considering the last one , as we follow the below type of BFS programming
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> resList = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // we take this size coz we need to iterate till the number of nodes at that level, and we need to store this in a variable if we take
            // i < q.size() in for loop the iteration will go wrong, coz we are removing from q in for loop and also adding in the Queue in the same for loop, but this
            // addition is for the next level

            double sum = 0.0;// this is to keep the addition of node value in that particular level

            int count = 0; // This is to know count of nodes present at that particular level;

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.remove();
                sum = sum + currNode.val;
                count++;

                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            resList.add(sum / count);
        }
        return resList;
    }






    /** ANOTHER WAY:
     *This is by using null in Queue, it's correct but do not follow this
     */

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
