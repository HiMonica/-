package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class SearchTree {

    /**
     * 运用队列，存每个节点，然后取节点的左右判断
     * 错误：超时了
     */
//    public boolean isValidBST(TreeNode root) {
//        store.push(root);
//        while (!store.isEmpty()) {
//            TreeNode node = store.pop();
//            if (node.left != null){
//                if (node.left.val >= node.val){
//                    return false;
//                }else {
//                    store.push(root.left);
//                }
//            }
//            if (node.right != null){
//                if (node.right.val < node.val){
//                    return false;
//                }else {
//                    store.push(root.right);
//                }
//            }
//        }
//        return true;
//    }

    /**
     * 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> store = new LinkedList<>();
        double preIndex = -Double.MAX_VALUE;
        while (!store.isEmpty() || root != null) {
            while (root != null) {
                store.push(root);
                root = root.left;
            }
            root = store.pop();
            if (root.val <= preIndex) {
                return false;
            }
            preIndex = root.val;
            root = root.right;
        }
        return true;
    }

}
