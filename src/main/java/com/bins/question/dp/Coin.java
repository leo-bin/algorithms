package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/6 21:34
 * @apiNote 硬币问题
 */
public class Coin {

    /**
     * 题目描述：
     * 1.给定不同面额的硬币 coins 和一个总金额 amount
     * 2.编写一个函数来计算可以凑成总金额所需的最少的硬币个数
     * 3.如果没有任何一种硬币组合能组成总金额，返回 -1
     * <p>
     * 示例 1:
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * <p>
     * 示例 2:
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *
     * @apiNote 思路：
     * 1.dp
     * 2.假设dp[i]为当i为给定的金额时，所需要的最少硬币个数
     * 3.dp[0]=0
     * 4.dp[i]=min(dp[i],dp[i-coin]+1)
     * 5.时间复杂度：O(n*m)
     * 6.空间复杂度：O(n)
     */
    public static int coinChange(int[] coins, int amount) {
        //鲁棒
        if (coins.length == 0) {
            return -1;
        }
        //1.定义dp数组
        int[] dp = new int[amount + 1];
        //2.初始化dp,所有值都是一个不可能的值amount+1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //3.根据状态方程打表
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //当前的金额要大于等于当前的硬币
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //4.最后的数量不能等于之前设置的不可能的数量
        return dp[amount] == amount + 1 ? -1 : dp[amount];
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
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[] coins1 = {2};
        int amount1 = 3;
        int[] coins2 = {1, 2, 5, 6};
        int amount2 = 10;
        int[] coins3 = {1, 3, 5};
        int amount3 = 5;
        int[] coins4 = {1, 2, 5, 10};
        int amount4 = 18;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange(coins1, amount1));
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange(coins3, amount3));
        System.out.println(coinChange(coins4, amount4));
    }
}
