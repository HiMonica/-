package com.Monica.java.review;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversingBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> store = new ArrayList<>();
        if (root == null){
            return store;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (root.left != null){
                    queue.offer(root.left);
                }
                if (root.right != null){
                    queue.offer(root.right);
                }
            }
            store.add(list);
        }
        return store;
    }
}
