package org.example.StocksPurchase;

/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

        Find and return the maximum profit you can achieve.



        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.*/


public class BuyAndSellStock2 {

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0; // initially it's set to 0

        for (int i = 1 ; i < prices.length; i++) { // done i = 1 so that it can use i -1 in the condition
            if (prices[i] > prices[i-1]) { // what i am checking on ith day if the price on ith day (selling price)is higher than the previous day(buying price),
                // then the prev days price can be buying price, and today's ith day will be selling price . So subtracting "prices[i] - prices[i-1] "  will get you
                // the profit, keep adding the profit till the loop is done

                int sellingPrice = prices[i] - prices[i-1];
                profit = profit + sellingPrice;
            }
        }
        return profit; // returning total profit
    }
}
