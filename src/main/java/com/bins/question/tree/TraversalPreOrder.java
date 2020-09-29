package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/9/29 11:49
 * @apiNote 二叉树的前序遍历
 * 来源：leetcode-144
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class TraversalPreOrder {

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
     * 1.给定一个二叉树，返回它的前序遍历
     * <p>
     * 示例:
     * 输入: [1,null,2,3]
     * *    1
     * *     \
     * *      2
     * *     /
     * *    3
     * <p>
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @apiNote 思路：
     * 1.先用递归解决
     */
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        //特判
        if (root == null) {
            return result;
        }
        preorder(root);
        return result;
    }

    /**
     * 前序遍历
     */
    public static void preorder(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return;
        }
        result.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 解法二，迭代解决
     *
     * @apiNote 思路：
     * 1.递归的本质就是用栈来实现的
     * 2.所以我们索性就用一个栈来模拟递归的过程
     */
    public static List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //特判
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                result.add(current.data);
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
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
        List<Integer> result = preorderTraversalV2(root);
        if (result != null && result.size() > 0) {
            System.out.println(result.toString());
        }
    }
}
