package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/9/19 14:55
 * @apiNote 左叶子节点之和
 * 来源：leetcode-404
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

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
     * 1.计算给定二叉树的所有左叶子之和
     * <p>
     * 示例：
     * *     3
     * *    / \
     * *   9  20
     * *     /  \
     * *    15   7
     * <p>
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @apiNote 思路：
     * 1.递归
     * 2.找叶子节点相加返回结果就行
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return 0;
        }
        return sumHelper(root.left, 0) + sumHelper(root.right, 1);
    }

    /**
     * 根据传过来的不同的参数判断是左还是右
     */
    public static int sumHelper(TreeNode root, int flag) {
        //递归结束条件
        if (root == null) {
            return 0;
        }
        //左叶子节点直接返回结果
        if (root.left == null && root.right == null && flag == 0) {
            return root.data;
        }
        //接着递归
        return sumHelper(root.left, 0) + sumHelper(root.right, 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(sumOfLeftLeaves(root));
    }
}
