package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/24 10:14
 * @apiNote 二叉树的中序遍历
 * 来源：leetcode-94
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InOrderTraversal {

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
     * 1.给定一个二叉树
     * 2.返回它的中序遍历
     * <p>
     * 示例:
     * 输入: [1,null,2,3]
     * *    1
     * *     \
     * *      2
     * *     /
     * *    3
     * <p>
     * 输出: [1,3,2]
     * <p>
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @apiNote 思路：
     * 1.先尝试递归
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        backtrace(root, result);
        return result;
    }

    /**
     * 回溯
     */
    public static void backtrace(TreeNode root, List<Integer> result) {
        //特判
        if (root == null) {
            return;
        }
        backtrace(root.left, result);
        result.add(root.data);
        backtrace(root.right, result);
    }


    /**
     * 解法二，非递归，迭代解法
     *
     * @apiNote 思路：
     * 1.如何实现递归的？递归不就是用的栈吗？
     * 2.那我们同样也可以使用栈来模拟递归这一遍历的过程
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static List<Integer> inOrderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //特判
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            //从当前节点的左子树开始不断的入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                result.add(current.data);
                current = current.right;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> result1 = inOrderTraversal(root);
        System.out.println(result1.toString());
        List<Integer> result2 = inOrderTraversalV2(root);
        System.out.println(result2.toString());
    }
}
