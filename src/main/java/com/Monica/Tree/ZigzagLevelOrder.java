package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {

    /**
     * 双端队列存放数据
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> store = new ArrayList<>();
        if (root == null){
            return store;
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        //先将头节点放入
        queue.offer(root);
        //false是左边开始放入，true是右边开始放入
        boolean leftOrRight = false;
        while (!queue.isEmpty()){
            //双端队列
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //判断从左到右？
                if (leftOrRight){
                    list.offerFirst(poll.val);
                }else {
                    list.offerLast(poll.val);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            store.add(new LinkedList<>(list));
            leftOrRight = !leftOrRight;
        }
        return store;
    }
}
