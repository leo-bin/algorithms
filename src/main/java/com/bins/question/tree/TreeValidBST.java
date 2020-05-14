package com.bins.question.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/5/5 9:01
 * @apiNote 验证二叉搜索树
 * 来源：leetcode-98
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class TreeValidBST {


    private static long pre = Long.MIN_VALUE;


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
     * 1.给定一个二叉树，判断其是否是一个有效的二叉搜索树
     * 2.假设一个二叉搜索树具有如下特征
     * 3.节点的左子树只包含小于当前节点的数
     * 4.节点的右子树只包含大于当前节点的数
     * 5.所有左子树和右子树自身必须也是二叉搜索树
     * <p>
     * 示例 1:
     * 输入:
     * *   2
     * *  / \
     * * 1   3
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:
     * *     5
     * *    / \
     * *   1   4
     * *  / \
     * * 3   6
     * 输出: false
     * 解释:
     * 1.输入为: [5,1,4,null,null,3,6]
     * 2.根节点的值为 5 ，但是其右子节点值为 4
     *
     * @apiNote 思路：
     * 1.递归
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static boolean isValidBST(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return true;
        }
        boolean leftFlag;
        boolean rightFlag;
        //2.root比左子树小
        if (root.left != null && root.data <= root.left.data) {
            return false;
        }
        //3.root比右子树大
        if (root.right != null && root.data >= root.right.data) {
            return false;
        }
        //4.从左子树开始
        leftFlag = isValidBST(root.left);
        //右子树中的节点比根节点要小
        if (root.data <= pre) {
            return false;
        }
        pre = root.data;
        //从右子树开始
        rightFlag = isValidBST(root.right);
        //4.左右子树都满足返回true
        return leftFlag && rightFlag;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.根据中序遍历的结果是一个递增的序列来判断是否是二叉搜索树
     * 2.所以就是先一次中序遍历将遍历结果存数组
     * 3.然后判断数组是否是升序的
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static boolean isValidBSTV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            //一直找左子树
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //找右子树，找一次就行
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                list.add(currentNode.data);
                currentNode = currentNode.right;
            }
        }
        return isAEC(list);
    }


    /**
     * 判断数组是否是升序的
     */
    public static boolean isAEC(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode root2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        root2.left = node3;
        root2.right = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(isValidBSTV2(root));
        System.out.println(isValidBSTV2(root2));
    }


}
