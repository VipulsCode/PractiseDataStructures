package org.example.BinaryTree.LeetCodeTreeProb;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//ITERATIVE APPROACH INORDER TRAVERSAL --> PS: HAVE ALSO INCLUDED RECURSIVE APPROACH TOO (after main method)
public class BinaryTreeInorderIterativeTraversal {


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
    // COMMON BUILDING A TREE CODE END NOT REQUIRED*******



    // ITERATIVE APPROACH with explanation
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode currNode = root; // assigning root as currNode initially

        while(currNode != null || !st.isEmpty()) {
            // Using or condition coz ,once left subtree reaches it's last node
            // of the tree both the left and right value becomes null, and it's assigned to currNode, but the stack won't be empty yet.

            while(currNode != null) { // again checking this coz, we need to navigate till the last left of the subtree, and push to the stack
                                        // and assign the same to current node
                st.push(currNode);
                currNode = currNode.left;
            }

            // Now once the entire left of the subtree is traced , we need to pop the node from the stack and  print it,
            // here once the last left node is reached , then obviously the right and left of that particular last node becomes null,
            // once that happens we evict the node from the stack, by this the left data is printed and then root os printed,
            // and then we navigate to right of the subtree, as inorder states 1. leftNode , 2. root,  3. right

            currNode = st.pop();
            list.add(currNode.data);

            currNode = currNode.right;
        }
        return list;
    }




    public static void main(String[] args) {
        int[] nodes = {1};
        TreeNode root = TreeBuilder.buildATree(nodes);
        System.out.println(inorderTraversal(root));

        // CALLING RECURSIVE APPROACH METHOD, if asked
        inorderTraversalRecursively(root);
    }





    // IF ASKED IN RECURSIVE

    public static List<Integer> inorderTraversalRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        traverseInorder(list, root);
        return list;
    }

    public static void traverseInorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInorder(list, root.left);
        list.add(root.data);
        traverseInorder(list, root.right);
    }

}
