package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转二叉树
 */
public class ReversalTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
