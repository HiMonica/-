package com.Monica.Other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 最小栈
 */
public class MinStack {

    //维护一个双端队列，因为栈的特性是先进后出，所以双端队列里面哪边进就哪边出来
    private Deque<Integer> stack;
    //维护一个存储最小元素的变量
    private int min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val < min){
            min = val;
        }
        stack.offerFirst(val);
    }

    public void pop() {
        stack.pollFirst();
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            int element = iterator.next();
            if (element < min){
                min = element;
            }
        }
        this.min = min;
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack  = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
