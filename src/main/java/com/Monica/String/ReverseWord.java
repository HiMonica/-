package com.Monica.String;

import java.util.Stack;

/**
 * 翻转字符串中的单词
 */
public class ReverseWord {

    /**
     * 思路：既然是翻转想到了先进后出的栈结构，将单词遍历出来入栈，等遍历完了之后，遍历栈，将单词拼接
     * 递归的去实现
     */
    public String reverseWords(String s) {
        Stack<String> store = new Stack<>();
        //先去掉字符串前后的空格
        String trim = s.trim();
        putStore(trim, store);
        StringBuffer result = new StringBuffer();
        int size = store.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1){
                result.append(store.pop());
            }else {
                result.append(store.pop() + " ");
            }
        }
        return result.toString();
    }

    public void putStore(String s,Stack<String> store){
        if (s.length() == 0){
            return;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) != ' '){
            i++;
        }
        String substring = s.substring(0, i);
        store.push(substring);
        s = s.substring(i);
        s = s.trim();
        putStore(s,store);
    }

    public static void main(String[] args) {
        ReverseWord word = new ReverseWord();
        String the_sky_is_blue = word.reverseWords("the sky is blue");
        System.out.println(the_sky_is_blue);
    }
}
