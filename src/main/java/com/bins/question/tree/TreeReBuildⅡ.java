package com.bins.question.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/9/28 21:07
 * @apiNote 从中序和后续遍历顺序构建二叉树
 * 来源：leetcode-106
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class TreeReBuildⅡ {

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
     * 根据一棵树的中序遍历与后序遍历构造二叉树
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     * <p>
     * *     3
     * *    / \
     * *   9  20
     * *     /  \
     * *    15   7
     *
     * @apiNote 思路：
     * 1.根据二叉树的特点加上后续遍历的最后一个元素一定是根节点
     * 2.然后去中序遍历中找根节点然后确定根节点左右子树的情况
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        //特判
        if (postorder.length == 0) {
            return null;
        }
        //确定根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        //递归结束条件
        if (postorder.length == 1) {
            return root;
        }
        //找根节点在中序序列中的位置
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        //分别找左右子树
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex),
                Arrays.copyOfRange(postorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length)
                , Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1));
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                current = queue.poll();
                if (current != null) {
                    System.out.print(current.data + " ");
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
            System.out.println("*****");
        }
    }
}
