package com.Monica.kaoshi;

public class Max {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 找到数组中乘积最大的连续子数组，并返回乘积
     * @param nums long长整型 一维数组 原始数组
     * @return long长整型
     */
    public long GetSubArrayMaxProduct(long[] nums) {
        // write code here
        long max = nums[0];
        long min = nums[0];
        long ans = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            long mx = max;
            long mn = min;
            max = Math.max(mx * nums[i],Math.max(nums[i],mn * nums[i]));
            min = Math.min(mn * nums[i],Math.min(nums[i],mx * nums[i]));
            ans = Math.max(max,ans);
        }
        return ans;
    }
}
