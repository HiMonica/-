package com.Monica.kaoshi;

import java.util.Scanner;

/**
 * 翻转游戏
 */
public class Resver {

    public static int reverse(int n,int[] nums){
        int ans = 0;
        int tot;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = nums[j];
            }
            for (int j = i; j < n; j++) {
                //翻转
                tot = 0;
                a[j] = 1 - a[j];
                for (int k = 0; k < n; k++) {
                    if (a[k] == 1){
                        tot++;
                    }
                }
                ans = Math.max(ans,tot);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int reverse = reverse(n, nums);
        System.out.println(reverse);
    }
}
