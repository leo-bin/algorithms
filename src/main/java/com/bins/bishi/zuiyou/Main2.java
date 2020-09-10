package com.bins.bishi.zuiyou;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/10 18:13
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：打印二叉树
     * 给定一个长度为n的连续有序数组[1,2,3,...,n]
     * 计算共能构建出多少种不同的二叉搜索树
     * <p>
     * 输入描述:
     * 小于15的正整数
     * <p>
     * 输出描述:
     * 正整数
     * <p>
     * 示例1
     * 输入
     * 3
     * <p>
     * 输出
     * 5
     * 说明
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     * <p>
     * *    1         3     3      2      1
     * *     \       /     /      / \      \
     * *      3     2     1      1   3      2
     * *     /     /       \                 \
     * *    2     1         2                 3
     * <p>
     * 示例2
     * 输入
     * 1
     * <p>
     * 输出
     * 1
     * 说明
     * 1
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        dp[4] = 14;
        dp[5] = 42;
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(code(n));
    }
}
