package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/5/7 20:04
 * @apiNote 树的子结构(只要有相同的结构就行)
 * 来源：leetcode-26
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 */
public class IsSubStructure {

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
     * 1.输入两棵二叉树A和B，判断B是不是A的子结构
     * 2.约定空树不是任意一个树的子结构
     * 3.B是A的子结构，即 A中有出现和B相同的结构和节点值
     * <p>
     * 例如:
     * 给定的树 A:
     * *       3
     * *     / \
     * *    4   5
     * *   / \
     * *  1   2
     * 给定的树 B：
     * <p>
     * *    4
     * *   /
     * *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * @apiNote 思路：
     * 1.这里一定要看清楚题目的要求！
     * 2.子结构和子树的区别还是很大的
     * 3.子结构的要求没有那么严格，只要出现相等的结构就行
     * 4.但是子树同时还要求自己的子树也要一摸一样
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        //1.递归结束条件
        if (A == null || B == null) {
            return false;
        }
        //判断当前A，B节点或者当前节点的左子树或者当前节点的右子树是否具有相同的结构
        return subHelper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 判断两个树是否具有相同的结构
     */
    public static boolean subHelper(TreeNode A, TreeNode B) {
        //1.递归结束条件
        //空树是任何树的子结构
        if (B == null) {
            return true;
        }
        //任何树都不是一个空树的子结构
        if (A == null) {
            return false;
        }
        //提前判断不符合的条件
        if (A.data != B.data) {
            return false;
        }
        return subHelper(A.left, B.left) && subHelper(A.right, B.right);
    }


    public static void main(String[] args) {

    }
}
