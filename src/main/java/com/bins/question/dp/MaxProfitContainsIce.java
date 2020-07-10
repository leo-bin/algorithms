package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/10 9:59
 * @apiNote 买卖股票的最佳时机并包含冷冻期
 * 来源：leetcode-309
 * 链接：https:m//leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfitContainsIce {

    /**
     * 题目描述：
     * 1.给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格
     * 2.设计一个算法计算出最大利润
     * 3.在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）
     * 4.你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * 5.卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * <p>
     * 示例:
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }


    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
