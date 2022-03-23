package com.Monica.Tree.BinaryTree;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class inOrderTraverse {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        inorderTraversal(root,store);
        return store;
    }

    public void inorderTraversal(TreeNode root,List<Integer> store){
        if (root == null){
            return;
        }
        inorderTraversal(root.left,store);
        store.add(root.val);
        inorderTraversal(root.right,store);
    }
}
