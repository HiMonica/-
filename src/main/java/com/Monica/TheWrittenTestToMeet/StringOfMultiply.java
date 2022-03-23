package com.Monica.TheWrittenTestToMeet;

/**
 * 字符串相乘
 */
public class StringOfMultiply {

    /**
     * 想法：转化为整数相乘，然后再将结果转化为字符串（错误）
     * 正确思路：用两数相乘的思路来做
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }
        for (int i = len1 + len2 - 1; i > 0 ; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }
        int index = res[0] == 0 ? 1 : 0;
        StringBuffer result = new StringBuffer();
        for (int i = index; i < len1 + len2; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }

}
