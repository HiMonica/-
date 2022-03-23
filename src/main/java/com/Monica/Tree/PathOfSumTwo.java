package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.*;

/**
 * 路径总和II
 */
public class PathOfSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<Integer> sums = new ArrayDeque<>();
        dfs(root, targetSum,sums,result);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, Deque<Integer> sums,List<List<Integer>> result){
        if (root == null){
            return;
        }
        sums.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            result.add(new LinkedList<>(sums));
        }
        dfs(root.left,targetSum,sums,result);
        dfs(root.right,targetSum,sums,result);
        sums.pollLast();
    }
}
