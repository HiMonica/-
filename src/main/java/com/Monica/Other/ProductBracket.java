package com.Monica.Other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class ProductBracket {

    /**
     * 思路：跟前面有效括号一样，我觉得还是用栈来实现，n是多少就要有多少括号入栈，错误的思路
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getBracket(new char[n*2],0,result);
        return result;
    }

    public void getBracket(char[] current,int n,List<String> result){
        if (n == current.length){
            if (valid(current)){
                result.add(new String(current));
            }
        }else {
            current[n] = '(';
            getBracket(current,n+1,result);
            current[n] = ')';
            getBracket(current,n+1,result);
        }
    }


    /**
     * 校验是否为有效括号
     */
    public boolean valid(char[] current){
        int balance = 0;
        for (char c : current) {
            if (c == '('){
                balance++;
            }else {
                balance--;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        ProductBracket bracket = new ProductBracket();
        List<String> list = bracket.generateParenthesis(3);
        System.out.println(JSON.toJSONString(list));
    }
}
