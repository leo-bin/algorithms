package com.bins.question.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/10 9:53
 * @apiNote 多重背包问题
 * 来源：AcWing
 * 链接：https://www.acwing.com/problem/content/4/
 */
public class BackpackMultiple {

    /**
     * 题目描述：
     * 1.有 N种物品和一个容量是 V的背包
     * 2.第i种物品最多有si件，每件体积是vi，价值是wi
     * 3.求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
     * 4.输出最大价值。
     * <p>
     * 输入格式
     * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积
     * 接下来有N行，每行三个整数vi,wi,si，用空格隔开，分别表示第i种物品的体积、价值和数量
     * <p>
     * 输出格式
     * 输出一个整数，表示最大价值
     * <p>
     * 数据范围
     * 0<N,V≤1000<N,V≤100
     * 0<vi,wi,si≤1000<vi,wi,si≤100
     * <p>
     * 输入样例
     * 4 5
     * 1 2 3
     * 2 4 1
     * 3 4 3
     * 4 5 2
     * <p>
     * 输出样例：
     * 10
     *
     * @apiNote 思路：
     * 1.根据题意，一个物品可能有多件
     * 2.一种比较容易想到的思路就是将此题转换为01背包问题
     * 3.怎么转换呢？
     * 4.既然一个物品有多件，那我们就将多件相同的物品当作不同的物品一同存进w和v数组
     * 5.之后只要更新物品的总数量，现在就和01背包问题一摸一样了
     * 6.我们的dp[i][w]依旧是当取到物品i时，此时的背包容量为w时的最大价值
     * 7.这里还是一个放和不放的问题
     * 8.如果放，此时的dp[i][w]=dp[i-1][w-weights[i-1]]+values[i-1]
     * 9.如果不放，就是dp[i][w]=dp[i-1][w]
     * 10.时间复杂度：O(n*n)
     * 11.空间复杂度：O(n*n)
     */
    public static int backpackMultiple(int n, List<Integer> weights, List<Integer> values, int weight) {
        int[][] dp = new int[n + 1][weight + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= weight; w++) {
                if (w < weights.get(i - 1)) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights.get(i - 1)] + values.get(i - 1));
                }
            }
        }
        return dp[n][weight];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        List<Integer> w = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            w.add(scanner.nextInt());
            v.add(scanner.nextInt());
            s[i] = scanner.nextInt();
        }

        //重新构造物品数组
        for (int i = 0; i < N; i++) {
            int count = s[i] - 1;
            while (count-- > 0) {
                w.add(w.get(i));
                v.add(v.get(i));
            }
        }
        System.out.println(backpackMultiple(w.size(), w, v, V));
    }
}
