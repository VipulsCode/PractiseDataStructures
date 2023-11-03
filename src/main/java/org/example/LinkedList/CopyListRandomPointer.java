package org.example.LinkedList;
/** 138. Copy List with Random Pointer

 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the
 * original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListRandomPointer {
    private class ListNode {
        private int val;
        private ListNode next;
        private ListNode random;

        private ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListRandomPointer cp = new CopyListRandomPointer();
        // call the below method using cp.
    }

    public ListNode copyListRandomPointer(ListNode head) {

        Map<ListNode, ListNode> refMap = new HashMap<>(); // here creating the map with type ListNode and ListNode coz,
                                                            // the 1st ListNode contains the address of original node and the 2nd Listnode
                                                            //contains the address of copied Node
        ListNode copyNode = new ListNode(-1);   // initially providing the ListNode with value -1
        ListNode itrCopyNode = copyNode;

        ListNode curr = head;

        while(curr != null) {                           // Till here i am just populating the data value in the new node,
                                                        // the next and random in newly constructed node is still null
            ListNode temp = new ListNode(curr.val);
            itrCopyNode.next = temp;
            itrCopyNode = temp;// need to move to the index of next, you can also write itrCopyNode = itrCopyNode.next
            refMap.put(curr, temp);
            curr = curr.next;
        }

        // Now we need to populate Random pointer as well
        curr = head;
        while (curr != null) {
            ListNode copiedNode = refMap.get(curr);// here i'll get the copied nodes 1 by 1 by using the address of Original Node
            // as we know that the map contains key as address of original node and this provides value as address of copied nodes.
            copiedNode.random = refMap.get(curr.random); // By using Original Linked List, i am using the curr.random of Original Linked List as the key,
                        // and you'll be retrieving the value node corresponding to random node, let's say refMap.get(curr.random) gives node 7 for 1st index (0 index basis),
            // check the input example, node 7 key has the value also as node 7, as refMap stores the value as similar to that of Original Linked List,
            // so the obtained random key, becomes the random node to the current node which in this case is copiedNode.random.
            curr = curr.next;
        }
        return copyNode.next;
    }
}
