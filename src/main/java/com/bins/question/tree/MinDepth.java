package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/8/21 11:56
 * @apiNote 二叉树的最小深度
 * 来源：leetcode-111
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepth {

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
     * 1.给定一个二叉树，找出其最小深度
     * 2.最小深度是从根节点到最近叶子节点的最短路径上的节点数量
     * 3.说明: 叶子节点是指没有子节点的节点
     * <p>
     * 示例:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * <p>
     * *     3
     * *    / \
     * *   9  20
     * *     /  \
     * *    15   7
     * <p>
     * 返回它的最小深度  2
     *
     * @apiNote 思路：
     * 1.求最大深度的反过程
     * 2.但是考虑到这种情况：1->2
     * 3.也就是说此时只有一个叶子节点时
     */
    public static int minDepth(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
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
        System.out.println(minDepth(root));
    }
}
