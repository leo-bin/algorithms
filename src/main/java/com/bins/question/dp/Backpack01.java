package com.bins.question.dp;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 16:59
 * @apiNote 经典dp题之 01背包问题
 * 测试链接： https://www.acwing.com/problem/content/2/
 */
public class Backpack01 {

    /**
     * 题目描述：
     * 1.有 N件物品和一个容量是 V 的背包。每件物品只能使用一次
     * 2.第i 件物品的体积是 vi，价值是 wi
     * 3.求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * 4.输出最大价值。
     * <p>
     * 输入格式
     * 第一行两个整数，N，VN，V，用空格隔开，分别表示物品数量和背包容积
     * 接下来有 NN 行，每行两个整数 vi,wivi,wi，用空格隔开，分别表示第 ii 件物品的体积和价值。
     * <p>
     * 输出格式
     * 输出一个整数，表示最大价值
     * <p>
     * 数据范围
     * 0<N,V≤10000<N,V≤1000
     * 0<vi,wi≤10000<vi,wi≤1000
     * <p>
     * 输入样例:
     * 4 5
     * 1 2
     * 2 4
     * 3 4
     * 4 5
     * 输出样例：
     * 8
     *
     * @apiNote 思路：
     * 1.这道题是dp的经典题，背包问题的初级形态
     * 2.首先我们需要想清楚dp数组的定义
     * 3.在这里其实没有太多的技巧而言，只能一个个试，求最大值
     * 4.我们先考虑二维dp
     * 5.我们可以先遍历所有物品，一个个的放
     * 6.我们在放每一个物品的时候从背包容量为1到weight再次遍历
     * 7.里面遍历的目的就是为考虑到每一个物品在各种可能的容量下所能得出的最大结果
     * 8.所以我们dp定义为：dp[i][w]，表示选择第i个物品时，当背包容量为w时所能取得的最大价值
     * 9.dp[i][w]=Max(dp[i-1][w-weights[i-1]]+values[i-1],dp[i-1][w])
     * 10.时间复杂度：O(n*n)
     * 11.空间复杂度：O(n*n)
     */
    public static int backPack01(int n, int weight, int[] weights, int[] values) {
        //1.定义dp数组
        int[][] dp = new int[n + 1][weight + 1];
        //2.根据状态方程打表
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= weight; w++) {
                if (w - weights[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - weights[i - 1]] + values[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[n][weight];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        System.out.println(backPack01(N, V, w, v));
    }
}
