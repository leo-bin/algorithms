package com.bins.question.tree;


/**
 * @author leo-bin
 * @date 2020/8/31 11:43
 * @apiNote 二叉树的直径
 * 来源：leetcode-543
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

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
     * 1.给定一棵二叉树，你需要计算它的直径长度
     * 2.一棵二叉树的直径长度是任意两个结点路径长度中的最大值
     * 3.这条路径可能穿过也可能不穿过根结点。
     * <p>
     * 示例 :
     * *          1
     * *         / \
     * *       2   3
     * *     / \
     * *   4   5
     * <p>
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]
     * 注意：两结点之间的路径长度是以它们之间边的数目表示
     *
     * @apiNote 思路：
     * 1.一开始想着直接算根节点的左右子树的最大高度，然后求和就行
     * 2.但是没有考虑到可能最大的路径不会经过根节点，可能它存在于左右子树中
     * 3.所以这里需要搜索所有的节点然后求以当前节点的最大路径
     */
    private static int maxSize = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        //特判
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxSize;
    }

    /**
     * dfs
     */
    public static int dfs(TreeNode root) {
        //递归结束条件
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = root.left == null ? 0 : dfs(root.left) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        //更新最大路径
        maxSize = Math.max(maxSize, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(diameterOfBinaryTree(root));
    }
}
