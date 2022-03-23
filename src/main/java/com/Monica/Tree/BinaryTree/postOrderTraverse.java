package com.Monica.Tree.BinaryTree;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class postOrderTraverse {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        postorderTraversal(root,store);
        return store;
    }

    public void postorderTraversal(TreeNode root,List<Integer> store){
        if (root == null){
            return;
        }
        postorderTraversal(root.left,store);
        postorderTraversal(root.right,store);
        store.add(root.val);
    }
}
