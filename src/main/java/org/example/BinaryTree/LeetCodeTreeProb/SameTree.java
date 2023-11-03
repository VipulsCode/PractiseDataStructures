package org.example.BinaryTree.LeetCodeTreeProb;

public class SameTree {

    // BEGIN ALREADY GIVEN CODE IN LEET CODE
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

    // END OF  ALREADY GIVEN CODE IN LEET CODE



    // CODE STARTS:
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkIfSameTree(p,q);
    }

    public boolean checkIfSameTree(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null || rightTree == null) {
            return leftTree == rightTree;
        }

        if (leftTree.val != rightTree.val) { // Followed fail fast approach, as soon as i get different value return false
            return false;
        }

        return checkIfSameTree(leftTree.left, rightTree.left) && checkIfSameTree(leftTree.right, rightTree.right);
        // Here i am check for both tree only on left side, if the values are equal or not recursively, and then checking
        // the right side of both the trees if the values are same are not
    }

}
