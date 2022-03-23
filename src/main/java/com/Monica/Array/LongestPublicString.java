package com.Monica.Array;

/**
 * 最长公共子序列
 */
public class LongestPublicString {

    /**
     * 动态规划
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int result[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char x = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char y = text2.charAt(j - 1);
                if (x == y){
                    result[i][j] = result[i - 1][j - 1] + 1;
                }else {
                    result[i][j] = Math.max(result[i - 1][j],result[i][j - 1]);
                }
            }
        }
        return result[m][n];
    }

    /**
     * 自己的思想：这样是错误的，因为我没法保证是否为最长的
     */
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        if (len1 == 0 || len2 == 0){
//            return 0;
//        }
//        //记录上一个找到的数的index在哪个位置
//        int index = 0;
//        int result = 0;
//        for (int i = 0; i < len1; i++) {
//            for (int j = index; j < len2; j++) {
//                //不知道哪个是长的，哪个是短的
//                if (text1.charAt(i) == text2.charAt(j)){
//                    index = j + 1;
//                    result++;
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        LongestPublicString string = new LongestPublicString();
        int i = string.longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }
}
