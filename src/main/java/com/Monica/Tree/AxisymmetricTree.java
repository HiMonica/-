package com.Monica.Tree;

import com.Monica.utils.TreeNode;

/**
 * 对称二叉树
 */
public class AxisymmetricTree {

    /**
     * 思路：怎么算对称呢，就是拆分成两个树，两个树的根结点以及每次遍历到的值都是一样的
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        return node1.val == node2.val && isSymmetric(node1.left,node2.right) && isSymmetric(node1.right,node2.left);
    }
}

