package com.bins.question.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/6 11:02
 * @apiNote 二叉树的层次遍历 Ⅰ
 * 来源：leetcode-102
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

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
     * 1.给你一个二叉树，请你返回其按 层序遍历 得到的节点值
     * 2.即逐层地，从左到右访问所有节点
     * <p>
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7]
     * *     3
     * *    / \
     * *   9  20
     * *     /  \
     * *    15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @apiNote 思路 ：
     * 1.我们能够想到一般的二叉树的遍历方法都是递归
     * 2.既然是层次，我们需要逐层进行搜索，这里用到了一个队列的性质：FIFO
     * 3.每一次同时进队列的就代表的是一层的节点
     * 4.我们每次都进行这一层的遍历就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        //特判
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.add(root);
        //开始bfs搜索
        while (!queue.isEmpty()) {
            int width = queue.size();
            List<Integer> cur = new ArrayList<>();
            while (width-- > 0) {
                current = queue.poll();
                if (current != null) {
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                    cur.add(current.data);
                }
            }
            lists.add(cur);
        }
        return lists;
    }


    public static void main(String[] args) {

    }
}
