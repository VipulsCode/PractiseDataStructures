package org.example.LinkedList;

public class ReorderList {


      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


      public  void reorderList() {

          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(3);
          head.next.next.next = new ListNode(4);

        int count = 0;

        ListNode currNode = head;
        ListNode prev = null;
        while(currNode != null) {
            ListNode temp = currNode.next;

            currNode.next = prev;
            prev = currNode;
            currNode = temp;
            count++;
        }
        ListNode list1 = head;
        ListNode list2 = prev;

        ListNode resList = new ListNode();
        ListNode itrNode = resList;

        for (int i = 1; i <= count; i++) {
            itrNode.next = list1;
            itrNode = itrNode.next;
            itrNode.next = list2;
            itrNode= itrNode.next;

            list1 = list1.next;
            list2 = list2.next;
        }

        head = resList.next;


        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }



    public static void main(String[] args) {
          ReorderList rl = new ReorderList();
          rl.reorderList();
    }
}
