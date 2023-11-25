package org.example.BinaryTree.LeetCodeTreeProb;

/**
 *  There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 */

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
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
// ADDITIONAL CLASS REQUIRED :: IT"S SIMPLE
    public class Pair {
        int columnIndex; // This is plotted in X- axis way, when you extend the xaxis plotted dots in form of lines, then it will be shown as vertical lines).
        // As you move to left subtract -1 from current node, for eg., let root be 0, moving root to left will be 0 - 1 = -1 so -1 will be the columnIndex, similarly if
        // there's one more left node, as the current columnIndex is = -1 , the next one will be -1-1 = -2, so if the Pair
    // has to be represented in (row,col) , so to populate row we use horizontalIndex, move to left from root then add -1 to the next node to root, if moving towards right from
    // the root add + 1 to the next node of the root
        int levelIndex; // This is Y -axis index (it means when you come down  in y axis from top to bottom, it is represented as level by level),
        // so this was needed coz at x-axis index you might find multiple nodes, i mean at same position there might be more than 1
        // node, so we need to see from top which os visible first, so this ca be taken care by level order, so to set level index, at every level we step down (vertically)
        // so as it is said when you move left from any node it will be (col, row) will be shown if moved left (col -1, row+1) . And if moved right it will be (col + 1, row +1).
        TreeNode node;

        public Pair(int columnIndex, int levelIndex, TreeNode node) {
            this.columnIndex = columnIndex;
            this.levelIndex = levelIndex;
            this.node = node;
        }
    }

    /** we will create a TreeMap to store the key as horizontal Index, and value as the array of data, matching those
     * horizontal index, for eg., in below example -1, 0,1, 2 are horizontal index , and equivalent to it we need to consider level index as well, below representation shows
     * (columnIndex, levelindex)
     * (0,0 ) (-1, 1(levelIndex)), (1,1), (0,2), (2,2)
     *
     *   | -1  |0  | --> 1      how the data will look like --> -1,1 = [20], 0,0 = [10], 0,2 = [15] (as 0 passes vertically 0n 10 as well as on 15), 1,1 -->[30], 2,2 --> [40].
     *   |     |  |   |         So the 1st vertical line is -1 , 2nd vertical line is 0 as it's root(10) , and 3rd vertical line 1
     *   |    10  |   |         and 4th line is 2, how is this done--> 10 is a root giving the horizontal index as 0,
     *   |  / | \ |   | --> 2   now move towards left, as you move to left subtract current horizontal index with 1, so
     *   20   |  30   |         0 - 1 = -1, if there's other left derived from 20 then -1 - 1 = -2(one more vertical line would have been drawn),
     *   |     / | \  |         if 20 has right, then -1 + 1 = 0, the right'h index val would be 0, now moving from 10 to right, so the horizntl
     *   |   15  |   40         index at 30 will be 0 + 1 = 1, so moving right means adding +1 at every step, left means -1 at every step.
     *   |    |  |   |
     */

    //START OF PROGRAM
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /** why tree map , it's coz we need to sort the keys like -2,-1,0,1,2 and so on */

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tMap = new TreeMap<>();

        //on top the 1st Integer with in Outer TreeMap i mean the Key is X-axis index ie., column index, and the next integer is Y axis Index, which is a key for an inner Treemap
        // here PriorityQueue is for sorting the value for eg, if left and right subtree has the data at x and y index being the same like (0,2) 0f left subtree = 8
        // and (0,2) of right subtree = 5, before framing this in list we need to sort it so 1st 5 will be considered then 8, this can be achieved by Priority queue, as it stores least element on top.

        // so 1st tree map is to sort, as tum left sey print karogey o/p me , aur dusra tree maop isiliye chahhiye ki tum top view se dekhogey ki pehla kaunsa node dikh raha hai
        // for eg., let's say we have another subtree towards left from 15 (from the diag), and it's val is 13 , so we have 20 and 13 on -1 vertical line from top ,
        // so which level to consider first, so if you see from top 20 is first seen which is at level 2 , as we start level from 0, and 13 will be at level 4, so level 2 will be considered
        // as treeMap (2nd one) is used taking level as key.

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0, root)); // So PAIR is additional class i have designed coz it will have horizontal index, and level index and TreeNode

        while (!q.isEmpty()) {
            Pair currPair = q.poll();

            TreeNode currNode = currPair.node;
            int x = currPair.columnIndex;
            int y = currPair.levelIndex;

            if (!tMap.containsKey(x)) {
                tMap.put(x, new TreeMap<>());
            }
            if (!tMap.get(x).containsKey(y)) {
                tMap.get(x).put(y, new PriorityQueue<>());
            }
            // now if it wasn't containing x & y or either of it, we have populated x and y , now we need to put the data in priority queue
            tMap.get(x).get(y).add(currNode.val); // so adding current Node values in priority Queue. The above checks was also necessary in case if both x & y were present already
            // with different data, and now new data has to be appended in priority queue, so we had to sort them, for eg (0,2 ) = 8 and (0,2) = 5, so 5 will be prioritised first.

            if (currNode.left != null) {
                q.add(new Pair(x - 1, y + 1, currNode.left));
            }
            if (currNode.right != null) {
                q.add(new Pair(x + 1, y + 1, currNode.right));
            }
        }

            List<List<Integer>> resList = new ArrayList<>();

            for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> outerMapItr : tMap.entrySet()) {
                TreeMap<Integer, PriorityQueue<Integer>> outerMapValue = outerMapItr.getValue();

                resList.add(new ArrayList<>()); // adding One Empty list at every iteration before every individual level, so that it collects all the data in that particular level

                for (Map.Entry<Integer, PriorityQueue<Integer>> innerMapItr : outerMapValue.entrySet()) { // this is for level iteration
                    PriorityQueue<Integer> priorityQNodeVal = innerMapItr.getValue();

                    while (!priorityQNodeVal.isEmpty()) {
                        System.out.println(priorityQNodeVal.peek());

                        resList.get(resList.size() - 1).add(priorityQNodeVal.poll());
                        // this function when it lands for first time gives you lastly added new Empty Array list, which was done in above for loop, which will be populated with priority queue's data,
                        // if one or more than one node value is present in Priority Queue ,If more than one is present as it has same x index and / or y index, it will be added in the same list.
                    }
                }
            }
        return resList;
    }
}
