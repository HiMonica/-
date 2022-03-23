package com.Monica.Sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        int[] ints = quickSort(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }



    public static int[] quickSort(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }
        int right = nums.length - 1;
        int left = 0;
        sort(nums,left,right);
        return nums;
    }

    public static void sort(int[] nums,int left,int right){
        if (left > right){
            return;
        }
        //一个标准值，取最左边的为标准值
        int num = nums[left];
        //两个哨兵
        int l = left;
        int r = right;
        while (l < r){
            if (nums[r] >= num){
                r--;
                continue;
            }
            if (nums[l] <= num){
                l++;
                continue;
            }
            swap(nums,l,r);
        }
        swap(nums,left,r);
        sort(nums,left,r - 1);
        sort(nums,r + 1,right);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
