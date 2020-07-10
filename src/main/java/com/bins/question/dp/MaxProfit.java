package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/6/6 19:25
 * @apiNote 买卖股票的最佳时机
 * 来源：leetcode-121
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {

    /**
     * 题目描述：
     * 1.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
     * 2.如果你最多只允许完成一笔交易（即买入和卖出一支股票一次）
     * 3.设计一个算法来计算你所能获取的最大利润
     * 4.你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释:
     * 1.在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出
     * 2.所以最大利润 = 6-1 = 5 。
     * 3.注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格
     * 4.同时，你不能在买入前卖出股票。
     * <p>
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @apiNote 思路：
     * 1.dp思想，唉，一开始想复杂了。。。
     * 2.其实很简单的一个问题，就是让每一天的价格和当前价格的最小值计算就行
     * 3.我们可以边计算边找最小值同时计算此时的最大利益
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrices = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }
}
