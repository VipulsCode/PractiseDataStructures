package org.example.DynamicProgramming;

/**
 * link : https://www.youtube.com/watch?v=NNcN5X1wsaw // simple way explanation
 *
 *  I have used Tabulation way of solving which is an iterative way not an recursive way
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        int[] minCoinReqDp = new int[amount + 1]; // as we need to get the coin's required for individual target, when we
        // iterate below so the index will include 0 to amount hence total including 0th index is amount + 1;

        minCoinReqDp[0] = 0; // though by default it will be 0, just showing here of better understanding

        for (int i = 1 ; i < minCoinReqDp.length; i++) {
            minCoinReqDp[i] = Integer.MAX_VALUE; // for every ith , the first time every index of minCoinReqDp will be of max value
            // this will useful later ofr check if the amount th index is re initialised or not in minCoinReqDp.

            // main conditions start
            for (int coin : coins) { // iterating for every coin

                if (coin <= i && minCoinReqDp[i] != Integer.MAX_VALUE) {

                    minCoinReqDp[i] = Math.min(minCoinReqDp[i], 1 + minCoinReqDp[i - coin]);

                    // Now what's this line minCoinReqDp[i] = Math.min(minCoinReqDp[i], 1 + minCoinReqDp[i - coin]) , let's break down
                    // minCoinReqDp[i - coin] --> this is nothing at first we are treating every number in the sequence in outer ofr loop is a target/ amount, now we need to find
                    // what will be the coin required to achieve the formed target/amount (here target/amount is every individual ith index), for eg if coins array was [2,3,5]
                    // and our sequence starts from 0, 1, 2, 3, 4, 5 --> 0 is considered ( minCoinReqDp[0]) earlier itself, as in for loop it starts from 1. Now every individual
                    // ith index is taken as target for if 0 is target, how many coins be chosen from the coins array to attain the target, for 0 --> 0 coins chosen, |||ly take 1
                    // as target now the coins which can be chosen from the coins array is again 0, as the coin denomination in coins array starts from 2, then it's 3 and then 4.
                    // so that's the reason why we have put the if condition as " if (coin <= i ....", now consider 2 being the target to achieve this target we can use coin from the coins
                    // array is only 2 , as 3 is bigger denomination than 2. So only 1 coin, here we will be doing dp memorization (it's nothing we will memorize how many coins required to
                    // achieve the framed target in an array, so look up becomes easy

                    // for eg : for i = 4 , and we treat this as the target,  so to achieve 4 as the target we do [i - coin] i.e., for 4 we have two options of coin 2, 3 from coins array
                    // so lets say i chose 2 denomination so [i - coin] 4 - 2 = 2 -->now this answer which we obtained as 2 will be looked in the dp memorization array (in the program its
                    // minCoinReqDp[] array, and it will be checked how many coins were required to get this result , once when it was a target, so it's memorizing those data, so let's say 1 coin
                    // was required of denomination 2 to attain target 2 , so 4 is from "i", now when i do minus 2 , this 2 is one denomination from the coins array, so one coin,
                    // and we just obtained a data from memorization that 1 more coin us required so total coin needed to attain target 4 is 2 coins each of 2 denominations.

                    // now when i had written "1 + minCoinReqDp[i - coin]" this 1 says -> 1 coin + minCoinReqDp[i - coin] --> so the 1 coin be any denomination
                    // and why Math.min(minCoinReqDp[i], 1 + minCoinReqDp[i - coin]); minimum is coz , there might be fore than one ways to attain a target , for eg., 5 can be attained
                    // using denomination 3 like 5- 3 = 2 , now find how many coins are required to attain answer 2 , using dp memorization array, and similarly 5 can be achieved using
                    // the same denomination 5 + 0 = 5 --> so just 1 coin, as the question says we need to find the min denomination for the target val, hence Math.min
                }
            }
        }

        if (minCoinReqDp[amount] == Integer.MAX_VALUE) { // this is to ensure, if the amount/targeted number did not change from Integer.MAX_VALUE, then there wasn't any coin
            //denomination combinations to achieved the said amount/target, hence return -1.
            return -1;
        }

        return minCoinReqDp[amount]; // if not return the minimum denomination obtained to achieve the target
    }
}
