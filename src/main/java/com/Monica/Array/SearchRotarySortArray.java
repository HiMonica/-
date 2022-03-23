package com.Monica.Array;

/**
 * 搜索旋转排序数组
 */
public class SearchRotarySortArray {

    /**
     * 暴力法
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 最佳：二分查找
     */
    public int search1(int[] nums, int target){
        int length = nums.length;
        if (length == 0){
            return -1;
        }
        if (length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] <= target && target <= nums[length - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
