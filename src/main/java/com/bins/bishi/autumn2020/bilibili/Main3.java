package com.bins.bishi.autumn2020.bilibili;


import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/13 18:22
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 1.面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币
     * 2.现在小Y使用1024元的纸币购买了一件价值为N(0<N≤1024)的商品
     * 3.请问最少他会收到多少硬币
     * <p>
     * 示例1
     * 输入
     * 200
     * <p>
     * 输出
     * 17
     * 说明:12个64元硬币，3个16元硬币，2个4元硬币
     *
     * @apiNote 思路：
     * 1.完全背包问题
     * 2.可以使用一维dp来解决
     */
    public static int code(int N) {
        int[] coins = {1, 4, 16, 64};
        int[] dp = new int[1024 - N + 1];
        Arrays.fill(dp, dp.length + 1);
        dp[0] = 0;
        for (int i = 1; i <= dp.length - 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        int N = 200;
        System.out.println(code(N));
    }
}
