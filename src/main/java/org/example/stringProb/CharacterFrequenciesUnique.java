package org.example.stringProb;

import java.util.HashSet;
import java.util.Set;


/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string
 * "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

 * Example 1:
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 */
public class CharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s= "addbbbcc";
        System.out.println(minDeletions(s));
    }
    public static int minDeletions(String s) {

            int[] freqCounter = new int[26]; // why 26 it's coz 26 albhabets
            // now i need to populate this freqCounter and see how many characters are repeated, if the characters are repeated,
            //  the index of that character (which can be calc by using
            //s.charAt[i] - 'a' ) in freqCounter will be increased by 1.

            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 'a';
                freqCounter[num]++; // so here the index value of freqCounter will be incremented by 1, for eg.,
                // num = 'a' - 'a' = 0, so freqCounter[0] = 1, again if we get 'a' by using s.charAt(i) subtract it by 'a'
                // again, the result will be 0 which is num i.e, num =0, so freqCounter[0] = 1+1 =2 and so on.
            }

            Set<Integer> set = new HashSet<>(); // i am considering set here to store non duplicate count, which will be
        // obtained from freqCounter
            int minDeletion = 0;

            for (int i = 0; i < freqCounter.length; i++) {

                while(freqCounter[i] > 0 && set.contains(freqCounter[i])) { // here we are trying to see what's the val of
                    // freqCounter at it's index, is any character repeated or not, if repeated then the val will be more
                    // than 1, and also we are validating is new character's repeatibility is same as any of the character,
                    // if yes, then we say to make it unique, reduce the count of the present character by 1 in freCounter[i],
                    // and also we increment the minDeletion by 1, stating 1 deletion was required, to inset the count in set,
                    // so it's like this for the first time if a is repeated 3 times, as this is a data in set go ahead and
                    // insert it, now if b also is repeated 3 times, then the set won't be accepting this val,
                    // as it was already repeated 3 times, so it doesn't make 'a' to be unique,
                    // so delete count of b by 1, so now the b os repeated only 2wice, it can go in set,
                    // so now set has {3,2} and this will be checked for others as well.
                    minDeletion ++;
                    freqCounter[i]--;
                }
                set.add(freqCounter[i]);
            }

            return minDeletion;
        }
}
