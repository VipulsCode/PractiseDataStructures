package org.example.Trie;

/** 211. Design Add and Search Words Data Structure
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.*/

 public class SearchWordsDataStructure {
  TrieNode3 root;

  public SearchWordsDataStructure() {
   root = new TrieNode3();
  }

 public void addWord(String word) {
   TrieNode3 node = root;
   for (int i = 0; i < word.length(); i++) {
    if (! node.containsKey(word.charAt(i))) { // Current node check
      node.put(word.charAt(i), new TrieNode3()); // if the character of that word isn't present in Trie Node then add it, why new TrieNode3(), as we know that in Trie,
     // every trie node holds character as the index and same nodes also holds the reference of next trieNode
    }
    node = node.get(word.charAt(i));// This is to iterate next held reference node
   }
   node.setEndFlag(); // once all the character of the word is inserted the last trie node will have empty TrieNode array of size 26 and flag will be set to true,
  // indicating the prev TrieNode holds the last character of the word
 }

 public boolean search(String word) {
   TrieNode3 node = root;
   return search(word, 0, node);
 }


 public boolean search(String word, int index, TrieNode3 node) {
   // Base checks
  if (node == null) { // This is similar to containsKey class , if the character specified in links array isn't present then the returned node is null,
                     // the above function is called in recursion, you'll understand
   return false;
  }
  if (index == word.length()) { // This is similar to checking has the searching word reached it's last character, if yes then to say if the same word was inserted or not,
                                // we check the last trie node to see what's the val of flag is, if true the word is present if not no
      // remember here index is compared word.length() and not to word.length - 1, so we can reach to the last trie node, in which the end flag result will tell us has the word reached final character
   return node.isFlag();
  }

  char ch = word.charAt(index); // to extract individual character from the word to check if the word has char '.'

  if(ch == '.') {
   for (int k = 0; k < 26; k++) { // so why for, as soon as we get char '.', we need to traverse to all the 26 indexes of links array of current node, to find which index is not null, as soon
    // as we find any not null index, we iterate that particular branch of Trie and try to find, if we match the indexed data with the '.' as in question it is says that '.'
    // can take any data, and then iterate it further to check does the character after the '.' in the String word, present in the branch of trie or not.
    // NOTE -> when k = 0, it means you are going to iterate the current node (in that you'll find the Links array we iterate that ) not the root node, if the starting of the word starts with, then current node will be root node, but not after that

    if (search(word, index + 1, node.links[k])) { // why index + 1, humney jo current link index of trie se data mila usey humney '.' pe laga diya,
     // now we need to check for next character in the word, and check after placing the data's in place of '.' is this word is inserted in trie or not.
     // if present return true. and also i have taken links[k' rather than links[ch-'a'] reason is i know i need to check for all 26 character for not null,
     // if you found one, check if the whole word is present in trie branch, if present no need to check further
     return true;
    }
   }
  } else {
     if (search(word, index+1, node.links[ch - 'a'])) { // so this is node.links[ch - 'a'] letting me move to the next node, similar to that of node.get(),
      // again index + 1, is an iterator for the word, so the checking whether the whole word exists are not will be checked in base checks it self, which is on top
      return true;
     }
    }
    return false;
   }


    public static void main(String[] args) {
        SearchWordsDataStructure st = new SearchWordsDataStructure();
    }
}


class TrieNode3 {
  TrieNode3[] links = new TrieNode3[26];
  boolean flag = false;

  public boolean containsKey(char ch) {
   if (links[ch - 'a'] == null) {
    return false;
   }
   return true;
  }

  public void put(char ch, TrieNode3 node) {
   links[ch-'a'] = node;
  }

  public TrieNode3 get(char ch) {
   return links[ch - 'a'];
  }

  public void setEndFlag() {
   flag = true; // This is to set at the end of the word
  }

  public boolean isFlag() {
   return flag;
  }
}
