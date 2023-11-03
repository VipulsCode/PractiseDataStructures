package org.example.BinaryTree;

import com.sun.source.tree.Tree;

public class PreOrderBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class TreeBuilder {
        static int ind = -1;
        public static TreeNode buildATree(int[] nodes) {
            ind++;
            if (nodes[ind] == -1) {
                return null;
            }
             TreeNode newNode = new TreeNode(nodes[ind]);

            newNode.left = buildATree(nodes);
            newNode.right = buildATree(nodes);

            return newNode;
        }

    }

    public static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeNode root = TreeBuilder.buildATree(nodes);
        preOrderTraversal(root);
    }

}
