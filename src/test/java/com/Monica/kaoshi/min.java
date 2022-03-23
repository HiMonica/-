package com.Monica.kaoshi;

import java.util.Scanner;

public class min {

    static int ans = 0;
    static int[] a = new int[45];

    public static void dfs(int i,int num,int n,int m,int[][] nums){

        if (i >= n){
            ans = Math.max(ans,num);
            return;
        }
        if (nums[i][0] != nums[i][1] && a[nums[i][0]] == 0 && a[nums[i][1]] == 0){
            a[nums[i][0]] = 1;
            a[nums[i][1]] = 1;
            dfs(i+1,num+1,n,m,nums);
            a[nums[i][0]] = 0;
            a[nums[i][1]] = 0;
        }
        dfs(i+1,num,n,m,nums);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        dfs(0,0,n,m,nums);
        System.out.println(ans);
    }
}
