package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/8/7 16:47
 * @apiNote 买卖股票的最佳时机 Ⅲ
 * 来源：leetcode-123
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class MaxProfitⅢ {

    /**
     * 题目描述：
     * 1.给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格
     * 2.设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易
     * 3.注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * <p>
     * 示例 1:
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释:
     * 在第 4 天（股票价格 = 0）的时候买入
     * 在第 6 天（股票价格 = 3）的时候卖出
     * 这笔交易所能获得利润 = 3-0 = 3
     * 随后，在第 7 天（股票价格 = 1）的时候买入
     * 在第 8 天 （股票价格 = 4）的时候卖出
     * 这笔交易所能获得利润 = 4-1 = 3
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释:
     * 在第 1 天（股票价格 = 1）的时候买入
     * 在第 5 天 （股票价格 = 5）的时候卖出,
     * 这笔交易所能获得利润 = 5-1 = 4
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * <p>
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0
     *
     * @apiNote 思路：
     * 1.dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
     * 2.j = 0：什么都不操作
     * 3.j = 1：第 1 次买入一支股票
     * 4.j = 2：第 1 次卖出一支股票
     * 5.j = 3：第 2 次买入一支股票
     * 6.j = 4：第 2 次卖出一支股票
     */
    public static int maxProfit(int[] prices) {
        //特判
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //初始化
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //状态3都还没有发生，因此应该赋值为一个不可能的数
        for (int i = 0; i < len; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }

        // 状态转移只有 2 种情况：
        // 情况 1：什么都不做
        // 情况 2：由上一个状态转移过来
        for (int i = 1; i < len; i++) {
            // j = 0 的值永远是 0
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        // 最大值只发生在不持股的时候，因此来源有3个：j = 0 ,j = 2, j = 4
        return Math.max(0, Math.max(dp[len - 1][2], dp[len - 1][4]));
    }


    /**
     * 状态机的解法
     */
    public static int maxProfitV2(int[] prices) {
        int firstBuyProfit = Integer.MIN_VALUE;
        int firstSaleProfit = Integer.MIN_VALUE;
        int secondBuyProfit = Integer.MIN_VALUE;
        int secondSaleProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //第一次买入时的收益
            firstBuyProfit = Math.max(firstBuyProfit, -prices[i]);
            //第一次卖出时的收益
            firstSaleProfit = Math.max(firstSaleProfit, firstBuyProfit + prices[i]);
            //第二次买入时的收益
            secondBuyProfit = Math.max(secondBuyProfit, firstSaleProfit - prices[i]);
            //第二次卖出时的收益
            secondSaleProfit = Math.max(secondSaleProfit, secondBuyProfit + prices[i]);
        }
        return secondSaleProfit;
    }


    public static void main(String[] args) {

    }
}
