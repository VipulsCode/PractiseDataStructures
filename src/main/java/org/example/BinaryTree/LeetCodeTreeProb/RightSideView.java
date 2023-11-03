package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        int level = 0;
        rightSideViewOfTree(root, level, ls);
        return ls;
    }

    public void rightSideViewOfTree(TreeNode root, int level, List<Integer> ls) {
        if (root == null) {
            return;
        }
        if (level == ls.size()) {
            ls.add(root.val);
        }
        // so we are going to follow here preOrder traversal , but bending a rule a bit so the root is printed first, then rather
        // traversing left first, we initiate from right, as we see the tree from right side.
        rightSideViewOfTree(root.right, level+1, ls);
        rightSideViewOfTree(root.left, level+1, ls);
    }
}
/** NOTE : for LEFT View just interchange
 *  rightSideViewOfTree(root.left, level+1, ls);
 *  rightSideViewOfTree(root.right, level+1, ls
 *  */



