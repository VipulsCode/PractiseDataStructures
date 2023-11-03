package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
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

    static class BuildTree {
        static int ind = -1 ;
        public static TreeNode treeBuilder(int[] nodes) {
            ind++;
            if (nodes[ind] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[ind]);

            newNode.left = treeBuilder(nodes);
            newNode.right = treeBuilder(nodes);

            return newNode;

        }
    }

    public static void inOrderTraversal(TreeNode root) {
        // Visit/Print Left subTree first and then Root and lastly right subTree
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left); // printing left subtree first
        System.out.println(root.data); // printing the data, this will print root as well as we are traversing every node becomes root
        inOrderTraversal(root.right);// printing right subtree
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeNode root = BuildTree.treeBuilder(nodes);
        inOrderTraversal(root);
    }

}
