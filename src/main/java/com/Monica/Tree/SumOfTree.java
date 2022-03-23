package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶节点数字之和
 */
public class SumOfTree {

    /**
     * 思路1：深度优先遍历，把每个数存起来
     */
    public int sumNumbers(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        int sum = 0;
        int result = 0;
        traverseTree(root,sum,store);
        for (Integer integer : store) {
            result += integer;
        }
        return result;
    }

    public void traverseTree(TreeNode root, int sum, List<Integer> store){
        if (root == null){
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            store.add(sum);
            return;
        }
        traverseTree(root.left,sum,store);
        traverseTree(root.right,sum,store);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        SumOfTree tree = new SumOfTree();
        int i = tree.sumNumbers(node1);
        System.out.println(i);
    }


}
