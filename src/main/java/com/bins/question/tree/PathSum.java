package com.bins.question.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/3 21:20
 * @apiNote 路径总和
 * 来源：leetcode-437
 * 链接：https://leetcode-cn.com/problems/path-sum-iii/
 */
public class PathSum {

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
     * 1.给定一个二叉树，它的每个结点都存放着一个整数值
     * 2.找出路径和等于给定数值的路径总数
     * 3.路径不需要从根节点开始，也不需要在叶子节点结束
     * 4.但是路径方向必须是向下的（只能从父节点到子节点）
     * 5.二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
     * <p>
     * 示例：
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * *       10
     * *      /  \
     * *     5   -3
     * *    / \    \
     * *   3   2   11
     * *  / \   \
     * * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * @apiNote 思路：
     * 1.
     */

    private static int count = 0;

    public static int pathSum(TreeNode root, int sum) {
        //使用bfs遍历所有节点进行dfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    dfs(current, 0, sum);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }
        return count;
    }

    /**
     * dfs
     */
    public static void dfs(TreeNode root, int current, int target) {
        //递归结束条件
        if (root == null) {
            return;
        }
        current += root.data;
        if (current == target) {
            count++;
        }
        //左右子树分别进行dfs
        dfs(root.left, current, target);
        dfs(root.right, current, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        int sum = 8;
        System.out.println(pathSum(root, sum));
    }
}
