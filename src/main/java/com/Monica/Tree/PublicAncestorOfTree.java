package com.Monica.Tree;

import com.Monica.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 */
public class PublicAncestorOfTree {

    //存储父节点
    private static Map<Integer,TreeNode> store = new HashMap<>();

    //存储查找到的父节点的值，然后第二个节地来判断存储的里面是否有跟自己一样的值
    private static Set<Integer> set = new HashSet<>();

    /**
     * 广度优先遍历，将每个节点的父节地存储起来
     * @param root
     */
    public void dfs(TreeNode root){
        if (root.left != null){
            store.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null){
            store.put(root.right.val,root);
            dfs(root.right);
        }
    }

    /**
     * 通过存储来实现
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null){
            set.add(p.val);
            //获取p的父节点
            p = store.get(p.val);
        }
        while (q != null){
            if (set.contains(q.val)){
                return q;
            }
            q = store.get(q.val);
        }
        return null;
    }



}
