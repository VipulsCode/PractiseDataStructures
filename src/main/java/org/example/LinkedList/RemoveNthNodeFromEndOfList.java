package org.example.LinkedList;

public class RemoveNthNodeFromEndOfList {
    private class NodeList {
        private int val;
        private NodeList next;

        private NodeList() {
        }
        private NodeList(int val) {
            this.val = val;
        }
        private NodeList(int val, NodeList next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeElementInLinkedList = new RemoveNthNodeFromEndOfList();
        NodeList resNode = removeElementInLinkedList.removeNthFromEnd(1);
        removeElementInLinkedList.display(resNode);

    }
    public NodeList removeNthFromEnd(int n) {
        NodeList head = new NodeList(1);
        head.next = new NodeList(2);
/*        head.next.next = new NodeList(3);
        head.next.next.next = new NodeList(4);
        head.next.next.next.next = new NodeList(5);*/

        NodeList head1 = new NodeList();
        NodeList temp = head1;
        NodeList temp1 = head;
        int size = 0;
        if (head.next == null && head.val == 0) {
            return head1;
        }
        while (temp1 != null) {
            size++;
            temp1 = temp1.next;
        }
        if (n > size) {
            return head;
        }
        temp1 = head;

        int i = 0;
        while(i <= size -1 -n) {
            temp.next = temp1;
            temp = temp1;
            temp1 = temp1.next;
            i++;
        }
        if (temp1 != null) {
            temp.next = temp1.next;
        } else {
            temp.next = null;
        }
/*        for (int i = 0; i < size; i++) {
            if (i != size-n) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else {
                if (temp1 != null) {
                    temp.next = temp1.next;
                    break;
                } else {
                    temp.next = null;
                    break;
                }
            }
        }*/
        return head1.next;
    }
    public void display(NodeList node) {
        while (node != null) {
            System.out.print(node.val + "--> ");
            node = node.next;
        }
        System.out.println("End");
    }
}
