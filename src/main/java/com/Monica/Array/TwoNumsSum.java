package com.Monica.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }

}
