package com.Monica.Array;

import com.alibaba.fastjson.JSON;

/**
 * 在排序数组中查找元素的第一个和最后一个位置，要求时间复杂度是O(logn)
 */
public class Location {

    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        int search = binarySearch(nums, target);
        int[] result = new int[]{-1,-1};
        int i = search;
        int j = search;
        while (i >= 0){
            if (nums[i] == target){
                result[0] = i;
                i--;
            }else {
                break;
            }
        }
        while (j >= 0 && j < nums.length){
            if (nums[j] == target){
                result[1] = j;
                j++;
            }else {
                break;
            }
        }
        return result;
    }

    public int binarySearch(int[] nums,int target){
        int i = 0;
        int j = nums.length - 1;
        int ans = -1;
        while (i <= j){
            int mid = (i + j) / 2;
            if (nums[mid] == target){
                ans = mid;
                return ans;
            }
            if (nums[mid] < target){
                i = mid + 1;
            }
            if (nums[mid] > target){
                j = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Location location = new Location();
        int[] nums = new int[]{1};
        int[] ints = location.searchRange(nums, 1);
        System.out.println(JSON.toJSONString(ints));
    }
}
