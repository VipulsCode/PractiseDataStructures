package org.example.BinaryTree.LeetCodeTreeProb;

public class BalancedBinaryTree {

    // So a binary tree is said to be balanced only if the difference between the left sub tree and right subtree is lesser or equal to 1,
    // and this condition is followed for every individual tree node.

// Dummy Creation **************
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

    // Dummy Creation ENDS**************


    public boolean isBalanced(TreeNode root) {

        int res = checkIfBalanced(root);

        if (res == -1) {
            return false;
        }
        return true;
    }

    public int checkIfBalanced(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = checkIfBalanced(root.left);
        if (leftHeight == -1) { // At any time we get LeftHeight as -1 we can say that tree is not balanced, and nothing to proceed further.
            return -1;
        }

        int rightHeight= checkIfBalanced(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) { // This condition is to check if tree is balanced or NOT
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight); // This will give me the max height of the tree
    }
}

// Explanation :
// So i am using the recursion code find height of tree with just 2 line code addition which are

/*

            if (leftHeight == -1) {
              return -1;
             }
            if (rightHeight == -1) {
            return -1;
            }

            if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
            }




Now the question is how will i get leftHeight == -1 or rightHeight == -1.
SO its when you execute the below code, and the return value is -1, that goes and gets assigned to leftHeight or rightHeight.

         if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

*/
