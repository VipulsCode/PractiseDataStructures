package org.example.Trie;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    // will be doing using HashMap, so the string will hold the path, and the integer will hold the value

    Map<String, Integer> hmap;

    public DesignFileSystem() { // constructor, i am initializing hashmap

        hmap = new HashMap<>();
    }

    // 1st method to implement
    public boolean createPath(String path, int value) {
        // Using the fast fail conditions as per question constraint
        if (path.isEmpty() || (path.equals("/"))) {
            // if the map doesn't contain that path itself
            return false;
        }
        if (hmap.containsKey(path)) { // This is to check if the path already exist, do not create just return false.
            return false;
        }

        // Now need to check if the path has concatenation i mean if there's 2nd path for eg : /leetcode/leetcodeProblem
        // so checking if there's 2nd slash, if yes then there's 2nd path concatenated to first path
        int idx = path.lastIndexOf("/"); // This gives me the last index if the slash is present, as per question
        // there can be only one additional concatenated path to the main path, so at most 2 slash, so the last index gives me
        // index val of last slash, if the 2nd slash isn't present then the last index will give the index of 1st slash.

        // Now get the string before slash,
        // NOTE: we know that there will be at least 1 slash present
        String parentPath = path.substring(0, idx); // here if there's 2nd slash present only then the length will be one and above, as the 1st slash index is 0, as the path starts with slash "/".
        //so, if there's only one slash then  2nd parameter in substring excluded for which the value will be 0, as the idx will be 0 (considering index of 1st slash), so the parentPath will be 0


        if (parentPath.length() > 0 && !hmap.containsKey(parentPath)) { // so i am checking , is there a 1st path, after taking the substring from 0 to 2nd path slash  (i.e., concatenated path), if there's 1st path string
            // nned to check if this is a separate path , i mean if this path is parent path is already present or not, if no then return false, coz, the 2nd path can only be present if the parent path
            // already exists.
            return false;
        }

        hmap.put(path,value);
        // after all the checks go ahead if every thing isd fine put it in map
        return true;
    }

    public int get(String path) {
        if (path.isBlank() || !hmap.containsKey(path)) {
            return -1;
        }
        return hmap.get(path);
    }



    public static void main(String[] args) {
        DesignFileSystem ds = new DesignFileSystem();
        ds.createPath("/leetcode", 10);
        ds.createPath("/leetcode/problems", 10);

    }

}
