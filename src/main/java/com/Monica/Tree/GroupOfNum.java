package com.Monica.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总数
 */
public class GroupOfNum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> store = new ArrayDeque<>();
        int len = candidates.length;
        dfs(candidates,len,0,target,store,result);
        return result;
    }

    public void dfs(int[] candidates,int len,int begin,int target,Deque<Integer> store,List<List<Integer>> result){
        if (target < 0){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(store));
            return;
        }
        for (int i = begin; i < len; i++) {
            store.addLast(candidates[i]);
            dfs(candidates,len,i,target - candidates[i],store,result);
            store.removeLast();
        }
    }
}
