package com.Monica.Tree;

import com.Monica.utils.TreeNode;

/**
 * 平衡二叉树
 */
public class BalanceDoubleTree {

    /**
     * 自顶向下
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }
}
