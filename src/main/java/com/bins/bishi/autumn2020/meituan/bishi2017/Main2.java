package com.bins.bishi.autumn2020.meituan.bishi2017;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/28 11:10
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给你六种面额 1、5、10、20、50、100 元的纸币
     * 2.假设每种币值的数量都足够多
     * 3.编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
     * <p>
     * 输入描述:
     * 输入包括一个整数n(1 ≤ n ≤ 10000)
     * <p>
     * 输出描述:
     * 输出一个整数,表示不同的组合方案数
     * <p>
     * 输入例子1:
     * 1
     * <p>
     * 输出例子1:
     * 1
     *
     * @apiNote 思路：
     * 1.dp中的01背包问题
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] money = {1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        //当i等于0时代表刚好用完某个纸币，那组合数自然就是1
        dp[0] = 1;
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                //之前的组合数+剪掉当前纸币之后的组合数
                dp[i] = dp[i] + dp[i - m];
            }
        }
        System.out.println(dp[n]);
    }
}
