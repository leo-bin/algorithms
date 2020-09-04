package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/4 15:08
 * @apiNote 二叉树的所有路径
 * 来源：leetcode-257
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        private int data;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 题目描述：
     * 1.给定一个二叉树，返回所有从根节点到叶子节点的路径
     * 2.说明: 叶子节点是指没有子节点的节点
     * <p>
     * 示例:
     * 输入:
     * *    1
     * *  /   \
     * * 2     3
     * *  \
     * *   5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @apiNote 思路：
     * 1.暴力回溯
     */

    private static List<String> results = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return results;
        }
        dfs(root, "");
        return results;
    }

    /**
     * dfs
     */
    public static void dfs(TreeNode root, String current) {
        //递归结束条件
        if (root == null) {
            return;
        }
        current += root.data;
        if (root.left == null && root.right == null) {
            results.add(current);
            return;
        }
        //左右子树分别回溯
        if (root.left != null) {
            dfs(root.left, current + "->");
        }
        if (root.right != null) {
            dfs(root.right, current + "->");
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        List<String> result = binaryTreePaths(root);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
