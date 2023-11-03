package org.example.BinaryTree.LeetCodeTreeProb;

public class FlattenBinaryTreeToLinkedList {

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

    TreeNode prev = null; // I am using this to make sure that i am populating prev with right node first and then keep on moving prev upwards it's
    // similar to revesal of Linked list, how i move prev up in later stages.

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right); // here i have taken root.right , so that the prev variable is populated by rroot.right fierst, on later stage it will also hold root.left ,
        // as moving prev node up
        flatten(root.left);

        root.right = prev; // as i said prev takes right nodes first
        root.left = null; // as said in question need to maintain left as null
        prev = root; // here prev is moving up the order , like as per example 1 first iter of prev will have node 6 and then move up with prev 5 --> and this nodes
        // right will be 6, similary again prev will become 4 with its right being 5 --> 6 (holding 5 and 6) and root.left being null.

    }
}
