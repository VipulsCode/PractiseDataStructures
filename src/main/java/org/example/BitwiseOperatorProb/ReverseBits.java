package org.example.BitwiseOperatorProb;

//Reverse bits of a given 32 bits unsigned integer.
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0; // to store the resultant reversed bits, at initially it will be 0, of size 32 bits

        for (int i = 0; i < 32; i++) {

            // the below is least significant bit(right most bit) in 32 bit,it will be 1 (in 32 bit)  i'll be using this to get to know what's the
            // right most bit in n (which is again represented in 32 bit), why am i doing this, is because i need to know the
            // entire bits of n one by one, i.e., extracting from right most bit.

            // how to obtain the right most bit from n --> it can be done by ANDING n & lsb, so as i said lsb will be 1 and then and opern is performed
            // so instead of writing like this
            // int lsb = 1;
            // lsb = n & lsb; --> i wrote the below code

            int lsb = n & 1;

            // now after obtaining the right most bit from n, and placing it in lsb in form of 32 bit, we need to reverse this bit
            // and place it in the same place , the way it was placed in n, but in the opposite direction i.e., for an example
            // if n = 0 0 1 0 --> the reversal of it is 0 1 0 0, -->  so 1 in n was at 2 position from extreme right side, after reversing
            // its on 2nd position again but on opposite dirn i.e., from left side.  like a mirror image

            int reverseLsb = lsb << 31 - i; // why 31 - i, as i said the reversing needs to be done in the same place, so i will take care, and ehy 31 instead of 32,
                                            // as we need to push it to the left from the next position, not the position the bit is.

            // Now you need to store the result and also maintaining the same number what we had received we are Oring the reversalLsb with result, so if it u have received 1 at 2nd
            // position , but 2nd position in result is 0, now if u and the result will be 0, but we need it to be 1, so OR

            res = res | reverseLsb;

            n = n >> 1; // at last you need to omit the right significant bit which is already processed , so shift the n 1 time to right , for eg., n = 0 1 1 0 1, now shifting 1 time to right
                        // will give n  = 0 0 1 1 0, and if it's shifted once again by 1 to right then n = 0 0 0 1 1, so bits won't change, it is 5 bits representation, then it will always be 5 bits


        }
        return res;

    }
}
