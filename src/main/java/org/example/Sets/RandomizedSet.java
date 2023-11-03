package org.example.Sets;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> hmap;
    List<Integer> list;
    Random rd; // In built class

    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
        rd = new Random();

    }
    public boolean insert(int val) {
        if(hmap.containsKey(val)) {
            return false;
        }
        list.add(val);
        hmap.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!hmap.containsKey(val)) {
            return false;
        }
        int removalIndex = hmap.get(val);
        hmap.remove(val);
        if (removalIndex == list.size()-1) {
            list.remove(list.size()-1);
            return true;
        }
        // now swap the last index value with the removal index and remove the last index this will help in achieving removal in O(1).
        // but list also has function as list.set(int index, E element) method is used to update or replace an element at a specified index in a List.
        // Now what we do is , we know that the removal index does clearly point's to the val which is asked to be removed, so by using the index as removalIndex, we replace the
        // removal index original val which has to be deleted with the last data of the list, using set function of list. By this the asked val is removed from the list. And since
        // i have moved the last data of the list to the removal index (remember not val, i am talking abt index), it is fair to say remove the last indexed data as well, if not there
        // will be duplicate data. Now to maintain the consistency between the HashMap which has the key as the parameter val, and value of it is the index we maintain from 0, and LIST
        // which holds the val for that index. We need to update the key and val in hashmap as well, that is the key will be newly updated data of list present on the removal index,
        // and the val will be removal index.
        // kyunki hume pata hai ki list me ye index(removal index) par ye data hai(list.get(list.size()-1)). aur isi cheez of hume Hashmap me bhi update karna hai ki "key will be--> "list.get(removalIndex)",
        // aur hashmap ka value will be ye removal index so to be consistent with list.


        list.set(removalIndex, list.get(list.size()-1));
        list.remove(list.size()-1);
        hmap.put(list.get(removalIndex), removalIndex); // so now if again remove function is called you will find the removal index for the given val using hashmap,
        // and follow the process
        return true;
    }

    public int getRandom() {
        int randomIndex = rd.nextInt(0, list.size()); //where 2nd parameter here is exclusive
        return list.get(randomIndex);
    }

}
