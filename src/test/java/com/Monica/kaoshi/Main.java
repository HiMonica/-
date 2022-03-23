package com.Monica.kaoshi;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int validName(int n, String[] str){
        if (n == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = str[i];
            boolean isSuccess = valid(s);
            if (isSuccess){
                count++;
            }
        }
        return count;
    }

    public static boolean valid(String name){
        int len = name.length();
        if (len > 10){
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) < 'a' && name.charAt(i) > 'Z'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int row = sc.nextInt();
        int[][] a = new int[row][2];
        for (int i = 0; i < row; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        int i = blackAndWhite(count, row, a);
        System.out.println(i);
        System.out.println(i);
    }


    public static int blackAndWhite(int count,int row,int[][] a){
        int result = 0;
        //所有棋子默认为false（黑色）
        boolean[] dp = new boolean[count];
        for (int i = 0; i < row; i++) {
            //翻转就变为相反的
            for (int j = a[i][0]; j <= a[i][1]; j++) {
                dp[j] = !dp[j];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]){
                result++;
            }
        }
        return result;
    }
}
