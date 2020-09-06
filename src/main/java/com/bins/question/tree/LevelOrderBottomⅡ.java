package com.bins.question.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/6 10:59
 * @apiNote 二叉树的层次遍历 Ⅱ
 * 来源：leetcode-107
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottomⅡ {

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
     * 1.给定一个二叉树，返回其节点值自底向上的层次遍历。
     * 2.即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]
     * *     3
     * *    / \
     * *   9  20
     * *     /  \
     * *    15   7
     * 返回其自底向上的层次遍历为：
     * <p>
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @apiNote 思路：
     * 1.依旧是层次遍历的思想，但是这里使用了双向链表的特点，将结果倒叙存储
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        //特判
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> cur = new ArrayList<>();
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    cur.add(current.data);
                }
            }
            result.addFirst(cur);
        }
        return result;
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
        List<List<Integer>> result = levelOrderBottom(root);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
