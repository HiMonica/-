package com.Monica.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 */
public class MajorElement {

    public int majorityElement(int[] nums) {
        if (nums == null){
            return 0;
        }
        int len = nums.length;
        Map<Integer,Integer> store = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (store.containsKey(nums[i])){
                store.put(nums[i],store.get(nums[i]) + 1);
            }else {
                store.put(nums[i],1);
            }
        }
        int compare = len / 2;
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            if (entry.getValue() > compare){
                return entry.getKey();
            }
        }
        return 0;
    }
}
