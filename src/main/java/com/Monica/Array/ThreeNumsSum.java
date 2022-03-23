package com.Monica.Array;

import com.Monica.Sort.QuickSort;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeNumsSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = fuxi(nums);
        System.out.println(JSON.toJSONString(lists));
    }

    /**
     * 复习
     */
    public static List<List<Integer>> fuxi(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return result;
        }
        //先排序
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            //如果第一个就大于0就不需要继续了
            if (nums[i] > 0) break;
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    store.add(nums[i]);
                    store.add(nums[l]);
                    store.add(nums[r]);
                    result.add(new ArrayList<>(store));
                    store.clear();
                    //去重
                    if (l < r && nums[l] == nums[l + 1]) l++;
                    if (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else if (sum < 0){
                    l++;
                }
            }
        }
        return result;
    }












    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> arrList = new ArrayList<>();
        int[] result = QuickSort.quickSort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //如果大于0不需要继续，因为后面的数都是大于0的
            if (result[i] > 0) break;
            //去重
            if (i > 0 && result[i] == result[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = result[i] + result[l] + result[r];
                if (sum == 0) {
                    arrList.add(Arrays.asList(result[i], result[l], result[r]));
                    //去重
                    if (l < r && result[l] == result[l + 1]) l++;
                    if (l < r && result[r] == result[r - 1]) r--;
                    l++;
                    r--;
                }
                if (sum < 0) {
                    l++;
                }
                if (sum > 0) {
                    r--;
                }
            }
        }
        return arrList;
    }
}
