package com.bins.question.tree;


/**
 * @author leo-bin
 * @date 2020/5/11 10:17
 * @apiNote 对称的二叉树
 * 来源：leetcode-101
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricBST {


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
     * 1.请实现一个函数，用来判断一颗二叉树是不是对称的
     * 2.注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
     *
     * @apiNote 思路：
     * 1.递归
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static boolean isSymmetricBST(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetric(pRoot.left, pRoot.right);
    }


    /**
     * 判断两个节点是否对称，满足的条件:root1.left==root2.right
     */
    public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(isSymmetricBST(root));
    }
}
