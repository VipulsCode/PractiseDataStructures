package org.example.Trie;

import org.w3c.dom.Node;

/** 208. Implement Trie (Prefix Tree) - LeetCode*/
public class ImplementTrie {
    // Now Trie is Represented in form of a Trie Node and that trie node contains, an Array of TrieNode class with the
    // size of 26, and it also contains a boolean flag initially set to false.
    // why size 26, as i am representing 'a' as 0, b as 1, c as 2 and 'z' as 25, so the array indexes will be representing
    // a to z in the form of integer, like say from string word "hello" , i took a char e how will i store e in array as
    // array[ch - 'a'] --> so e - a is 5-1 = 4 , so e will be arr[4] for eg a ->0 b ->1, c->2, d->3, e->4

    //Note -> Trie will start with root once it holds one char from the string word, it will have its reference pointing to
    // another trie, which will again have an empty array with size 26 and boolean flag = false, so the conclusion as soon as u create
    // a trie and put a data in to it a new trie will be created so that the old trie refers to it's next data
    // for eg : hello --> now trie stores character by character , now one trie stored 'h' as soon as this is done another
    // trie is created and it is said like 'h' refers to the ext trie, mow this next trie will hold 'e', one more trie is created again,
    // and now e refers to it, new trie will hold 'l' again a new trie will be created with empty array of size 26 and flag = flase,
    // and this new trie will now hold other 'l' again a new trie is created and l is referring to it, this new trie will hols
    // 'o' and again a new trie will be created with empty arry of size 26, and boolean flag = false, and now as the word is done
    // "hello" , the last trie created has empty array and flag = false, now change this last trie flag to TRUE, indicating the last
    // character of word was reached in the prev trie node it self.
    //


    TrieNode root; // AS said the Trie starts with Root
    public ImplementTrie () {
        root = new TrieNode();// So everySingle time An ImplementTrie constructor is called a new Root will be initiated
    }

    public void insert(String word) {
        // Since we need to start with root, lets take root and did not want root to move from it's place, as we
        // will be traversing as well, hence assigned root to a variable node.
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            if (!node.containsKey(word.charAt(i))) { // if the Trie does not contain the character then Trie should hold it,
                // so put it , and also i have already mentioned the character will be indicated in the form of index, not index val.
                // Now the indexes value  will hold the new Trie as it's reference.
                node.put(word.charAt(i), new TrieNode());
            }
            // now Node need to move (traversed) to its reference New Trie Node, as it has to store further val and further new trie Node

            node = node.get(word.charAt(i)); // I am traversing the Node, here i am pointing it to the next newly created Trie Node

        }
        // Once every TrieNode is populated, the last which is left over with empty array of size 26, it's flag needs to be
        // changed to true, as stating the prev trieNode data has last character of the word
        node.setEndFlag();

    }

    // Search if the word exist
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEndFlag();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if(!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;// why am i just returning true here coz, so it checks if in the given prefix if any of the character misses the series in
        // trieNode then return false, else we say that the prefix was present.

    }


    }


// THIS IS REQUIRED : an Additional class, which will not be given in the Question, giving the structure of TrieNode
class TrieNode {
    TrieNode[] links = new TrieNode[26]; // now why name as links as this will hold the next trie node as a reference
    boolean flag = false;

    TrieNode() {

    }
    public boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) {
            return false;
        }
        return true;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node; // so here the character which we got from the word is treated as index, and its value is a new Trie Node
        // with  empty array list with 26 size and flag = false and rest of other utility function
    }

    public TrieNode get(char ch) {
        return links[ch - 'a']; // This character which is treated as index holds new trie Node, with empty array, and boolean flag false,
        // this new Trie node will be populated where it's called
    }

    public void setEndFlag() {
        flag = true; // so setting that particular TrieNode's flag to true, as it's a last trieNode, indicating the prev
        // Trie Node had the last character of the word.
         }

    public boolean getEndFlag() {
        return flag;
    }
}
