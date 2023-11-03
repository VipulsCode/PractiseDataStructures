package org.example.BinaryTree.LeetCodeTreeProb;

public class InvertBinaryTree {


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


// Start oF ACTUAL CODE
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    public void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root.left);    // Traversing all the the way to left through recursion
        swap(root.right);   // Traversing to the Right Now through recursion, wkt the Right of last node will be taken,
                            // once the above recursion reaches to null, and so on recursion proceeds.
        // SWAPPING
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}



// EXPLANATION
//So inversion of tree is nothing but swapping the subtree node which are joining from the root, so, once you are given a
// binary tree, so just mirror it thats an answer. To achieve it,
// WE traverse first the left side of the tree and go un till you find the null, and then traverse to a right through
// RECURSION, once the right node reaches null, Just swap the NODES by using default swapping mechanism.
// So at one stage there will be only 2 nodes left attached to master root, and the subtree under those nodes would have
// been swapped already. Now Just swap the last 2 nodes which is attched to master root. That's it.