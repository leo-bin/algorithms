package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/5/6 11:34
 * @apiNote 最低票价
 * 来源：leetcode-983
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class MinCostTickets {

    /**
     * 题目描述：
     * 1.在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行
     * 2.在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出
     * 3.每一项是一个从 1 到 365 的整数
     * 4.火车票有三种不同的销售方式
     * 5.一张为期一天的通行证售价为 costs[0] 美元
     * 6.一张为期七天的通行证售价为 costs[1] 美元
     * 7.一张为期三十天的通行证售价为 costs[2] 美元
     * 8.通行证允许数天无限制的旅行
     * 9.例如，如果我们在第2天获得一张为期7天的通行证
     * 10.那么我们可以连着旅行7天：第2天、第3天、第4天、第5天、第6天、第7天和第8天
     * 11.返回你想要完成在给定的列表days中列出的每一天的旅行所需要的最低消费
     * <p>
     * 示例 1：
     * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
     * 输出：11
     * 解释：
     * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
     * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效
     * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效
     * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效
     * 你总共花了 $11，并完成了你计划的每一天旅行
     * <p>
     * 示例 2：
     * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
     * 输出：17
     * 解释：
     * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
     * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效
     * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效
     * 你总共花了 $17，并完成了你计划的每一天旅行
     *
     * @apiNote 思路：
     * 1.dp动态规划
     * 2.我们假设dp[i]为当i等于day[i]中的某个天数时的最小花费
     * 2.dp[0]=0(天数为0花费自然是0)
     * 3.状态方程是：dp[i]=min(dp[max(0,i-1)]+ cost[0],dp[max(0,i-7)]+cost[1],dp[0,i-30]+cost[2])
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static int minCostTickets(int[] days, int[] costs) {
        int len = days.length;
        //dp数组的大小
        int n = days[len - 1];
        //1.定义dp数组
        int[] dp = new int[n + 1];
        //2.初始化dp数组
        for (int i = 0; i < len; i++) {
            //标记旅行的日子
            dp[days[i]] = -1;
        }
        //3.根据状态方程打表
        for (int i = 1; i <= n; i++) {
            //非旅行日，跳过
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                //计算三种不同的花费
                int c1 = dp[Math.max(0, i - 1)] + costs[0];
                int c7 = dp[Math.max(0, i - 7)] + costs[1];
                int c30 = dp[Math.max(0, i - 30)] + costs[2];
                //选择最小的花费
                dp[i] = Math.min(Math.min(c1, c7), c30);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int[] cost = {2, 7, 15};
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        System.out.println(minCostTickets(days,cost));
        System.out.println(minCostTickets(days2,cost));
    }
}
