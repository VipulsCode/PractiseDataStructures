package org.example.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderOrBFS {
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

    public static void levelOrderTraversalOrBFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode root = TreeBuilder.buildATree(nodes);
        levelOrderTraversalOrBFS(root);
    }
}
