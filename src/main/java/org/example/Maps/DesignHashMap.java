package org.example.Maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap<K, V> {
    private class HashNode {
        private K key;
        private V value;

        private HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int keySpace = 2200;
    private LinkedList<HashNode>[] bucketList; // This is an array of LinkedList, and the linked list takes the value, key and value
    //i.e, hashNode class.

        public DesignHashMap() {
            initBucket(keySpace); // here i am initializing the array which were null, every index of array will now have LinkedList of type hashNode, with data 0
            size = 0;
        }

        public void initBucket(int keySpace) {
            bucketList = new LinkedList[keySpace];
            for (int bi = 0; bi < bucketList.length; bi++) {
                bucketList[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bI = hashFunction(key);
            int dI = getTheIndexForInsertOrUpdate(key, bI);
            if (dI != -1) {// update
                HashNode hn = bucketList[bI].get(dI);  //i am telling that data index exists so just update the existing HashNode using bucket index in bucketlist, so using bucket index get the index if the array, and then see the linked list present in that array index, now using dataIndex, get the exact location in linkedlist
                hn.value = value;// i re intialized
            } else {
                // Insert
                HashNode node = new HashNode(key,value);
                bucketList[bI].add(node);
                size++;
            }
        }

        public int get(K key) {
            int bI = hashFunction(key);
            int dI = getTheIndexForInsertOrUpdate(key, bI);
            if (dI != -1) {
                HashNode hn = bucketList[bI].get(dI);
                return (int) hn.value;
            } else {
                return -1;
            }
        }

        public void remove(K key) {
            int bI = hashFunction(key);
            int dI = getTheIndexForInsertOrUpdate(key, bI);
            if (dI != -1) {
                HashNode node = bucketList[bI].remove(dI);
                size--;
            }
        }


        public int hashFunction(K key) {
            int bi = key.hashCode();
            int absBI =  Math.abs(bi) % bucketList.length;
            return absBI;
        }

        public int getTheIndexForInsertOrUpdate(K key, int bI) {
            int dI = 0;
            for (HashNode hn : bucketList[bI]) {// so here i know from which index of bucketList Array i need to get the linked list from, that's the reason it's bucketList[bI]
                // now iterating the linked list i.e,  bucketList[bI] gives you linked list Node of type HashNode, iterating it using for each loop.
                if (hn.key.equals(key)) {
                    return dI;
                }
                dI++;
            }
            return -1;
        }

}
