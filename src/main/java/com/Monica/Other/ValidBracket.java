package com.Monica.Other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效括号
 */
public class ValidBracket {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    /**
     * 栈和map
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //用数组实现
        int len = s.length();
        if (len % 2 != 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //在栈中
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
