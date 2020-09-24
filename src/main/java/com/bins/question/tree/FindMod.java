package com.bins.question.tree;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/9/24 8:16
 * @apiNote 二叉搜索树的众数
 * 来源：leetcode-501
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class FindMod {

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
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）
     * 假定 BST 有如下定义：
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * <p>
     * 例如：
     * 给定 BST [1,null,2,2],
     * *    1
     * *     \
     * *      2
     * *     /
     * *    2
     * 返回[2]
     * <p>
     * 提示：如果众数超过1个，不需考虑输出顺序
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     *
     * @apiNote 思路：
     * 1.hash表+暴力
     */
    private static HashMap<Integer, Integer> map = new HashMap<>(16);
    private static int maxCount = 1;

    public static int[] findMode(TreeNode root) {
        //特判
        if (root == null) {
            return new int[0];
        }
        find(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            int count = (int) entry.getValue();
            if (count == maxCount) {
                list.add((int) entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 递归统计个数
     */
    public static void find(TreeNode root) {
        //递归结束条件
        if (root == null) {
            return;
        }
        //统计maxCount
        if (map.containsKey(root.data)) {
            int cur = map.get(root.data) + 1;
            map.put(root.data, cur);
            maxCount = Math.max(maxCount, cur);
        } else {
            map.put(root.data, 1);
        }
        find(root.left);
        find(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.left = node2;
        int[] result = findMode(root);
        System.out.println(Arrays.toString(result));
    }
}
