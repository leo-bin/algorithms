package com.bins.question.tree;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/15 18:45
 * @apiNote 重建二叉树
 */
public class TreeRebuild {

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
     * 题目描述：重构二叉树
     * 1.输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 2.假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 3.例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @apiNote 思路：
     * 1.使用递归解决
     * 2.
     */
    public static TreeNode reBuildTree(int[] preOrder, int[] inOrder) {
        //鲁棒
        if (preOrder.length == 0) {
            return null;
        }
        int root = preOrder[0];
        TreeNode rootNode = new TreeNode(root);
        //1.递归结束条件
        if (preOrder.length == 1) {
            return rootNode;
        }
        //2.根据根节点的值去中序中找root节点所在的位置
        int rootIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (root == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }
        //3.根据递归条件，确定递归公式
        //确定左子树
        rootNode.left = reBuildTree(Arrays.copyOfRange(preOrder, 1, rootIndex + 1)
                , Arrays.copyOfRange(inOrder, 0, rootIndex + 1));
        //确定右子树
        rootNode.right = reBuildTree(Arrays.copyOfRange(preOrder, rootIndex + 1, preOrder.length)
                , Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length));
        //4.返回root节点
        return rootNode;
    }


    public static void main(String[] args) {

    }
}
