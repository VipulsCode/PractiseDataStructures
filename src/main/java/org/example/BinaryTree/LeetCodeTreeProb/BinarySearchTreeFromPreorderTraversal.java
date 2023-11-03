package org.example.BinaryTree.LeetCodeTreeProb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** WE HAVE SOLVED THIS PROBLEM WITH O NLOGN * N AND ALSO IN O(N) COMPLEXITY:
 * The O NLOGN * N is the first solution and
 * O(N) is after main method
 */
public class BinarySearchTreeFromPreorderTraversal {

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

    public TreeNode bstFromPreorder(int[] preorder) {

        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return constructABinaryTree(preorder, 0, preorder.length-1, 0, inorder.length-1, hmap);
    }

    public TreeNode constructABinaryTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd,
                                         Map<Integer, Integer> hmap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // get the root value and put it in a new node;
        TreeNode root = new TreeNode(preorder[preStart]);
        // to find the above root in inorder i.e., where does it lie we can get it from hashmap
        int inRoot = hmap.get(root.val);
        // you have to also find how many elements are there in left subtree on inorder
        int numsLeft = inRoot - inStart;

        root.left = constructABinaryTree(preorder, preStart + 1, preStart + numsLeft, inStart,
                inRoot -1, hmap);
        root.right = constructABinaryTree(preorder, preStart + numsLeft + 1, preEnd, inRoot+1,
                inEnd, hmap);
        return root;

    }


    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        BinarySearchTreeFromPreorderTraversal  bst = new BinarySearchTreeFromPreorderTraversal();
        bst.bstFromPreorder(preorder); //----> This has complexity of O (N log n) * N

        bst.bstToPreorder(preorder); // This is for O(N) complexity
    }


    /** O(N) COMPLEXITY SOLUTION */
    public TreeNode bstToPreorder(int[] preorder) {
        int bound = Integer.MAX_VALUE;
        int[] arr = new int[]{0};
        return frameTheBstFromPreOrder(preorder, arr, bound);
    }

    public TreeNode frameTheBstFromPreOrder(int[] preorder, int[] arr, int bound) {
        // Now the intution is a bst is in which left node val lesser than root , and right
        //node val greater than root,

        if(arr[0] == preorder.length || preorder[arr[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[arr[0]++]); // incrementing arr[0] from 0 to 1
        // so the intution is wkt left side val of the root, should be lesser than the
        //present root

        root.left = frameTheBstFromPreOrder(preorder, arr, root.val);// so here bound is root.val

        // so for evry iteration towards left data should lie b/w arr[0] and root.val,
        //cannot exceed root.val

        root.right =  frameTheBstFromPreOrder(preorder, arr, bound);// so for right side
        //the bound is not root.val, rather previous root val, and wkt, for bst the
        //right node should be greater than the present root.

        return root;
    }
}

