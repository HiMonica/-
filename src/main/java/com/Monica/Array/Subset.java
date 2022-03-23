package com.Monica.Array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class Subset {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> store = new ArrayList<>();

    /**
     * 思路：回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        statistics(0,nums);
        return result;
    }

    public void statistics(int cur,int[] nums){
        if (cur == nums.length){
            result.add(new ArrayList<>(store));
            return;
        }
        store.add(nums[cur]);
        statistics(cur + 1,nums);
        store.remove(store.size() - 1);
        statistics(cur + 1,nums);
    }

    public static void main(String[] args) {
        Subset set = new Subset();
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> subsets = set.subsets(nums);
        System.out.println(JSON.toJSONString(subsets));
    }
}
