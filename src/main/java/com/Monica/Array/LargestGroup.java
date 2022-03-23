package com.Monica.Array;

/**
 * 最大子序数组之和
 */
public class LargestGroup {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num,num);
            max = Math.max(max,pre);
        }
        return max;
    }
}
