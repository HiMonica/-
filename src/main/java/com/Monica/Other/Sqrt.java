package com.Monica.Other;

/**
 * 根号x
 */
public class Sqrt {
    public static void main(String[] args) {
        int i = mySqrt(99);
        System.out.println(i);
    }

    /**
     * 二分查找
     */
    public static int mySqrt(int x) {
        //两端一个最左边一个最右边
        int left = 0;
        int right = x;
        //一个存储最终值
        int ans = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            //这里是式子y平方<=x
            if ((long) mid * mid <= x){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
