package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/23 11:28
 * @apiNote 零钱兑换问题 Ⅱ
 * 来源：leetcode-518
 * 链接：https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChangeⅡ {

    /**
     * 题目描述：
     * 1.给定不同面额的硬币和一个总金额
     * 2.写出函数来计算可以凑成总金额的硬币组合数
     * 3.假设每一种面额的硬币有无限个。
     * <p>
     * 示例 1:
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * <p>
     * 示例 2:
     * 输入: amount = 3, coins = [2]
     * 输出: 0
     * 解释: 只用面额2的硬币不能凑成总金额3。
     * <p>
     * 示例 3:
     * 输入: amount = 10, coins = [10]
     * 输出: 1
     * <p>
     * 注意:
     * 0 <= amount (总金额) <= 5000
     * 1 <= coin (硬币面额) <= 5000
     * 硬币种类不超过 500 种
     * 结果符合 32 位符号整数
     *
     * @apiNote 思路：
     * 1.
     */
    public static int coinChange(int n) {

        return 0;
    }

    /**
     * 题目描述：
     * 1.硬币
     * 2.给定数量不限的硬币，币值为25分、10分、5分和1分
     * 3.编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     * <p>
     * 示例1:
     * 输入: n = 5
     * 输出：2
     * 解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * <p>
     * 示例2:
     * 输入: n = 10
     * 输出：4
     * 解释: 有四种方式可以凑成总金额:
     * 10=10
     * 10=5+5
     * 10=5+1+1+1+1+1
     * 10=1+1+1+1+1+1+1+1+1+1
     *
     * @apiNote 思路：
     * 1.dp
     * 2.假设dp[i]为当i等于n时的组合数
     * 3.dp[0]=1
     * 4.dp[i]=dp[i]+dp[i-coin]
     * 5.时间复杂度：O(n*m)
     * 6.空间复杂度：O(n)
     */
    public static int waysToChange(int n) {
        //鲁棒
        if (n <= 0) {
            return 0;
        }
        //硬币集合
        int[] coins = {1, 5, 10, 25};
        //1.定义dp数组
        int[] dp = new int[n + 1];
        //2.初始化dp
        dp[0] = 1;
        //3.根据状态方程打表，这里需要注意遍历的顺序，需要先遍历硬币
        for (int coin : coins) {
            //从硬币数额开始,去掉不合法的情况
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {

    }
}
