package com.bins.bishi.autumn2020.netease.bishi2017;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 10:05
 * @apiNote
 */
public class Main3 {


    /**
     * 题目描述：
     * 1.一个只包含'A'、'B'和'C'的字符串
     * 2.如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的
     * 3.否则这个字符串就是暗黑的
     * 4.例如：
     * 5.BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
     * 6.AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
     * 7.你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
     * <p>
     * 输入描述:
     * 输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)
     * <p>
     * 输出描述:
     * 输出一个整数表示有多少个暗黑字符串
     * <p>
     * 示例1
     * 输入
     * 2 3
     * <p>
     * 输出
     * 9 21
     *
     * @apiNote 思路：
     * 1.这题本质上是一个dp题，但其实是一个数学题
     * 2.就是根据题意来找规律，来推公式
     * 3.f(n)=2*f(n-1)+f(n-2)
     * 4.注意考虑int溢出的问题
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static long code(int n) {
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 9;
        }
        long prePreN = 3;
        long preN = 9;
        long current;
        for (int i = 3; i <= n; i++) {
            current = 2 * preN + prePreN;
            prePreN = preN;
            preN = current;
        }
        return preN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(code(n));
    }
}
