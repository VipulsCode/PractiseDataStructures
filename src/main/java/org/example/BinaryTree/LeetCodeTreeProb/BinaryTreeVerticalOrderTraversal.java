package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.*;

/**
 * No need to sort, if two nodes are in the same row and column, the order should be from left to right.
 */
public class BinaryTreeVerticalOrderTraversal {

    /**
     * Definition for a binary tree node.
     **/
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
     * Definition end  for a binary tree node.
     **/

    class Pair {
        int horizontalIndex;
        int verticalLevelIndex;
        TreeNode node;

        Pair(int horizontalIndex, int verticalLevelIndex, TreeNode node) {
            this.horizontalIndex = horizontalIndex;
            this.verticalLevelIndex = verticalLevelIndex;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> tmap = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            int xAxis = pair.horizontalIndex;
            int yAxis = pair.verticalLevelIndex;
            TreeNode currNode = pair.node;

            if (!tmap.containsKey(xAxis)) {
                tmap.put(xAxis, new TreeMap<>());
            }
            if (!tmap.get(xAxis).containsKey(yAxis)) {
                tmap.get(xAxis).put(yAxis, new LinkedList<>());
            }
            tmap.get(xAxis).get(yAxis).add(currNode.val);

            if (currNode.left != null) {
                q.add(new Pair(xAxis - 1, yAxis + 1, currNode.left));
            }
            if (currNode.right != null) {
                q.add(new Pair(xAxis + 1, yAxis + 1, currNode.right));
            }
        }

        for (Map.Entry<Integer, TreeMap<Integer, Queue<Integer>>> outrTreeMap : tmap.entrySet()) {

            resList.add(new ArrayList<>());

            TreeMap<Integer, Queue<Integer>> outrTreeMapVal = outrTreeMap.getValue();

            for (Map.Entry<Integer, Queue<Integer>> inrTreeMap : outrTreeMapVal.entrySet()) {

                Queue<Integer> individualQData = inrTreeMap.getValue();

                while (!individualQData.isEmpty()) {
                    resList.get(resList.size() - 1).add(individualQData.poll());
                }
            }

        }

        return resList;
    }

}
