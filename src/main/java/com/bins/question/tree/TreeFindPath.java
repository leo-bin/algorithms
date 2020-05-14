package com.bins.question.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/4/24 21:46
 * @apiNote 二叉树中和为某一个值的路径
 */
public class TreeFindPath {


    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();


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
     * 1.输入一颗二叉树的根节点和一个整数
     * 2.打印出二叉树中结点值的和为输入整数的所有路径
     * 3.路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
     * 4.注意: 在返回值的list中，数组长度大的数组靠前
     *
     * @apiNote 思路：
     * 1.回溯
     */
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        //鲁棒
        if (root == null) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backTrace(root, target, 0, track);
        //考虑排序问题
        result.sort((o1, o2) -> o2.size() - o1.size());
        return result;
    }


    /**
     * 回溯
     */
    public static void backTrace(TreeNode root, int target, int current, LinkedList<Integer> track) {
        //记录当前节点
        track.add(root.data);
        //更新current值
        current += root.data;
        //1.递归结束条件
        if (current == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(track));
            return;
        }
        //2.左右子树分别回溯
        if (root.left != null) {
            backTrace(root.left, target, current, track);
            //恢复当前节点
            track.removeLast();
        }
        if (root.right != null) {
            backTrace(root.right, target, current, track);
            //恢复当前节点
            track.removeLast();
        }
    }


    public static void main(String[] args) {

    }
}
