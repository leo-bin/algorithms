package com.bins.question.tree;


/**
 * @author leo-bin
 * @date 2020/10/13 17:42
 * @apiNote 二叉搜索树的最小绝对差
 * 来源：leetcode-530
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class GetMinimumDifference {

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
     * 1.给你一棵所有节点为非负值的二叉搜索树
     * 2.请你计算树中任意两节点的差的绝对值的最小值
     * <p>
     * 示例：
     * 输入：
     * *    1
     * *     \
     * *      3
     * *     /
     * *    2
     * <p>
     * 输出：
     * 1
     * <p>
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）
     * <p>
     * 提示：
     * 树中至少有 2 个节点
     *
     * @apiNote 思路：
     * 1.一看到给的二叉树是二叉搜索树就知道应该要利用中序遍历的特点了
     * 2.二叉搜索树的中序遍历的顺序是递增的
     * 3.只要根据这个递归的顺序去求每一个节点的差值的绝对值，每次比较大小即可
     */

    private static int min = Integer.MAX_VALUE;
    /**
     * +1000是为了防止变成绝对值之后溢出
     */
    private static int preValue = Integer.MIN_VALUE + 1000;

    public static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    /**
     * 中序遍历，递归实现
     */
    public static void inOrder(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return;
        }
        inOrder(root.left);
        min = Math.min(min, Math.abs(root.data - preValue));
        preValue = root.data;
        inOrder(root.right);
    }


    public static void main(String[] args) {
        System.out.println("min=" + min);
        System.out.println("preValue=" + preValue);
        System.out.println("|0-preValue|=" + Math.abs(0 - preValue));
        System.out.println(Math.min(min, Math.abs(0 - preValue)));
    }
}
