package org.example.Sets;

import java.util.LinkedList;

/**
 * Similar to that of designing the HASHMAP, the only thing is in hash map in inner class we had key and value as parameter, Here it is just key, which is represented as DATA,
 * since hashSet is not stored in the form of key and value pair
 */

public class MyHashSet {

    class DataHashNode {
        private Integer data;

        public DataHashNode(Integer data){
            this.data = data;
        }
    }
    private int size;
    private Integer data;
    private LinkedList<DataHashNode>[] buckets;

    public MyHashSet() {
        size = 2020;
        initializeTheLinkedListArray(size);
    }
  /*  public MyHashSet(Integer data) {
        this.data = data;
    }*/

    public void initializeTheLinkedListArray(int size) {
        buckets = new LinkedList[size];
        for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
        }
    }

    public int hashFunction(Integer data) {
        int hashCodeVal = data.hashCode();
        int bI = Math.abs(hashCodeVal) % buckets.length;
        return bI;
    }

    public int getTheDataIndex(int bI, int data) {
        int dI = 0;
        for (DataHashNode dhn : buckets[bI]) {
            if (dhn.data.equals(data)) {
                return dI;
            }
            dI++;
        }
        return -1;
    }

    public void add(int key) {
        int bI = hashFunction(key);
        int dI = getTheDataIndex(bI, key);
        if (dI == -1) {
            DataHashNode dhn = new DataHashNode(key);
            buckets[bI].add(dhn);
        }
    }

    public void remove(int key) {
        int bI = hashFunction(key);
        int dI = getTheDataIndex(bI, key);
        if (dI != -1) {
            buckets[bI].remove(dI);
            size--;
        }
    }

    public boolean contains(int key) {
        int bI = hashFunction(key);
        int dI = getTheDataIndex(bI, key);
        if (dI != -1) {
            return true;
        } else {
            return false;
        }
    }
}
