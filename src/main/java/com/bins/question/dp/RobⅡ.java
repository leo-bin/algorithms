package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/21 10:10
 * @apiNote 大家劫舍 Ⅱ
 * 来源：leetcode-213
 * 链接：https://leetcode-cn.com/problems/house-robber-ii/
 */
public class RobⅡ {

    /**
     * 题目描述：
     * 1.你是一个专业的小偷，计划偷窃沿街的房屋
     * 2.每间房内都藏有一定的现金
     * 3.这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的
     * 4.同时，相邻的房屋装有相互连通的防盗系统
     * 5.如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * 6.给定一个代表每个房屋存放金额的非负整数数组
     * 7.计算你在不触动警报装置的情况下，能够偷窃到的最高金额
     * <p>
     * 示例 1:
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * <p>
     * 示例 2:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释:
     * 1.你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）
     * 2.偷窃到的最高金额 = 1 + 3 = 4
     *
     * @apiNote 思路：
     * 1.此题的关键就是决定从哪里开始偷起
     * 2.如果我们从第一家开始偷起，那么就不用考虑最后一家了
     * 3.如果我们不从第一家开始偷起，那就需要考虑最后一家
     * 4.所以题目就变成了，求第一家到倒数第二家求最大值和求第二家到倒数第一家求最大值的问题
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int rob(int[] nums) {
        //特判
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        //求第一种可能
        int[] dp1 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
        }

        //求第二种可能
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
