package org.example.BinaryTree.LeetCodeTreeProb;

public class DiameterOfBinaryTree {


    // BEGIN ALREADY GIVEN CODE IN LEET CODE
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

    // END OF  ALREADY GIVEN CODE IN LEET CODE


    // COde starts

    int maximum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getTheDiameterOfBinaryTree(root);
        return maximum;
    }

        public int getTheDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getTheDiameterOfBinaryTree(root.left);
        int rh = getTheDiameterOfBinaryTree(root.right);
        // why lh + rh , coz i am getting left height and right height from every node , and want a longest path
            // of every node , and that can be obtained using lh +rh, we do max (maximum, lh + rh) at every node
            // to make sure we only keep longest height

        maximum = Math.max(maximum, lh + rh); // this is important step , it count the number of edges, the kh and rh are populated by the way it's shown below'

            // how will you get the left height and reight height populated, here it is
        return 1 + Math.max(lh, rh); //The 1+ is coz , we need to include the tree node where we are standing, and this whole 1 + Math.max(lh, rh)
            // is used for counting the number of nodes on the path we are tracing.

        }

        // THE CODE IS SIMILAR TO MAX DEPTH OR HEIGHT OF BINARY TREE, only diff is maximum line addn
}
