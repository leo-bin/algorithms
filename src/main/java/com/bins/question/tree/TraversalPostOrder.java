package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/9/29 11:48
 * @apiNote 二叉树的后序遍历
 * 来源：leetcode-145
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class TraversalPostOrder {

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
     * 1.给定一个二叉树，返回它的后序遍历
     * <p>
     * 示例:
     * 输入: [1,null,2,3]
     * *   1
     * *    \
     * *     2
     * *    /
     * *   3
     * <p>
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @apiNote 思路：
     * 1.递归
     */
    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        postorder(root);
        return result;
    }

    /**
     * 递归
     */
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        result.add(root.data);
    }


    /**
     * 解法二，迭代
     *
     * @apiNote 思路：
     * 1.二叉树的后序遍历在使用迭代时的方法不同于前序和中序
     * 2.这里需要使用两个栈来实现后续遍历
     * 3.一个栈用来存储后序遍历的中间结果，另一个栈用来遍历第一个栈的结果
     */
    public static List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //特判
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode current;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            current = stack1.pop();
            if (current != null) {
                stack2.push(current);
                if (current.left != null) {
                    stack1.push(current.left);
                }
                if (current.right != null) {
                    stack1.push(current.right);
                }
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
