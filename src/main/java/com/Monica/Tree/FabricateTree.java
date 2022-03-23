package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class FabricateTree {

    //最好是在要用的时候再创建出来
    private Map<Integer,Integer> store;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        store = new HashMap<>();
        for (int i = 0; i < len; i++) {
            store.put(inorder[i], i);
        }
        TreeNode node = myBuildTree(preorder, inorder, 0, len - 1, 0, len - 1);
        return node;
    }

    public TreeNode myBuildTree(int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left,int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        //前序遍历的最开始的就是根节点
        int pre_root = pre_left;
        //在store里面找到这个节点
        int in_root = store.get(preorder[pre_root]);
        //创建根节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        //得到左子树的长度
        int left_tree_size = in_root - in_left;
        root.left = myBuildTree(preorder, inorder, pre_left + 1, pre_left + left_tree_size, in_left, in_root - 1);
        root.right = myBuildTree(preorder, inorder, pre_left + left_tree_size + 1, pre_right, in_root + 1, in_right);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        FabricateTree fabricateTree = new FabricateTree();
        TreeNode node = fabricateTree.buildTree(preorder, inorder);

    }
}
