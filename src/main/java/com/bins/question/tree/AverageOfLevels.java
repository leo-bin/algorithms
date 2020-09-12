package com.bins.question.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/12 10:49
 * @apiNote 二叉树的层平均值
 * 来源：leetcode-637
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevels {

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
     * 1.给定一个非空二叉树
     * 2.返回一个由每层节点平均值组成的数组
     * <p>
     * 示例 1：
     * 输入：
     * *    3
     * *   / \
     * *  9  20
     * *    /  \
     * *   15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11]
     *
     * @apiNote 思路：
     * 1.没啥特别的，二叉树的层次遍历就行
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        //特判
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            int count = queue.size(), c = queue.size();
            double sum = 0;
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    sum += current.data;
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            result.add(sum / c);
        }
        return result;
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
        List<Double> result = averageOfLevels(root);
        for (Double d : result) {
            System.out.println(d);
        }
    }
}
