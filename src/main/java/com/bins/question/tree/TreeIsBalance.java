package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/4/16 10:48
 * @apiNote 判断一棵二叉树是否是平衡二叉树
 */
public class TreeIsBalance {


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
     * 1.输入一棵二叉树，判断该二叉树是否是平衡二叉树
     * 2.平衡二叉树就是要求左子树和右子树的高度只差的绝对值小于等于1
     * 3.并且，左子树和右子树也是平衡二叉树
     *
     * @apiNote 思路：
     * 1.根据题意，很明显，我们需要不断的递归判断某个节点的左右子树是不是平衡二叉树
     * 2.并且还要满足当前节点的左右子树的高度差不超过1
     * 3.但是这样会造成太多的重复计算
     * 4.我们其实在判断左右子树的时候就已经遍历过所有的节点了
     * 5.如果继续递归判断左右子树是否为平衡二叉树的话，相当于又重复的遍历了所有节点
     */
    public static boolean isBalancedTree(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return true;
        }
        //2.求左右子树的高度
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        //3.判断左右子树是否也能满足平衡二叉树
        return Math.abs(left - right) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right);
    }


    /**
     * 求子树的最大高度
     */
    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    /**
     * 题目描述：
     * 1.解法二，剪纸版递归
     *
     * @apiNote 思路：
     * 1.我们可以在求深度的同时，判断当前子树是否满足平衡二叉树
     * 2.满足的话，我们就返回高度
     * 3.不满足，我们返回-1
     * 4.最后只需要判断下返回值是多少就行
     * 5.如果是-1，说明有不满足条件的子树存在，返回false
     */
    public static boolean isBalancedTreeV2(TreeNode root) {
        return getDepth(root) != -1;
    }

    /**
     * 求深度的同时判断是否满足平衡二叉树的定义
     */
    public static int getDepth(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return 0;
        }
        //2.求左右子树的高度
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        //3.判断高度差的时候同时判断是否满足平衡二叉树
        return Math.abs(left - right) > 1 ? -1 : (Math.max(left, right) + 1);
    }


    public static void main(String[] args) {

    }
}
