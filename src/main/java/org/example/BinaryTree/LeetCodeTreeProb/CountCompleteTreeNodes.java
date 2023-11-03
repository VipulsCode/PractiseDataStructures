package org.example.BinaryTree.LeetCodeTreeProb;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class CountCompleteTreeNodes {

    /**Definition for a binary tree node. GIVEN IN LEET CODE*/
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
    /**END OF Definition for a binary tree node. GIVEN IN LEET CODE*/

    /**  INTUITION IS :
     *
     * Since the problem has to be done in less than 0(n), if dfs or bfs is applied u can get the answer in O(n), but we need
     * lesser than that, so the intuition is we need to first see from the given root the height of left subtree is it similar to
     * height of right sub tree, if it similar so that means it's a complete tree, so we can apply a formulae to find total number
     * nodes in the tree, (2 << h) - 1 --> this says shift left height of the tree times and then subtract by 1, shifting means
     * think height of the tree is 1, then shift 2 for 1 time to left in bitwise way (so previously 2 was represented as 0 0 1 0 -->
     * now after shifting 2, 1 place towards left the binary becomes (0 1 0 0) -- > so the out come will be 4), similarly if Height
     * of tree is 0, then 2 << 0 , i.e, shift 2 towards left 0 times, so the out come is 2.
     *
     * Now if it is not a complete tree, then we need to traverse one STEp towards left from left and 1 step towards right, and now see ,
     * if this left subtree height forms a complete try , if it does, then use formulae, and the same thing goes to right subtree.
     * if still not same tree then dig deep to left , and also to the right to keep on seeing if its complete tree or not.
     * this can be achiebed by recursion, Now here we will not be travelling to all the nodes, if you see the code, we wont be leaf nodes
     * for both left and try whether its null or not. so the complexity goes like finding first the height of tree, at very begining step
     * takes logN , and then recursion takes logN so
     * time complexity is (logN) * logN
     */

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeightOfTree = getLeftHeightOfTree(root);
        int rightHeightOfTree = getRightHeightOfTree(root);

        if (leftHeightOfTree == rightHeightOfTree) { // If this is true that means it's a complete tree
            return (2 << leftHeightOfTree) - 1; // formulae for complete tree
        }

        return 1 + countNodes(root.left) + countNodes(root.right); // dig deep to find the complete tree from current node go to the left subtree, and right subtree and again
        // check for complete tree , if true execute the formulae
    }

    public int getLeftHeightOfTree(TreeNode root) {
        int count = 0;
        while (root.left != null) { // if i use root != null rather than root.left != null, then once i get the complete tree in left subtree or right subtree
            // the answer which ill get using (2 >> leftHeightOfTree) - 1 will be wrong, why leftHeightOfTree , u can take anything like rightHeightOfTree as both will
            // according to rule
            count++;
            root = root.left;
        }
        return count;
    }

    public int getRightHeightOfTree(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

}
