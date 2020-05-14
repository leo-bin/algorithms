package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/4/9 19:57
 * @apiNote 打家劫舍问题
 */
public class Rob {


    /**
     * 题目描述：
     * 1.你是一个专业的小偷，计划偷窃沿街的房屋
     * 2.每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
     * 3.如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * 4.给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)
     * 偷窃到的最高金额 = 1 + 3 = 4
     * <p>
     * 示例 2:
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12
     *
     * @apiNote 思路：
     * 1.dp
     * 2.dp[0]=0,dp[1]=nums[0],从2开始打表
     * 3.状态方程：dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1])
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static int rob(int[] nums) {
        //鲁棒
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums1 = {2, 7, 9, 3, 1};
        int[] nums2 = {2, 1, 1, 2};
        System.out.println(rob(nums));
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
    }
}
