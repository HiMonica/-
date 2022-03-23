package com.Monica.Sort;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 */
public class MergerSort {

    public static void main(String[] args) {
        MergerSort sort = new MergerSort();
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        int[] ints = sort.sortArray(nums);
        System.out.println(JSON.toJSONString(ints));
    }

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        mergerSort(nums,result,0,len - 1);
        return nums;
    }

    public void mergerSort(int[] nums,int[] result,int left,int right){
        if (left < right){
            int mid = (left + right) / 2;
            mergerSort(nums,result,left,mid);
            mergerSort(nums,result,mid + 1,right);
            sort(nums,result,mid,left,right);
        }
    }

    public void sort(int[] nums,int[] result,int mid,int left,int right){
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                result[t++] = nums[i++];
            }else {
                result[t++] = nums[j++];
            }
        }
        //将左边元素全部填充进去
        while (i <= mid){
            result[t++] = nums[i++];
        }
        //将右边元素全部填充进去
        while (j <= right){
            result[t++] = nums[j++];
        }
        t = 0;
        //将result中的元素全部拷贝到原数组中
        while (left <= right){
            nums[left++] = result[t++];
        }
    }
}
