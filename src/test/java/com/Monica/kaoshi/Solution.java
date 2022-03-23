package com.Monica.kaoshi;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int整型一维数组 整数数组
     * @return int整型
     */
    public int maxSubArrLength (int[] arr) {
        // write code here
        int len = arr.length;
        Set<Integer> store = new HashSet<>();
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0){
                store.remove(arr[i]);
            }
            while (rk + 1 < len && !store.contains(arr[rk + 1])){
                store.add(arr[i]);
                rk++;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,2,2};
        Solution solution = new Solution();
        int length = solution.maxSubArrLength(nums);
    }
}
