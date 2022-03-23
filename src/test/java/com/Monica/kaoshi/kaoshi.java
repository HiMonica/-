package com.Monica.kaoshi;

import java.util.Scanner;

/**
 * 幸运数
 */
public class kaoshi {

    public static void isSuccess(int n,int[] nums){
        for (int i = 0; i < n; i++) {
            if (is11Int(nums[i]) || isDouble1(nums[i])){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

    /**
     * 是否11的整数倍
     */
    public static boolean is11Int(int n){
        if (n % 11 == 0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isDouble1(int n){
        int count = 0;
        while (n % 10 != 0 || n / 10 != 0){
            int m = n % 10;
            n = n / 10;
            if (m == 1){
                count++;
            }
        }
        if (count >= 2){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }
        isSuccess(count,nums);
    }

}
