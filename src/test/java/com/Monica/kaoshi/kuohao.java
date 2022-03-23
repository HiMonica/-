package com.Monica.kaoshi;

import java.util.Scanner;
import java.util.Stack;

/**
 * 合法前缀
 */
public class kuohao {

    public static int length(int n,String str){
        if (n == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')' && !stack.isEmpty()){
                Character pop = stack.pop();
                if (pop == '('){
                    len += 2;
                }else {
                    break;
                }
            }
        }
        if (!stack.isEmpty()){
            int size = stack.size();
            len = len - 2 * size;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int length = length(n, str);
        System.out.println(length);
    }
}
