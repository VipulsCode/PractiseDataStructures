package org.example.LRUImpl;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl {

    // to start LRU cache we will be needing 2 data structures
    // 1. HashTable(HashMap) for quick look using key and value pair
    // 2. Doubly Linked List for quick access as this Doubly linked list will be backed by HashMap
    // so no need to traverse linearly to find a node, using the key we can get directly where the node is.

    private class ListNode { // Doubly link list for quick access
        private int key;
        private int val;

        private ListNode next;

        private ListNode prev;

        private ListNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode head = new ListNode(0,0);// at initial stage maintain head to 0,0
    ListNode tail = new ListNode(0,0); // at initial stage maintain tail to 0,0

    Map<Integer, ListNode> map = new HashMap<>();// HasMap for quick look up
    int capacity;

    public LruCacheImpl(int capacity) {// This will be initialized while function is called, look at the commented codes at last lines
        this.capacity = capacity;
        head.next = tail;// initially head.next points to tail and tail.prev points to head
        tail.prev = head;
    }

    // implement get

    public int get (int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);// storing the data to pass in remove and insert as they take param as Node
            remove(node);// basically removing before updating(but if u remove it, it is nothing but inseert, next to head)
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    // implement put

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) { // if true , now implement lru, i.e., remove least recently used data from both map and doubly linked list,
            remove(tail.prev);		  //and this value will be previous of tail as LRU data will always be placed prev to tail
        }
        insert(new ListNode(key,val)); // since insert takes param of type ListNode
    }

    // implement remove

    public void remove(ListNode node) {
        map.remove(node.key); // removing from hash map
        // In doubly linked list we need to remove the node and the node can be any where
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // implement insert

    public void insert(ListNode node) {
        map.put(node.key, node); // adding in the hashmap
        // After adding in HashMap, we need to add the node very next to head in doubly linked list as well the below steps are for those.
        ListNode headNext = head.next; // saving head.next data so that it doesn't get lost
        head.next = node;
        headNext.prev = node;
        node.next = headNext;
        node.prev = head;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
