package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/7/7 20:50
 * @apiNote 路径总和
 * 来源：leetcode-112
 * 链接：https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {


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
     * 1.给定一个二叉树和一个目标和
     * 2.判断该树中是否存在根节点到叶子节点的路径
     * 3.这条路径上所有节点值相加等于目标和
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22
     * <p>
     * *              5
     * *             / \
     * *           4   8
     * *          /   / \
     * *        11  13  4
     * *       /  \      \
     * *      7    2      1
     * <p>
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
     *
     * @apiNote 思路：
     * 1.回溯+暴力
     * 2.时间复杂度：O()
     * 3.空间复杂度：O()
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.data == sum;
        }
        return backtrace(root.left, sum, root.data) || backtrace(root.right, sum, root.data);
    }


    /**
     * 回溯
     */
    public static boolean backtrace(TreeNode root, int target, int current) {
        //递归结束条件
        if (root == null) {
            return false;
        }
        current += root.data;
        if (root.left == null && root.right == null && current == target) {
            return true;
        }
        //左右分别回溯
        return backtrace(root.left, target, current)
                || backtrace(root.right, target, current);
    }


    public static void main(String[] args) {

    }
}
