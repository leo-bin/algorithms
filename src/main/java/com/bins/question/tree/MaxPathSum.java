package com.bins.question.tree;

/**
 * @author leo-bin
 * @date 2020/6/21 11:40
 * @apiNote 二叉树的最大路径和
 * 来源：leetcode124
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {

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

    private static int max = Integer.MIN_VALUE;

    /**
     * 题目描述：
     * 1.给定一个非空二叉树，返回其最大路径和
     * 2.本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列
     * 3.该路径至少包含一个节点，且不一定经过根节点
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * <p>
     * *       1
     * *      / \
     * *     2   3
     * <p>
     * 输出: 6
     * <p>
     * 示例 2:
     * 输入: [-10,9,20,null,null,15,7]
     * <p>
     * *   -10
     * *   / \
     * *  9  20
     * *    /  \
     * *   15   7
     * <p>
     * 输出: 42
     *
     * @apiNote 思路：
     * 1.dp+回溯
     * 2.有点动态规划的味道了，不过这里是用递归实现的
     * 3.这题需要想明白的是我们可以设置一个全局变量来存储递归过程中产生的最大值
     * 4.然后我们每次递归返回的临时最大值结果可以不是全局最大值
     * 5.我们只需从当前根节点的左右子树中选择一个最大的作为下一阶段的临时最大值就行
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * dfs搜索
     */
    public static int dfs(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return 0;
        }
        //2.找目前节点左右子树的最大值（小于0没有意义，直接用0来代替）
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        //3.求当前子树的最大值并更新全局max
        int curMax = leftMax + rightMax + root.data;
        max = Math.max(curMax, max);
        //4.返回左右子树中最大的
        return root.data + Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {

    }
}
