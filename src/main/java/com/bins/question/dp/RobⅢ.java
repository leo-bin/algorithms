package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/21 10:10
 * @apiNote 大家劫舍 Ⅲ
 * 来源：leetcode-337
 * 链接：https://leetcode-cn.com/problems/house-robber-iii/
 */
public class RobⅢ {

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
     * 1.在上次打劫完一条街道之后和一圈房屋后
     * 2.小偷又发现了一个新的可行窃的地区
     * 3.这个地区只有一个入口，我们称之为“根”
     * 4.除了“根”之外，每栋房子有且只有一个“父“房子与之相连
     * 5.一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”
     * 6. 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警
     * 7.计算在不触动警报的情况下，小偷一晚能够盗取的最高金额
     * <p>
     * 示例 1:
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * *      3
     * *     / \
     * *    2   3
     * *     \   \
     * *      3   1
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7
     * <p>
     * 示例 2:
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     * *      3
     * *     / \
     * *    4   5
     * *   / \   \
     * *  1   3   1
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9
     *
     * @apiNote 思路：
     * 1.回溯+动态规划
     */
    public static int rob(TreeNode root) {
        int[] result = backtrace(root);
        return Math.max(result[0], result[1]);
    }


    /**
     * 回溯
     *
     * @apiNote 思路：
     * 1.这里二维数组的含义是：
     * 2.arr[0]表示不抢能够得到的最多钱
     * 3.arr[1]表示抢能够得到的最多钱
     */
    public static int[] backtrace(TreeNode root) {
        //1.递归结束条件
        if (root == null) {
            return new int[2];
        }
        //2.左右子树分别递归
        int[] left = backtrace(root.left);
        int[] right = backtrace(root.right);
        //如果抢了当前的根节点，那么就不能抢当前根节点的左右子树
        int rob = root.data + left[0] + right[0];
        //不抢当前的根节点，那就只要找左右子树中能够抢到的最多钱就行
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{notRob, rob};
    }

    public static void main(String[] args) {

    }
}
