package com.Monica.Array;

import com.alibaba.fastjson.JSON;

/**
 * 合并两数组
 */
public class MergeTwoArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNum = new int[m + n];
        int i = 0;
        int j = 0;
        int cur = 0;
        while (i < m || j < n){
            if (i == m){
                cur = nums2[j++];
            }else if (j == n){
                cur = nums1[i++];
            }else if (nums1[i] <= nums2[j]){
                cur = nums1[i];
                i++;
            }else if (nums1[i] > nums2[j]){
                cur = nums2[j];
                j++;
            }
            newNum[i + j - 1] = cur;
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = newNum[k];
        }
        System.out.println(JSON.toJSONString(newNum));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
    }
}
