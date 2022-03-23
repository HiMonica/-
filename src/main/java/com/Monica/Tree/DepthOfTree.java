package com.Monica.Tree;

import com.Monica.utils.TreeNode;

/**
 * 二叉树的最大深度
 */
public class DepthOfTree {

    /**
     * 深度优先遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
