package com.bins.question.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/5/12 20:24
 * @apiNote 按之字形打印树
 */
public class PrintTree {


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
     * 1.请实现一个函数按照之字形打印二叉树
     * 2.即第一行按照从左到右的顺序打印
     * 3.第二层按照从右至左的顺序打印
     * 4.第三行按照从左到右的顺序打印，其他行以此类推
     *
     * @apiNote 思路：
     * 1.二叉树的层次遍历就行
     * 2.唯一需要思考的就是如何按照第一行是从左向右，第二行是从右向左,第三行又是从左向右
     * 3.这个其实也很简单，判断奇偶数就行，从0算是第一层
     * 4.所以偶数层从左向右，奇数层也就是第二层，从右向左
     * 5.时间复杂度：O()
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        //使用队列实现二叉树的层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        //记录二叉树的高度
        int depth = 0;
        TreeNode current;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int width = queue.size();
            ArrayList<Integer> cur = new ArrayList<>();
            while (width > 0) {
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
                width--;
            }
            //奇数层，反转顺序
            if ((depth & 1) == 1) {
                Collections.reverse(cur);
            }
            lists.add(cur);
            depth++;
        }
        return lists;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        ArrayList<ArrayList<Integer>> result = print(root);
        if (result != null && result.size() > 0) {
            System.out.println(result.toString());
        } else {
            System.out.println("树为空");
        }
    }
}
