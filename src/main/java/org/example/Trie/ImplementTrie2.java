package org.example.Trie;


class Node {
 Node[] links = new Node[26]; // Again similar TrieNode array (similar to that of ImplementTrie prob) which contains 26 size i.e., a to z size
 //Now this Links array will hols the alphabets val in the form of index, lets say p is an alphabet so links will
 // hold it as links['p' - 'a']
 int countPrefix = 0; // This holds the count of startsWith prefixes, initially 0
 int countEndWith = 0; // This holds the count of how many words are repeated, initially 0.

 // As usual to that of ImplementTrie 1 problem we will have some common helper function with in this Node class

    public boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void put(char ch, Node node) { // the node will always be a new Node(), this function will store the alphabet in the form of index and points its reference to the new Node
        // and this new Node will again have empty array of size 26 and startsWith, and endWith and other function.
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a']; // This is returning the new Trie node reference , so that we can perform opern on new
        // trie node, This is how we iterate to new Trie Node as wel, even the new node already occupied with data,
        // we need to just iterate over the trie, this function can be helpful
    }

    /** Now the below are additional helper function compared to the ImplementTrie 1 */

    public void incrementPrefix() {
        countPrefix++;
        // so here no param is passed , but when this function is called it would be
        // called by using the current trie node, and that node will have populated data, so it will increment associated w
        // ith the particular TrieNode, Just like an object
    }

    public void incrementEndsWith() { // This is always once the word length is done,This will also be incremented more than the val 1,once you have duplicates
        countEndWith++;
    }

    public void decrementPrefix() { // This will be called when erase function is executed
        countPrefix--;
    }
    public void decrementEndsWith() { // This will be called when erase function is executed
        countEndWith--;
    }

    public int getCountEndWith() {
        return countEndWith;// return what's the counted data
    }

    public int getCountPrefix() {
        return countPrefix;// return what's the counted data
    }

}

/** Now LET"S Implement trie2 Using the above helper function and data member of TrieNode */

public class ImplementTrie2 {
    // So as it is important that Trie has to have root;
    Node root;
    public ImplementTrie2 () { // Once teh constructor is called it will produce a new Trie Node every single time,
        // with empty array Of trieNode with 26 size and its data members and member function
        root = new Node();
    }

    public void insert(String word) {

        Node node = root; // Now why am i doing this coz i do not want to disrupt the posn of root,
        // coz if there's any other word given to insert after finishing the current , or when ever we want to traverse
        // to do anything, we need to start from the same root, if we disrupt the posn by moving root front,
        // then you wont be able to perform any such oprn.

        for (int i = 0; i < word.length(); i++) {

            if (!node.containsKey(word.charAt(i))) {// the character , which is stored as index points to null,
                // as because initially all the 25 indexes is null, only later they are allotted with new TrieNode(), so its not null
                // so if null the character turned index isn't populated yet

                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i)); // so here i am moving to new trie reference , and in the new TrieNode, i will increment startsWith,
            // remember the start With does gets incremented once again when we start again from root, for another insertion and also if the characters match

            node.incrementPrefix(); //so here at very 1st insertion every new TrieNode will have "startsWith" set to 0, and it will change to 1, once the data is inserted,
            // so now all the trie node will have same starts With value, now this will be incremented to 2 , once we are
            // trying to insert same word, or till were ever the substring similar to that of prev string
        }
        node.incrementEndsWith(); //so only once the word length is done, and if the word is repeated it is incremented again, once the word reaches it's final length

    }

    public int countWordsEqualTo(String word) { // this is like duplicate word counting
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getCountEndWith(); // so if there's whole word as it is inserted so endsWith would be 2, and if there is three
        // of the same words repeatedly inserted then endsWith will be 3, so on and so forth

    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) { // this is to check how many number of sme prefix arte there in the word
            // for eg apple is inserted, so every character has startsWith count as 1, now there is word  "app" inserted now
            // char a has startWith as 2, char p has StartWith count as 2, and again another p has a startsWith count as 2,
            // as app was word, but l and e still will still have startsWith count as 1.

            if (!node.containsKey(prefix.charAt(i))) {
                return 0; // if the prefix word itself wasn't inserted before in links array so it will give null, hence this word isn't there so return 0
            }
            node = node.get(prefix.charAt(i)); // you got the prev character now iterate the Trie node to find further
            // character of the prefix word
        }
        return node.getCountPrefix();

    }

    public void erase(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return; // if the word not there then what to erase
            }
            node = node.get(word.charAt(i));
            node.decrementPrefix();
        }
        node.decrementEndsWith();

    }
    // NOTE : you would have seen if it's incrementing or decrementing the 'startsWith' and 'endsWith' variable . I am not
    // doing in the root node ,in root node these variable values are always 0, i am doing in its ref TrieNode, as for the root
    // the reference Trie Node is the next TrieNode.
    // That's the reason i iterate the trie node using 'node = node.get(word.charAt(i));' before incrementing or decrementing.
}
