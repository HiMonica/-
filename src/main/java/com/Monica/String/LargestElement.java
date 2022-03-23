package com.Monica.String;

/**
 * 数组中的第K个最大元素，基于快排来实现的
 */
public class LargestElement {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums,int k){
        int[] result = quickSort(nums);
        return result[nums.length - k];
    }

    /**
     * 快排，还可以优化，时间太长了，不应该取最左边的为标准值，而是应该随机的取
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        sort(nums,left,right);
        return nums;
    }

    public static void sort(int[] nums,int left,int right){
        if (left > right){
            return;
        }
        int mid = nums[left];
        int l = left;
        int r = right;
        while (l < r){
           if (mid <= nums[r]){
               r--;
               continue;
           }
           if (mid >= nums[l]){
               l++;
               continue;
           }
           swap(nums,l,r);
        }
        swap(nums,left,r);
        sort(nums,left,r - 1);
        sort(nums,r + 1,right);
    }

    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
