package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

     //* Definition for a binary tree node.
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

    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> ls = new ArrayList<>();
          if (root == null) {
              return ls;
          }
          Stack<TreeNode> s1 = new Stack<>();
          Stack<TreeNode> s2 = new Stack<>();

          s1.add(root);
          while(!s1.isEmpty()) {
              root = s1.pop();
              s2.add(root);
              if (root.left != null) {
                  s1.add(root.left);
              }
              if (root.right != null) {
                  s1.add(root.right);
              }

          }
          while (!s2.isEmpty()) {
              ls.add(s2.pop().val);
          }
          return ls;
    }
}
