package com.bins.question.dp;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 17:00
 * @apiNote 经典dp之 完全背包问题
 * 测试链接：https://www.acwing.com/problem/content/3/
 */
public class BackpackFull {

    /**
     * 题目描述：
     * 1.有 N 种物品和一个容量是 V的背包
     * 2.每种物品都有无限件可用。
     * 3.第i种物品的体积是 vi，价值是 wi
     * 4.求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 5.输出最大价值。
     * <p>
     * 输入格式
     * 第一行两个整数，N，V用空格隔开，分别表示物品种数和背包容积
     * 接下来有 N行，每行两个整数 vi,wi，用空格隔开，分别表示第 i种物品的体积和价值。
     * <p>
     * 输出格式
     * 输出一个整数，表示最大价值
     * <p>
     * 数据范围:
     * 0<N,V≤1000
     * 0<vi,wi≤1000
     * <p>
     * 输入样例:
     * 4 5
     * 1 2
     * 2 4
     * 3 4
     * 4 5
     * <p>
     * 输出样例：
     * 10
     *
     * @apiNote 思路：
     * 1.依旧是dp解法
     * 2.这个题目用一维dp好理解一些
     * 2.
     */
    public static int backPackFull(int n, int weight, int[] weights, int[] values) {
        int[] dp = new int[weight + 1];
        dp[0] = 0;
        for (int w = 1; w <= weight; w++) {
            for (int i = 1; i <= n; i++) {
                if (w - weights[i - 1] >= 0) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[weight];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int weight = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        System.out.println(backPackFull(n, weight, weights, values));
    }
}
