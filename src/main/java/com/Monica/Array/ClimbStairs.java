package com.Monica.Array;

/**
 * 爬楼梯
 */
public class ClimbStairs {

    /**
     * 动态规划：动态规划方程是dp[n] = dp[n - 1] + dp[n - 2]
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
