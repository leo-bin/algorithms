package com.bins.question.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/30 16:01
 * @apiNote 二叉搜索树的插入操作
 * 来源：leetcode-701
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {

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
     * 1.给定二叉搜索树（BST）的根节点和要插入树中的值
     * 2.将值插入二叉搜索树
     * 3.返回插入后二叉搜索树的根节点
     * 4.输入数据保证，新值和原始二叉搜索树中的任意节点值都不同
     * 5.注意，可能存在多种有效的插入方式
     * 6.只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果
     * <p>
     * 例如
     * 给定二叉搜索树:
     * *      4
     * *     / \
     * *    2   7
     * *   / \
     * *  1   3
     * 和插入的值: 5
     * 你可以返回这个二叉搜索树:
     * *          4
     * *        /   \
     * *       2     7
     * *      / \   /
     * *    1   3 5
     * <p>
     * 或者这个树也是有效的:
     * *          5
     * *        /   \
     * *       2     7
     * *      / \
     * *     1   3
     * *          \
     * *           4
     *
     * @apiNote 思路：
     * 1.类似于二分法，不断比较当前的节点，决定是往左边还是右边走
     * 2.
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        //递归结束条件
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.data > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        TreeNode result = insertIntoBST(root, 5);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(result);
        TreeNode current;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    System.out.print(current.data + " ");
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            System.out.println("----");
        }
    }
}
