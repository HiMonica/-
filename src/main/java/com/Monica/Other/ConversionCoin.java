package com.Monica.Other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 兑换硬币
 */
public class ConversionCoin {

    private volatile int count = 0;

    /**
     * 思路：贪心算法，硬币最少，先用最大的去匹配，当超过了之后再递归
     */
    // TODO: 2022/3/21 没有写对 
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return count;
        }
        Arrays.sort(coins);
        while (amount != 0){
            if (coins[0] > amount){
                return -1;
            }
            for (int i = coins.length - 1; i >= 0; i--) {
                if (coins[i] <= amount){
                    count += (amount / coins[i]);
                    amount -= (amount / coins[i] * coins[i]);
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ConversionCoin conversionCoin = new ConversionCoin();
        int[] coins = new int[]{186,419,83,408};
        int i = conversionCoin.coinChange(coins, 6249);
        System.out.println(i);
    }
}
