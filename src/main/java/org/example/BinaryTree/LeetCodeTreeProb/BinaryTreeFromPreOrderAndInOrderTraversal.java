package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.HashMap;
import java.util.Map;

    public class BinaryTreeFromPreOrderAndInOrderTraversal {


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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }

        return buildATree(preorder, inorder, 0, preorder.length-1,
                0, inorder.length-1, hmap);

    }

    public TreeNode buildATree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd,
                               int inorderStart, int inorderEnd, Map<Integer, Integer> hmap) {

        if (preorderStart > preorderEnd || inorderStart > inorderEnd) { // why greater than coz if preorderStart == preorderEnd as well, then there is 1 node , similarly for inorderStart == indOrderEnd
            // so if there is 1 node as well , we can check whether it has left or right.
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]); // getting the root from preorder

        // have to find this root in Inorder where it lies

        int inorderRoot = hmap.get(preorder[preorderStart]); // you'll get the index where the root is present in Inorder

        int numsLeft = inorderRoot - inorderStart; // this will give how many number of element is present on the left side on Inorder

        root.left = buildATree(preorder, inorder, preorderStart + 1, preorderStart + numsLeft,
                inorderStart, inorderRoot - 1, hmap); // this helps in forming another inorder and preorder but of left subtree, so i am forming again 2 arrays
        // of inorder and preorder which is formed by using ("inorderStart, inorderRoot - 1" for inorder) and  ("preorderStart + 1, preorderStart + numsLeft" for preorder) and solving them again.

        root.right = buildATree(preorder, inorder, preorderStart + numsLeft + 1, preorderEnd,
                inorderRoot + 1, inorderEnd, hmap); // this helps in forming another inorder and preorder but of right subtree,  so i am forming again 2 arrays of inorder and preorder and solving them

        return root;

    }
}
