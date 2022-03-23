package com.Monica.kaoshi;

import java.util.Scanner;

public class Game {

    public static int game(int n,int m,int[] nums){
        int[] r = new int[15];
        //默认开始在一号房间
        int f = 0;
        int f1 = 1;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (f1 == 1){
                if (nums[i] == 1){
                    ans++;
                    r[1] = 1;
                    f1 = 0;
                }
                continue;
            }
            f = 0;
            r[nums[i]] = 1;
            for (int j = 1; j <= n; j++) {
                if (r[j] == 0){
                    f = 1;
                    break;
                }
            }
            if (f == 0){
                ans++;
                for (int j = 0; j < 15; j++) {
                    r[i] = 0;
                }
                r[nums[i]] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = s.nextInt();
        }
        int game = game(n, m, nums);
        System.out.println(game);
    }
}
