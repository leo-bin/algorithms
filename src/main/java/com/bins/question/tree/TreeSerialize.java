package com.bins.question.tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leo-bin
 * @date 2020/4/15 13:28
 * @apiNote 序列化二叉树
 * 来源：leetcode-297
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
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
     * *    1
     * *   / \
     * *  2   3
     * *     / \
     * *    4   5
     * 序列化为:
     * data="[1,2,3,null,null,4,5]"
     *
     * @apiNote 思路：
     * 1.依旧是二叉树的层次遍历
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.append(root.data).append(",");
        while (!queue.isEmpty()) {
            current = queue.poll();
            //左子树
            if (current.left != null) {
                queue.offer(current.left);
                result.append(current.left.data).append(",");
            } else {
                result.append("null,");
            }
            //右子树
            if (current.right != null) {
                queue.offer(current.right);
                result.append(current.right.data).append(",");
            } else {
                result.append("null,");
            }
        }
        return result.toString();
    }


    /**
     * 题目描述：
     * 1.反序列化
     * 2.将一个字符串序列化为一个二叉树
     *
     * @apiNote 思路：
     * 1.还是层次遍历的思想
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static TreeNode deSerialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
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

    /**
     * 序列化，dfs解法
     *
     * @apiNote 思路：
     * 1.dfs+递归
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static String serializeV2(TreeNode root) {
        StringBuilder result = serializeHelper(root, new StringBuilder());
        return result.toString();
    }

    /**
     * dfs
     */
    public static StringBuilder serializeHelper(TreeNode root, StringBuilder builder) {
        //1.递归结束条件
        if (root == null) {
            builder.append("null,");
            return builder;
        } else {
            builder.append(root.data).append(",");
            //2.左右继续递归
            serializeHelper(root.left, builder);
            serializeHelper(root.right, builder);
        }
        return builder;
    }


    /**
     * 反序列化，dfs解法
     *
     * @apiNote 思路：
     * 1.dfs+递归
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static TreeNode deSerializeV2(String data) {
        String[] strs = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strs));
        return deSerializeHelper(list);
    }


    /**
     * dfs
     */
    public static TreeNode deSerializeHelper(LinkedList<String> list) {
        //1.递归结束条件
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        cur.left = deSerializeHelper(list);
        cur.right = deSerializeHelper(list);
        return cur;
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
