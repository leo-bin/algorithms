package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/9/23 10:06
 * @apiNote 合并二叉树
 * 来源：leetcode-617
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTrees {

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
     * 1.给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时
     * 2.两个二叉树的一些节点便会重叠
     * 3.你需要将他们合并为一个新的二叉树
     * 4.合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值
     * 5.否则不为 NULL 的节点将直接作为新二叉树的节点
     * <p>
     * 示例 1:
     * 输入:
     * *        Tree 1                     Tree 2
     * *           1                         2
     * *          / \                       / \
     * *         3   2                     1   3
     * *        /                           \   \
     * *       5                             4   7
     * 输出:
     * 合并后的树:
     * * 	     3
     * * 	    / \
     * * 	   4   5
     * * 	  / \   \
     * * 	 5   4   7
     * <p>
     * 注意: 合并必须从两个树的根节点开始
     *
     * @apiNote 思路：
     * 1.递归搞定
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //递归结束条件
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode newRoot = new TreeNode(t1.data + t2.data);
        newRoot.left = mergeTrees(t1.left, t2.left);
        newRoot.right = mergeTrees(t1.right, t2.right);
        return newRoot;
    }

    public static void main(String[] args) {

    }
}
