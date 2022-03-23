package com.Monica.kaoshi;

import java.util.*;

/**
 * 匹配的括号数量
 */
public class pipeiString {

    public int count(ArrayList<String> arr) {
        // write code here
        int len = arr.size();
        if (len == 0){
            return 0;
        }
        int count = 0;
        //两个栈来实现
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < len; i++) {
            String s = arr.get(i);
            if (s.equals("")){
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '('){
                    stack1.push('(');
                    stack2.push(')');
                }else {
                    if (stack1.isEmpty() || stack2.isEmpty()){
                        flag = false;
                    }else {
                        stack1.pop();
                        stack2.pop();
                    }
                }
            }
            if (flag && stack1.isEmpty() && stack2.empty()){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        pipeiString string = new pipeiString();
        ArrayList<String> list = new ArrayList<String>();
        list.add("(((())))()()");
        list.add(")");
        int count = string.count(list);
        System.out.println(count);
    }

}
