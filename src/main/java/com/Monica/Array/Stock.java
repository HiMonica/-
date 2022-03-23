package com.Monica.Array;

/**
 * 买卖股票的最佳时机
 */
public class Stock {

    /**
     * 一次遍历，动态的存储最小的值和最大的利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            if (prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
