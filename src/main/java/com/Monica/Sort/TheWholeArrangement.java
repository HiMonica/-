package com.Monica.Sort;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 全排列
 */
public class TheWholeArrangement {

    /**
     * 方法一：感觉打印出来不太能理解
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> store = new LinkedList<>();
        if (nums == null || nums.length == 0){
            return store;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backTrack(nums.length,list,store,0);
        return store;
    }

    public void backTrack(int length,List<Integer> list,List<List<Integer>> lists,int first){
        if (first == length){
            lists.add(new ArrayList<>(list));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(list,first,i);
            System.out.println("回溯前：" + JSON.toJSONString(list));
            backTrack(length,list,lists,first + 1);
            Collections.swap(list,first,i);
            System.out.println("回溯后：" + JSON.toJSONString(list));
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3};
        TheWholeArrangement arrangement = new TheWholeArrangement();
        arrangement.permute1(nums);
    }

    /**
     * 方法二
     */
    public List<List<Integer>> permute1(int[] nums){
        int length = nums.length;
        List<List<Integer>> store = new ArrayList<>();
        if (length == 0){
            return store;
        }
        boolean used[] = new boolean[length];
        Deque<Integer> deque = new ArrayDeque<>(length);
        backTrack(nums,length,0,deque,store,used);
        return store;
    }

    public void backTrack(int[] nums,int length,int depth,Deque<Integer> deque,List<List<Integer>> store,boolean[] used){
        //如果深度已经等于长度了，那么说明这个双端队列已经记录了一组数据
        if (depth == length){
            store.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]){
                deque.addLast(nums[i]);
                used[i] = true;
                System.out.println("回溯前：" + JSON.toJSONString(deque));
                backTrack(nums,length,depth + 1,deque,store,used);
                used[i] = false;
                deque.removeLast();
                System.out.println("回溯后：" + JSON.toJSONString(deque));
            }
        }
    }
}
