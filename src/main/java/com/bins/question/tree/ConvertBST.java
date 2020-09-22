package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/9/22 9:58
 * @apiNote 把二叉树转换为累加树
 * 来源：leetcode-538
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {

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
     * 1.给定一个二叉搜索树（Binary Search Tree）
     * 2.把它转换成为累加树（Greater Tree)
     * 3.使得每个节点的值是原来的节点值加上所有大于它的节点值之和
     * <p>
     * 例如：
     * 输入: 原始二叉搜索树:
     * *               5
     * *             /   \
     * *            2     13
     * <p>
     * 输出: 转换为累加树:
     * *              18
     * *             /   \
     * *           20     13
     *
     * @apiNote 思路：
     * 1.看清楚题目给的是一颗二叉搜索树
     * 2.二叉搜索树有一条特性就是中序遍历的结果一定是从小到大有序的
     * 3.所有我们只要先从右子树开始递归，一直递归到最后一个节点（最后一个节点恰好是最大值）
     * 4.然后同时设置一个全局的增量num=0，每次递归到最后一个节点时就加上这个增量，同时更新增量的值
     * 5.然后接着从右子树开始递归
     */
    private static int num = 0;

    public static TreeNode convertBST(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.data = root.data + num;
        num = root.data;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {

    }
}
