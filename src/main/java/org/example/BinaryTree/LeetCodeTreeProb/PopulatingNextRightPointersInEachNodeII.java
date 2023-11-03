package org.example.BinaryTree.LeetCodeTreeProb;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}




    // Different form of BFS --> which we need to follow - prefer this

    public Node populatingNextRightPointer(Node root) {
     if (root == null) {
         return null;
     }

     Queue<Node> q = new LinkedList<>();
     q.add(root);

     while (!q.isEmpty()) {
         int size = q.size();

         for (int i = 0; i < size; i++) {

             Node currNode = q.poll();

             if (currNode == null) {
                 break;
             }

             if (i < size - 1) { // why size -1 coz , if i do i < size, then node 3's next will not point to null rather it
                 // will point to 4 taking 1st i/p example from Question, as at 2nd level q will also have 4, and 5
                 currNode.next = q.peek();
             }

             if (currNode.left != null) {
                 q.add(currNode.left);
             }
             if (currNode.right != null) {
                 q.add(currNode.right);
             }

         }
     }
     return root;

    }


    /**
     *The other way of silving the problem
     */

    public Node connect(Node root) {

    if (root == null) {
        return null;
    }

    Queue<Node> q = new LinkedList<>();
    Node replicaNode = root;
    q.add(root);
    q.add(null);

    while(!q.isEmpty()) {
        Node currNode = q.poll();
        if(currNode == null) {
            if (q.isEmpty()) {
                break;
            }
            q.add(null);
        } else {
            if (currNode.left != null) {
                q.add(currNode.left);
                replicaNode.left = currNode.left;
            }
            if(currNode.right != null) {
                q.add(currNode.right);
                replicaNode.right = currNode.right;
            }
        }
        replicaNode = replicaNode.next;
    }

    return root;

    }
}
