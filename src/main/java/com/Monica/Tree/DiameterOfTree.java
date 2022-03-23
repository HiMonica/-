package com.Monica.Tree;

import com.Monica.utils.TreeNode;

/**
 * 二叉树的直径
 */
public class DiameterOfTree {

    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        dfs(root);
        return result - 1;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        result = Math.max(result,(L + R + 1));
        return Math.max(L,R) + 1;
    }
}
