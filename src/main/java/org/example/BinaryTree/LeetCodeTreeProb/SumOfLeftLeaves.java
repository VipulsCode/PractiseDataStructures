package org.example.BinaryTree.LeetCodeTreeProb;

/**
//STATEMENT
        Given the root of a binary tree, return the sum of all left leaves
        A leaf is a node with no children. A left leaf is a leaf that is the left child of another node. */


public class SumOfLeftLeaves {
/**
 * Definition for a binary tree node.*/
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
    /**
     * END for a binary tree node.*/

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        boolean flag = false;
        getSumOfLeftLeaves(root, flag);
        return sum;
    }

    public void getSumOfLeftLeaves(TreeNode root, boolean flag) {
        if (root == null) {
            return;
        }
        // but the question is to sum only left tree nodes , so we say only if we recurse the flag will be true,
        // and the if statement will be executed only for left as we check if flag == true on then execute if statement.

        if (flag && root.left == null && root.right == null) {
            sum = sum + root.val;
        }
        // but the question is to sum only left tree nodes , so we can use boolean function
        getSumOfLeftLeaves(root.left, true);
        getSumOfLeftLeaves(root.right,false);
    }

}
