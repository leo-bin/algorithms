package com.bins.bishi.autumn2020.beike;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/11 17:32
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述
     * 给出一个正整数序列A_{i}
     * 求一个子区间使得这个区间内的数或起来尽可能的大
     * 或运算指数字按二进制位进行以下运算：
     * 运算规则： 0|0=0,0|1=1,1|0=1,1|1=1
     * 一个序列的子区间指这个序列中连续的一段数字
     * 牛牛并不关心这个最大值是多少，他只关心所有满足条件的子区间里，最短的子区间长度是多少
     * <p>
     * 输入描述:
     * 第一行一个正整数n，代表这个序列的长度。
     * 接下来一行空格分隔的正整数A_{i}用来描述这个序列
     * <p>
     * 输出描述:仅一行一个正整数代表答案
     * <p>
     * 示例1
     * 输入
     * 3
     * 1 2 3
     * <p>
     * 输出
     * 1
     * <p>
     * 说明：
     * 最大值是3，满足条件的子区间为[1:3],[1:2],[3:3]
     * 所以最短的长度为1
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = nums[i - 1];
            for (int j = 1; j <= i; j++) {
                int t = nums[i - 1] | dp[i - 1];
                minLen = 2;
            }
        }
        System.out.println(minLen);
    }
}
