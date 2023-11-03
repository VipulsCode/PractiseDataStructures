package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    // COMMON BUILDING A TREE CODE START NOT REQUIRED*******
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
            if (nodes.length == 0) {
                return null;
            }
            if (ind < nodes.length - 1) {
                ind++;
                if (nodes[ind] == -1) {
                    return null;
                }

                TreeNode newNode = new TreeNode(nodes[ind]);

                newNode.left = buildATree(nodes);
                newNode.right = buildATree(nodes);

                return newNode;

            }
            return null;
        }


    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ls1 = new ArrayList<>();
        if (root == null) {
            return ls1;
        }
        String s1 = "";
        getThePath(root, ls1, s1);
        return ls1;

    }

    public static void getThePath(TreeNode root, List<String> ls1, String s1) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            String s2 = s1;
            s2 = s2 + root.data;
            ls1.add(s2);
            return;
        }
        s1 = s1 + root.data + " -->";
        getThePath(root.left, ls1, s1);
        getThePath(root.right, ls1, s1);
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,-1,5,-1,-1,3,-1,-1};
        //int[] nodes = {1,7,8,9,11,12,-1,-1,-1,10,-1,-1,13,-1,-1, -1,2,3,-1,-1,4,-1,5,-1,-1};
        TreeNode root = TreeBuilder.buildATree(nodes);
        System.out.println(binaryTreePaths(root));
    }
}
