package com.Monica.String;

import java.util.Stack;

/**
 * 字符串相减
 */
public class StringOfSubtraction {
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        String s = subtractionStrings(num1, num2);
        System.out.println(s);
    }

    /**
     * 思路是把字符串相减都转化为大的减小的
     */
    public static String subtractionStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int add = 0;
        boolean change = false;
        if (l1 < l2 || (l1 == l2 && num1.charAt(0) < num2.charAt(0))){
            String num = num1;
            num1 = num2;
            num2 = num;
            change = true;
        }
        l1 = num1.length() - 1;
        l2 = num2.length() - 1;
        Stack<Integer> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        while (l1 >= 0 || l2 >= 0 || add != 0){
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            n1 = n1 - add;
            add = 0;
            if (n1 < n2){
                if ((l1 - 1) >= 0){
                    n1 = n1 + 10;
                    ++add;
                }
            }
            int result = n1 - n2;
            stack.push(result);
            l1--;
            l2--;
        }
        if (stack.peek() == 0){
            stack.pop();
        }
        int size = stack.size();
        if (change){
            stringBuffer.append("-");
        }
        for (int i = 0; i < size; i++) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }
}
