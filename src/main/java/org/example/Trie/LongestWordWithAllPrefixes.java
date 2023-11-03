package org.example.Trie;

/** So the longest word should be a complete string , that means every character of the longest string should have its
 * reference trie with flag true, means that subwords in the longest string should be a word or prefix which is already
 * inserted means as a input
 * for eg n --> 1 input, ni - 2nd input, nin --> 3rd input, ninj -> 4th input, ninja -> 5th input, ninga -> 6th input
 * so n is a complete string as n will be inserted in root, and this input string contains only one char so the ref trie having
 * param as flag should be updated from flase to true, similarly ni is a complete string--> after it's the flag will be true in its
 * refrence trie, but if u see closely for input ni after n also the ref of n has flag as true, which there was already a word
 * called "n" was inserted, so for "ni" every individual character of this string has its ref trie flag as true. Similarly for
 * nin , till ni all its ref trie has true , stating there was already a prefix as ni as word was inserted, and the next ref trie of j
 * will have flag as true, marking j was last char of word ninj. same thging follows with ninja, till ninj prefix was already inserted
 * and after "a" the reference trie of a will have flag updated as true, since a was last character of that word.
 * NOW for ning, till nin the prefix word was already there, as soon as the ref trie after nin is seen t, it shows g isn't present,
 * so create a ref trie for g with flag false, and now insert a in it and create another trie ref of "a" ,now mark flag as true for "a",
 * since it was a last char for word "ninga". BUT ther's a flag false in this word which is after 'g', which says the ning as a prefix hadn't existed at all,
 * so it's not a complete string. SO NINJA is a longest string
 *
  */
public class LongestWordWithAllPrefixes {
    TrieNode2 root;

    public LongestWordWithAllPrefixes() { // constructor
        root = new TrieNode2();
    }

    public String longestWord(String[] words) {


        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        // to find the longest string
        String longest = "";
        for (int i = 0; i < words.length; i++) {
            boolean res = getTheLongestWord(words[i]);// top get which in array is the longest word, you need to iterate every index of the array , which contains individual word
            if (res) {
                if (words[i].length() > longest.length() ||
                        (words[i].length() == longest.length() && words[i].compareTo(longest) < 0)) { // Using compareTo method to find which word is smallest lexicographically
                    // when both the string length are same the value is 0, if value is -1 that means words[i] is smaller than longest, so longest is words[i]
                    longest = words[i]; // now in the if statement above, looking at the second condition you will be confused as word[i] is smaller than longest as the value is -1, then why longest = word[i],
                    // it's coz see the condition before and if words[i].length == longest.length(), but in a dictionary fashion words[i] is smaller than longest, so words[i] will be considered
                    // hence longest = words[i].
                }
            }
        }
        return longest;

    }


    public void insert(String words) {
        TrieNode2 node = root;
        for (int i = 0; i < words.length(); i++) {
            if (!node.containsKey(words.charAt(i))) {
                node.put(words.charAt(i), new TrieNode2());
            }
            node = node.get(words.charAt(i));
        }
        node.setEnd();
    }

    public boolean getTheLongestWord(String words) {
        TrieNode2 node = root;
        for (int i = 0; i < words.length(); i++) {
            if (!node.containsKey(words.charAt(i))) {
                return false;
            }
            node = node.get(words.charAt(i));// this should be before node.getFlag(), as we need to reach to the next node to check the flag value, if it's false it's not
            // the end of the character of that particular word. If true, the word's last character was occupied by previous TrieNode.

            if(!node.getEnd()) { // this is done because as per question, find the longest string in words such that every prefix of it is also in words.
                //For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words. so at every index, pointing to the TreeNode
                // The flag should be true, coz for the longest word, every character in it should have been separate words.
              return false;
            }
        }
        return true;
    }
}

class TrieNode2 {
    TrieNode2[] links = new TrieNode2[26];
    boolean flag = false;

    public boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) { // I am storing character as index as ascii val i.e., links[ch-'a']
            return false;
        } else {
            return true;
        }
    }

    public void put(char ch, TrieNode2 node) {
        links[ch-'a'] = node; // the links stores the particular char as ascii val, and also points to ref trie
    }

    public TrieNode2 get(char ch) {
        return links[ch - 'a'];// returns the next trie ref
    }

    public void setEnd() {
        flag = true;
    }
    public boolean getEnd() {
        return flag;
    }

    public static void main(String[] args) {
        String[] words = {"n", "ni", "nin", "ninj", "ninja", "ninga"};
        LongestWordWithAllPrefixes lg = new LongestWordWithAllPrefixes();
        System.out.println("The longest word is " + lg.longestWord(words));
    }
}
