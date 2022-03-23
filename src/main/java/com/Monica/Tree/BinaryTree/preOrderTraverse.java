package com.Monica.Tree.BinaryTree;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历
 */
public class preOrderTraverse {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        preorderTraversal(root,store);
        return store;
    }

    public void preorderTraversal(TreeNode root,List<Integer> store){
        if (root == null){
            return;
        }
        store.add(root.val);
        preorderTraversal(root.left,store);
        preorderTraversal(root.right,store);
    }
}
