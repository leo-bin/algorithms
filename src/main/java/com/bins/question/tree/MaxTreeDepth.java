package com.bins.question.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/4/12 14:51
 * @apiNote 二叉树的最大深度
 * 来源：leetcode-104
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxTreeDepth {

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
     * 1.输入一棵二叉树，求该树的深度
     * 2.从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
     *
     * @apiNote 思路：
     * 1.二叉树的先序遍历思想，采用递归
     * 2.时间复杂度：O(logn)
     * 3.空间复杂度：O(1)
     */
    public static int treeDepth(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return 0;
        }
        int leftCount = treeDepth(root.left);
        int rightCount = treeDepth(root.right);
        return Math.max(leftCount, rightCount) + 1;
    }

    /**
     * 解法二：非递归，层次遍历
     *
     * @apiNote 思路：
     * 1.使用栈作为辅助空间
     * 2.每次都将同在一层的节点存在栈中
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int treeDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        TreeNode current;
        queue.offer(root);
        while (!queue.isEmpty()) {
            //统计每一层的节点个数
            int count = 0;
            int width=queue.size();
            while (count++ < width) {
                current = queue.poll();
                if (current != null) {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(treeDepth(root));
    }
}
