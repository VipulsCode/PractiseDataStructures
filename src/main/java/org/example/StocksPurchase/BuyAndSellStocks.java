package org.example.StocksPurchase;

/** You are given an array prices where prices[i] is the price of a given stock on the ith day.
 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to
 sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println("The answer is ");
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        //Input: prices = [7,1,5,3,6,4]

        int minimumCost = prices[0]; // let 1st indexed value be minimum cost value
        //of stock at initial

        int profit = 0; // initially let profit be 0, i don't wan't it to be negative no
        //matter what so i might sell on the same day but not negative
        int sellingCost = 0; // initially let it be Zero

        for (int i = 1; i < prices.length; i++) {

            sellingCost = prices[i] - minimumCost; // i want to sell the stock,
            // i am checking which day is better to sell the stock, and i am monitoring profit, below using selling cost, and selling cost is checked for every day as "i" is incremented.
            profit = Math.max(profit, sellingCost); // now to cal profit and track it

            // before iterating further we need to make sure the min is also tracked,
            //i mean which is minimum in an array
            minimumCost = Math.min(minimumCost, prices[i]); // i want to set the day which is minimal to buy the stock
        }
        return profit;
    }
}
