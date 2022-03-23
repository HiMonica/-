package com.Monica.String;

/**
 * 字符串相加
 */
public class StringOfSum {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer str = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = n1 + n2 + add;
            str.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return str.reverse().toString();
    }
}
