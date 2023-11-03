package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /*
     START OF CODE WHICH WILL BE GIVEN IN LEET CODE
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }

     /*
      END OF CODE WHICH WILL BE GIVEN IN LEET CODE
     */



    /**
     * One Way of Breadth first Search,

     * NOTE : THE LEET CODE SOLUTION IS THE SECOND APPROACH, AND WE NEED TO FOLLOW THE SECOND APPROACH
     */
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
                System.out.print(currNode.val + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }


    /**
     * THE OTHER  Way of Breadth first Search, WHICH WE NEED TO FOLLOW
     * AND LEET CODE SOLUTION
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();

        if (root == null) { // starting condition check for null
            return resList;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); // Initially populating Queue with root i.e., the 1st val in queue will be the root

        int level = 0; // to know which level you are in

        while (!q.isEmpty()) { // so whenever controller comes here , it indicates we start to determine elements in new level

            List<Integer> everyLevelElement = new ArrayList<>();

            resList.add(new ArrayList<>()); // here every index in resList is populated with empty list at first

            int qSizeOfEveryIndividualLvl = q.size();

            for (int i = 0; i < qSizeOfEveryIndividualLvl; i++) { // need to pop the data, equivalent to the number of data pushed in Queue at every level
                // that the reason q.size();

                TreeNode node = q.remove();

                resList.get(level).add(node.val); // get the level  by using get(index) and populate the data in the resList for that level

                // add child nodes of the current level in the queue for the next level
                if (node.left != null) {
                    q.add(node.left); // adding next level left child tree node in queues
                }
                if (node.right != null) {
                    q.add(node.right); //adding next level right child tree node in queues
                }
            }
            level++;

        }
        return resList;


        /*
NOTE : THE COMMENTED LINES IN THIS FUNCTION IS LEET CODE PROBLEM SOLUTION USING 1ST  APPROACH

        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        if (root == null) {
            return list2;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode curNode = q.poll();
            if (curNode == null) {
                list2.add(list1);
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                list1 = new ArrayList<>();

            } else {
                int data = curNode.data;
                list1.add(data);
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
        }
        return list2;*/

    }





    public static void main(String[] args) {
        int[] nodes = {-1};
        TreeNode root = TreeBuilder.buildATree(nodes);

        levelOrderTraversalOrBFS(root);

        List<List<Integer>> resList = levelOrder(root);
        System.out.println(resList);

    }



    /*
    THIS IS JUST AN ILLUSTRATION HOW TREE BUILDER WORKS
     */
    static class TreeBuilder {
        static int ind = -1;
        public static TreeNode buildATree(int[] nodes) {
            if (nodes.length == 0) {
                return null;
            }
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

    /*
        END OF ILLUSTRATION HOW TREE BUILDER WORKS
     */
}
