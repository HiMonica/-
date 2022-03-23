package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和I
 */
// TODO: 2022/3/7 没有写对
public class PathOfSumOne {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int dfs = dfs(root, targetSum);
        return dfs == 0;
    }

    public int dfs(TreeNode root, int targetSum){
        if (root == null){
            return targetSum;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            return 0;
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        return targetSum;
    }

}
