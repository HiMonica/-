package com.Monica.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {

    /**
     * 方法一：动态规划
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int[] bp = new int[length];
        bp[0] = 1;
        int count = 1;
        for (int i = 1; i < length; i++) {
            bp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    bp[i] = Math.max(bp[i],bp[j] + 1);
                }
                count = Math.max(count,bp[i]);
            }
        }
        return count;
    }

    /**
     * 方法二：贪心+二分查找
     */
    public int lengthOfLIS1(int[] nums){
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int[] tails = new int[length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] nums = new int[]{0,1,0,3,2,3};
        int length = subsequence.lengthOfLIS1(nums);
        System.out.println(length);
    }
}
