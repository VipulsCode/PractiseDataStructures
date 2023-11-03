package org.example.BinaryTree;

public class PostOrderTraversal {

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
    // RULE OF POSTORDER TRAVERSAL
    // 1. Print all Left SubTree
    // 2. Print all Right SubTree
    // 3. At last Print the ROOT
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeNode root = TreeBuilder.buildATree(nodes);
        postOrderTraversal(root);
    }
}
