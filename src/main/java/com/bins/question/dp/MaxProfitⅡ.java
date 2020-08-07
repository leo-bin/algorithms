package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/10 10:23
 * @apiNote 买卖股票的最佳时机Ⅱ
 * 来源：leetcode-122
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfitⅡ {

    /**
     * 题目描述：
     * 1.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
     * 2.设计一个算法来计算你所能获取的最大利润
     * 3.你可以尽可能地完成更多的交易（多次买卖一支股票）
     * 4.注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * <p>
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释:在第2天（股票价格=1）的时候买入，在第3天（股票价格=5）的时候卖出,这笔交易所能获得利润=5-1=4
     * 随后,在第4天（股票价格=3）的时候买入，在第5天（股票价格=6）的时候卖出,这笔交易所能获得利润=6-3=3
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票
     * <p>
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
     * <p>
     * 提示：
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i] <= 10 ^ 4
     *
     * @apiNote 思路：
     * 1.贪心
     * 2.观察几个测试用例我们可以知道以及题目给出的潜台词
     * 3.我们只要在买之前卖出某天的股票就行，比如说我第一天买了1，第二天卖了2，但是我可以在卖出2的时候就马上买回2
     * 4.所以整个流程其实变成了一个求递增区间之和的问题
     * 5.所以我们的策略就是遇到递增的，就将递增值加上总和就行
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - prices[i - 1];
            max = currentProfit > 0 ? currentProfit + max : max;
        }
        return max;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.说实话，这一题我是真没想到上面个那个贪心，我完全被给出的几个测试用例带懵了
     * 2.所以一直以为一天只能干一件事情，要么买，要么卖
     * 3.其实如果没有上面这种解法，这个题目其实非常的棘手
     * 4.我们可以用二维dp来解
     * 5.假设dp[i][0]为第i天的最大收益
     * 6.dp[i][1]是第i天买入的股票所消费的最小值
     * 7.状态转移方程就是要么是买入股票，要么是卖出股票
     * 8.而我们要做的，就是保证每次卖出的股票是最多的，买入的股票是最小的
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(n*n)
     */
    public static int maxProfitV2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //第一天的收益
        dp[0][0] = 0;
        //第一天的消费
        dp[0][1] = -prices[0];
        //从第二天开始
        for (int i = 1; i < prices.length; i++) {
            //求此时的最大收益（卖还是不卖）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //求此时的最小消费（买还是不买）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


    /**
     * 解法三
     *
     * @apiNote 思路：
     * 1.一般的dp我们都可以使用滚动数组来进行空间上的优化
     * 2.这里也不例外，设两个变量记录下上一笔订单的最大收益和买入股票的最小消费就行
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int maxProfitV3(int[] prices) {
        //特判
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int preProfit = 0;
        int preCost = -prices[0];
        int minCost;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(preProfit, preCost + prices[i]);
            minCost = Math.max(preCost, preProfit - prices[i]);
            //更新状态
            preProfit = maxProfit;
            preCost = minCost;
        }
        return maxProfit;
    }


    public static void main(String[] args) {

    }
}
