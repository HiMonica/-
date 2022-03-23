package com.Monica.kaoshi;

import java.util.ArrayList;

/**
 * 最长递增子序列
 */
public class longestString {

    public int LSubSequence (int N, ArrayList<Integer> sequence) {
        // write code here
        if (N == 0){
            return 0;
        }
        int dp[] = new int[N];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j)){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
