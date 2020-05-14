package com.bins.question.tree;


/**
 * @author leo-bin
 * @date 2020/5/7 12:20
 * @apiNote 相同的树（看清楚，这里是子树！不是结构！也就是说必须要满足树的定义！）
 * 来源：leetcode-100
 * 链接：https://leetcode-cn.com/problems/same-tree
 */
public class IsSameTree {


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
     * 1.给定两个二叉树，编写一个函数来检验它们是否相同
     * 2.如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
     * <p>
     * 示例 1:
     * 输入:
     * *       1         1
     * *      / \       / \
     * *     2   3     2   3
     * *
     * *   [1,2,3],   [1,2,3]
     * *
     * 输出: true
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * *       1    1
     * *      /      \
     * *     2        2
     * *   [1,2], [1,null,2]
     * <p>
     * 输出: false
     * <p>
     * 示例 3:
     * <p>
     * 输入:
     * *       1         1
     * *      / \       / \
     * *     2   1     1   2
     * *    [1,2,1] [1,1,2]
     * <p>
     * 输出: false
     *
     * @apiNote 思路：
     * 1.递归思想
     * 2.有的时候遇到这种递归的题目尤其是关于树的
     * 3.我们需要将递归体（也就是整体的递归方法）当作一个整体
     * 4.然后一步一步的分开，先是左边判断，然后是右边判断
     * 5.时间复杂度：O()
     * 6.空间复杂度：O()
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //1.递归的结束条件
        //都空说明都是空元素返回true
        if (p == null && q == null) {
            return true;
        }
        //只要其中有一个为空那就false
        if (p == null || q == null) {
            return false;
        }
        //2.提前结束不符合条件的情况
        if (p.data != q.data) {
            return false;
        }
        //3.将递归体当作一个整体继续向下递归（同时往左和同时往右都成了才行）
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;

        TreeNode root2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        root2.left = node3;
        root2.right = node4;
        System.out.println(isSameTree(root, root2));
    }
}
