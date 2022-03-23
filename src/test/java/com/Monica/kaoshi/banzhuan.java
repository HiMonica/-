package com.Monica.kaoshi;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

public class banzhuan {

    public static int[] test(int t,int[][] data){
        if (t == 0){
            return null;
        }
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int n = data[i][0];
            int x = data[i][1];
            int y = data[i][2];
            int day = (n % (x * y) == 0) ? n / (x * y) : n / (x * y) + 1;
            result[i] = day;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] data = new int[t][3];
        for (int i = 0; i < t; i++) {
            data[i][0] = scanner.nextInt();
            data[i][1] = scanner.nextInt();
            data[i][2] = scanner.nextInt();
        }
        int[] test = test(t, data);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
