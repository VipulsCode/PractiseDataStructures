package org.example.BinaryTree.LeetCodeTreeProb;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class IsValidBST {

    //Definition for a binary tree node.
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

    public boolean isValidBst(TreeNode root) {
        // So to check this whether the given TreeNode is VALID BST or not, you need to consider ranges, i mean we
        // are gonna specify in what range every individual node should fall in to be a valid BST.

        // At start let max value and min value be as shown below
        long maxValue = Long.MAX_VALUE;
        long minValue = Long.MIN_VALUE;
        return checkIfValidBst(root, minValue, maxValue);
        // if maxValue and in Value is taken as Integer it will fail for input [2147483647]
    }

    public boolean checkIfValidBst(TreeNode root, long minValue, long maxValue) {

        if (root == null) {
            return true; // this is coz when we iterate till the last end of the tree once reached null,
            // it's an end of left aide of the tree or the right side of the tree, but reaching to null doesn't say it's
            // not valid so considering once reached null, just return true. the condition checks are below though.
        }

        if (root.val >= maxValue || root.val <= minValue) { // this is the condition , if it doesn't lie in between specified range
            return false;
        }

        // now normal recursion just manipulating minimum and maximum
        boolean leftNode = checkIfValidBst(root.left, minValue, root.val); // so for root left initially the min value will be considered
        // as default one, and max should be previous root val, as BST states the left side should be lesser than it's parent node,
        // and also root node.

        boolean rightNode = checkIfValidBst(root.right, root.val, maxValue); // for right, the BST the right node should be larger than the parent node
        // hence min is prev node as it is parent,initially max value will be default, but it will change in left subtree iteration.

        return leftNode && rightNode; // if both are true only then it;s valid BST
    }

}
