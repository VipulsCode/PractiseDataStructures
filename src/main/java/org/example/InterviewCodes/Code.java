package org.example.InterviewCodes;

public class Code {
    public static String addLargeString(String s1, String s2) {
        StringBuilder sbRes = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int data1 = 0;
            if (i >= 0) {
                data1 = Character.getNumericValue(s1.charAt(i));
            }
            int data2 = 0;
            if (j >= 0) {
                data2 = Character.getNumericValue(s1.charAt(j));
            }
            int sum1 = data1 + data2 + carry;

            carry = sum1 / 10;

            int sum2 = sum1 % 10;
            sbRes.insert(0, sum2);
            i--;
            j--;
        }
        return sbRes.toString();

    }
    public static void main(String[] args) {
        String str1 = "999999999";
        String str2 = "999999";
        System.out.println(addLargeString(str1, str2));

        int[] pricesArray = {5, 10, 15, 2, 3, 4, 5};

        System.out.println("The profit is  " + maxProfit(pricesArray));

    }

    public static int maxProfit(int[] pricesArray) {
        int minCost = pricesArray[0];
        int profit = 0;
        int sellingPrice = 0;

        for (int i = 1; i < pricesArray.length; i++) {
            sellingPrice = pricesArray[i] - minCost;

            profit = Math.max(profit, sellingPrice);

            minCost = Math.min(pricesArray[i], minCost);
        }
        return profit;
    }
}
