package org.example.BinaryTree.LeetCodeTreeProb;



public class SymmetricTree {


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


    //MAIN CODE
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        // Initially consider one root of left sub tree and another root of right sub tree
        // so as per Mirror property we know that left looks up to right and right to left
        // so simultaneously start traverse from root.left and also root.right at the same time
        // when you impose left sub tree as right property just like mirroring it, the left side data
        // of left subtree will be looking on right side of the right subtree

        return computeSymmetric(root.left, root.right);
    }

    public boolean computeSymmetric(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return left == right; // so if anyone is null to be symmetry the other should be null as well,
                                    // so if u find any node as null stop the traversing here it's self
        }

        if (left.val != right.val) {
            return false;       // this os straight forward when u impose left subtree as a mirror both the data
                                // should be same to be symmetric
        }

        return computeSymmetric(left.left, right.right) && computeSymmetric(left.right, right.left);

        /*boolean test1 = computeSymmetric(left.left, right.right);
        boolean test2 = computeSymmetric(left.right, right.left);
        return test1 && test2;*/

        // left.right and right.left is after traversing entirely left of left subtree and entirely right of right subtree,
        // the main subtree also posses inner subtree, like left subtree also may have another left subtree which also contain right node
        // and right subtree may contain another subtree which has left node as well, hence left.right and right.left.

    }

}
