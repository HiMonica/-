package com.Monica.Sort;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = new int[]{-1,0,3,5,9,12};
        int search = search(ints, 9);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                l = mid + 1;
            }
            if (nums[mid] > target){
                r = mid - 1;
            }
        }
        return -1;
    }
}
