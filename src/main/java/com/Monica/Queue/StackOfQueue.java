package com.Monica.Queue;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackOfQueue {

    private static Stack<Integer> s1 = new Stack();

    private static Stack<Integer> s2 = new Stack();

    //存储队首元素
    private int front;

    public StackOfQueue() {

    }

    public void push(int x) {
        if (s1.isEmpty()){
            front = x;
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        int s = s1.pop();
        front = s1.peek();
        return s;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        StackOfQueue queue = new StackOfQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(JSON.toJSONString(s1));
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
