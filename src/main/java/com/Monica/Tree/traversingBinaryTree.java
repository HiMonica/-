package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class traversingBinaryTree {

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> store = new ArrayList<>();
        if (root == null){
            return store;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加进去
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> nodeList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodeList.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            store.add(nodeList);
        }
        return store;
    }
}
