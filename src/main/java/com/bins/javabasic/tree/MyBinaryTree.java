package com.bins.javabasic.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author leo-bin
 * @date 2020/2/14 20:00
 * @apiNote 一些简单的二叉树的api
 */
public class MyBinaryTree {

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
     * 往二叉树中插入一个数据
     */
    public static TreeNode insert(int data, TreeNode node) {
        //init a node
        if (node == null) {
            node = new TreeNode(data);
        }
        if (data < node.data) {
            node.left = insert(data, node.left);
        } else if (data > node.data) {
            node.right = insert(data, node.right);
        }
        return node;
    }

    /**
     * 前序遍历（递归版）
     */
    public static void preVisit(TreeNode node) {
        if (node != null) {
            //先打印根节点本身
            printData(node);
            //遍历左子树
            preVisit(node.left);
            //遍历右子树
            preVisit(node.right);
        }
    }


    /**
     * 前序遍历（非递归版）
     */
    public static void preVisitV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                //先输出根节点的数据
                printData(current);
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }


    /**
     * 中序遍历
     */
    public static void inVisit(TreeNode node) {
        if (node != null) {
            //先遍历右子树
            inVisit(node.left);
            //打印根节点
            printData(node);
            //最后遍历右子树
            inVisit(node.right);
        }
    }


    /**
     * 中序遍历（非递归）
     */
    public static void inVisitV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                //打印节点数据
                printData(current);
                current = current.right;
            }
        }
    }


    /**
     * 后序遍历
     */
    public static void postVisit(TreeNode node) {
        if (node != null) {
            //在遍历左子树
            postVisit(node.left);
            //先遍历右子树
            postVisit(node.right);
            //最后打印根节点
            printData(node);
        }
    }

    /**
     * 后续遍历（非递归）
     */
    public static void postVisitV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }


    /**
     * 二叉树的层次遍历
     */
    public static void levelOrderTravel(TreeNode root) {
        //鲁棒
        if (root != null) {
            Queue<TreeNode> queue = new ArrayBlockingQueue<>(10);
            //1.根节点直接入队列
            queue.offer(root);
            while (!queue.isEmpty()) {
                //2.每次从队头取节点
                TreeNode current = queue.poll();
                //3.打印
                printData(current);
                //判断当前节点是否有左孩子
                if (current.left != null) {
                    queue.offer(current.left);
                }
                //判断当前节点是否有又孩子
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }


    /**
     * 打印节点中的数据
     */
    public static void printData(TreeNode node) {
        System.out.println(node.data);
    }


    public static void main(String[] args) {
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
        System.out.println("////////////前序遍历/////////////");
        preVisit(root);
        System.out.println("///////////////////////////////");
        preVisitV2(root);
        System.out.println("////////////中序遍历/////////////");
        inVisit(root);
        System.out.println("///////////////////////////////");
        inVisitV2(root);
        System.out.println("////////////后续遍历/////////////");
        postVisit(root);
        System.out.println("///////////////////////////////");

    }
}
