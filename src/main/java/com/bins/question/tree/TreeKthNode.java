package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/4/17 23:02
 * @apiNote 二叉搜索树中第k小的节点
 */
public class TreeKthNode {

    /**
     * 存遍历结果
     */
    private static List<TreeNode> list = new ArrayList<>();


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
     * 1.给定一棵二叉搜索树，请找出其中的第k小的结点
     * 2.例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4
     *
     * @apiNote 思路：
     * 1.解法一，递归版中序遍历，并将临时结果存list中
     * 2.利用二叉搜索树的中序遍历的结果是一个递增的序列
     * 3.所以我们一次中序遍历将结果存list，最后只用去list中找第k小的节点就行
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return pRoot;
        }
        if (k <= 0) {
            return null;
        }
        inOrder(pRoot);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }


    /**
     * 中序遍历
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            //先遍历左子树
            inOrder(node.left);
            //存根节点
            list.add(node);
            //最后遍历右子树
            inOrder(node.right);
        }
    }


    /**
     * 题目描述：
     * 1.解法二，非递归版中序遍历
     *
     * @apiNote 思路：
     * 1.使用栈实现回溯
     */
    public static TreeNode kthNodeV2(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = pRoot;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                count++;
                current = stack.pop();
                //遍历到了第k个节点
                if (count == k) {
                    return current;
                }
                current = current.right;
            }
        }
        //没找到
        return null;
    }


    public static void main(String[] args) {
        int k = 3;
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode result = kthNode(root, k);
        TreeNode result1 = kthNodeV2(root, k);
        if (result1 != null) {
            System.out.println(result.data);
        } else {
            System.out.println("没找到！");
        }
    }
}
