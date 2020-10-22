package me.suren.leetcodearena.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockBuy1 {

    public static void main(String[] args) {
        StockBuy1 s = new StockBuy1();

        int[] a1 = {7,1,5,3,6,4};
        System.out.println("Max profit: " + s.maxProfit(a1));

        int[] a2 = {7,6,4,3,1};
        System.out.println("Max profit: " + s.maxProfit(a2));
    }

    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - buy > profit) {
                profit = prices[i] - buy;
                continue;
            }
            if(prices[i] < buy) {
                buy = prices[i];
            }
        }

        return profit;
    }
}
