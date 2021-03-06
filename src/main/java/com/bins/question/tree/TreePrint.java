package com.bins.question.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/4/12 16:27
 * @apiNote 二叉树的层次遍历
 */
public class TreePrint {

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
     * 1.从上到下按层打印二叉树
     * 2.同一层的节点按从左到右的顺序打印，每一层打印到一行
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7]
     * <p>
     * 输出：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @apiNote 思路：
     * 1.采用二叉树的层次遍历的思想，也就是广度优先算法BFS
     * 2.每次循环都将一层的所有元素都入栈，这样子就起到一个循环次数就是数的高度
     * 3.这样做不仅可以统计树的深度，还可以统计数的宽度
     */
    public static List<List<Integer>> printTree(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    //存放每一层中的节点
                    list.add(current.data);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            lists.add(list);
        }
        return lists;
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
        System.out.println("leetcode：");
        List<List<Integer>> lists = printTree(root);
        if (lists != null && lists.size() > 0) {
            System.out.println(lists.toString());
        }
    }
}
