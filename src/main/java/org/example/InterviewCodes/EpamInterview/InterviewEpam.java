package org.example.InterviewCodes.EpamInterview;


/*// CODE EXAMPLE VALID FOR COMPILING
class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Node { int data; Node next; }
    }

    private static Node rearrange(Node head){
        return null;
    }
}*/
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
    private Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
public class InterviewEpam {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        rearrange(head);

        print(head);

        //Node { int data; Node next; }
    }

    private static void rearrange(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secHalf = reversingTheList(slow.next);
        slow.next = null;

        mergeIt(head, secHalf);
    }

    private static Node reversingTheList(Node node) {

        Node curr = node;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static void mergeIt(Node first, Node second) {
        while(second != null) {
            Node firstNext = first.next;
            Node secNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secNext;
        }
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }
}
