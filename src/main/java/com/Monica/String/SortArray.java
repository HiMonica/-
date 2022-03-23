package com.Monica.String;

import java.util.Arrays;

/**
 * 排序
 */
public class SortArray {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        int[] ints = QuickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 快排
     * @param nums
     * @return
     */
    public static int[] QuickSort(int[] nums,int l,int r){
        if (l > r){
            return null;
        }
        int middleNum = nums[l];
        int left = l;
        int right = r;
        while (left != right){
            while (nums[right] >= middleNum && left < right){
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
                left++;
            }
            while (nums[left] <= middleNum && left < right){
                left++;
            }
            if (left < right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = middleNum;
        QuickSort(nums,l,left-1);
        QuickSort(nums,right+1,r);
        return nums;
    }

    /**
     * 堆排序
     */
    public static int[] HeapSort(int[] nums){
        return nums;
    }

}
