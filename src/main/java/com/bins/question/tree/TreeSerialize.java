package com.bins.question.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/4/15 13:28
 * @apiNote 序列化二叉树
 * 实现两个函数，分别用来序列化和反序列化二叉树
 */
public class TreeSerialize {


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
     * 1.序列化二叉树
     * <p>
     * 示例:
     * 你可以将以下二叉树：
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 序列化为:
     * data="[1,2,3,null,null,4,5]"
     *
     * @apiNote 思路：
     * 1.依旧是二叉树的层次遍历
     * 2.
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.append("[").append(root.data + ",");
        while (!queue.isEmpty()) {
            current = queue.poll();
            //左子树
            if (current.left != null) {
                queue.offer(current.left);
                result.append(current.left.data + ",");
            } else {
                result.append("null,");
            }
            //右子树
            if (current.right != null) {
                queue.offer(current.right);
                result.append(current.right.data + ",");
            } else {
                result.append("null,");
            }
        }
        result.deleteCharAt(result.length() - 1);
        result.append("]");
        return result.toString();
    }


    /**
     * 题目描述：
     * 1.反序列化
     * 2.将一个字符串序列化为一个二叉树
     *
     * @apiNote 思路：
     * 1.还是层次遍历的思想
     */
    public static TreeNode deSerialize(String data) {
        int len = data.length();
        if (len == 0) {
            return null;
        }
        String[] strs = data.replace("[", "").replace("]", "").split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        //节点个数统计
        int count = 1;
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (!"null".equals(strs[count])) {
                current.left = new TreeNode(Integer.valueOf(strs[count]));
                queue.offer(current.left);
            }
            count++;
            if (!"null".equals(strs[count])) {
                current.right = new TreeNode(Integer.valueOf(strs[count]));
                queue.offer(current.right);
            }
            count++;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        String data = serialize(root);
        System.out.println(data);
    }
}
