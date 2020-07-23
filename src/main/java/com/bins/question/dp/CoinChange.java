package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/23 11:26
 * @apiNote 零钱兑换 Ⅰ
 * 来源：leetcode-322
 * 链接：https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

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
