package org.example.ProgPractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// implement hashmap
public class ProgramPractise<K,V>{
    public class HashNode<K,V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //the data structure used is array is used to store the bucket index so the retrieval is in O(1) times, and Linked List
    // the linked list is used to add the data and remove at O(1) times.
    // so it's an Array of type LinkedList, and this LinkedList takes the type HASH NODE, with key and value

    LinkedList<HashNode>[] bucket; // here the declaration of array is done
    int size; // the size is needed to get to know final number of data in LinkedList;

    public ProgramPractise() {
        bucket = new LinkedList[10000];// here the array is initialize but all the index value is null LinkedList

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>(); // here every index of array is not null, but initialised with new LinkedList
            size = 0;
        }
    }

    public void put(K key, V value) {
        int bI = getBucketIndex(key);// bucket index of the array
        int dI = getTheDataIndex(bI, key); // data index of the linked list

        if (dI == -1) {
            bucket[bI].add(new HashNode(key, value));
            size++;
        } else {
            HashNode node = bucket[bI].get(dI);
            node.value = value;
        }
    }

    public V get(K key) {
        int bI = getBucketIndex(key);
        int dI = getTheDataIndex(bI, key);

        if (dI == -1) {
            return null;
        } else {
            HashNode hn = bucket[bI].get(dI);
            return (V) hn.value;
        }
    }

    public void remove(K key) {
        int bI = getBucketIndex(key);
        int dI = getTheDataIndex(bI, key);

        if (dI != -1) {
            bucket[bI].remove(dI);
            size--;
        }
    }

    public int getBucketIndex(K key) {
        int index = key.hashCode() % bucket.length;
        int bI = Math.abs(index);
        return bI;
    }

    public int getTheDataIndex(int bI, K key) {
        int dI = 0;
        for (HashNode bucketItr : bucket[bI]) {
            if (bucketItr.key.equals(key)) {
                return dI;
            }
            dI++;
        }
        return -1;
    }

    public static void main(String[] args) {


    }

}
