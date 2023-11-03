package org.example.BitwiseOperatorProb;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 32;
        System.out.println(hammingWeight1(n));
        System.out.println(hammingWeight2(n));
    }

    /** BETTER APPROACH Consider this*/
    public static int hammingWeight1(int n) {
        // the intuition behind this approach is when ever you perform bitwise AND(&) operation on the given
        // number n (which will internally be in binary series) and n - 1,  the result will show the least significant bit containing 1
        //will be flipped to 0, (now LSB is extreme right side of the binary series) for eg n = 13 and now n-1 = 12, so the binary of 8 is
        // 1 1 0 1 and binary of 12 is 1 1 0 0 , now n & (n-1) --> 1 1 0 1 & 1 1 0 0 ==> 1 1 0 0 as u saw the LSB of n is flipped to 0 ( it's nothing just a anding operation
        // 1 & 0 = 0 , 1 & 1 = 1) now why n-1 not n - 2 because u will get correct count 0f 1 value , when just LSB of n containing 1 is flipped to 0, so taking out 1 from n,
        // and incrementing the result stating there was 1 in that binary series of n

        // Now u need to do the above operation until the entire binary series is 0, and get the count in process of doing so,
        // this count will give number of 1 bit a series has.
        int result = 0;
        while(n!= 0) {
            n = n & n-1;
            result++;
        }
        return result;
    }



    /** ANOTHER APPROACH*/

    // you need to treat n as an unsigned value
    public static int hammingWeight2(int n) {

        int helper = 1;
        // This is a helper variable which will be shifted to left using bitwise << , at every iteration of binary representation of n,
        // the idea behind this is for eg., n is 4 the binary rep of it is 0 1 0 0, now at every iteration we are anding n (binary rep) with
        //growing helper variable , like for the first time helper var helper will be 1, and at the next iter it has to be shifted by a 1 time to left using bit wise left
        // so helper becomes 1 0, (so shifting left by 1 time means adding 0 at the extreme right, so if shifting 2 times means adding 2 0's at the extreme right
        // to the ongoing binary series and so on.

        // So when you and n(binary rep) with helper (which will later become a binary series), we need to say to the below funtion, do this
        // oprn till the entire resultant binary series becomes 0, for eg if n was 4, don't stop until the res series is 0 0 0 0
        // so the principle works like this, at every 1 th position of helper series, check at the same position of n series is it 1 or not,
        // so if both (helper and n ) at the same position is 1 , then the res can never be 0, it can only be 0, when there is a 1 say at posn X
        //in helper series, at the same position X in given n binary series it should be 0.

        // so till there isn't 0 keep on looping and have a counter, this counter will give you number of 1 bit it has

        int result = 0;
        for(int i = 0; i < n; i++) {
            if((n & helper) != 0) {
                result++;
            }
           helper = helper << 1;
        }
        return result;
    }
}
