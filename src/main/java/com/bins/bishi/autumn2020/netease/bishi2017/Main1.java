package com.bins.bishi.autumn2020.netease.bishi2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 10:05
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易
     * 2.只提供6个每袋和8个每袋的包装(包装不可拆分)
     * 3.可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带
     * 4.如果不能购买恰好n个苹果，小易将不会购买
     * <p>
     * 输入描述:
     * 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
     * <p>
     * 输出描述:
     * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
     * <p>
     * 示例1：
     * 输入
     * 20
     * 输出
     * 3
     *
     * @apiNote 思路：
     * 1.经典的完全背包问题,也可以联想到零钱兑换问题
     * 2.设dp[i]为当需要购买i个苹果时所需要的最少袋数
     * 3.所以dp[i]=Min(dp[i],dp[i-6个包装或者8个包装])
     */
    public static int code(int n) {
        int[] bags = {6, 8};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int bag : bags) {
                if (i >= bag) {
                    dp[i] = Math.min(dp[i], dp[i - bag] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(code(n));
    }
}
