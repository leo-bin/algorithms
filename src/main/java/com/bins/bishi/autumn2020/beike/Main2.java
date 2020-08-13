package com.bins.bishi.autumn2020.beike;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/11 17:32
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 给你一个N×M 的方格图，现在要求你对其中每个1×1 的小方格进行染色，要求如下：
     * ∙ 每种颜色染色的格子数都是相同的。
     * ∙ 相邻格子染的颜色不同。
     * ∙ 所有格子必须染色。
     * 现在问最少要多少种颜色就可以完成任务
     * <p>
     * 输入描述:
     * 第一行一个正整数T ，代表测试数据组数。
     * 接下来T 行每行两个空格分隔的正整数N,M，代表方格图的行数和列数
     * <p>
     * 输出描述:共T行每行一个整数表示答案
     * <p>
     * 示例1
     * 输入
     * 1
     * 2 2
     * <p>
     * 输出
     * 2
     * <p>
     * 说明：
     * 第一行第一列和第二行第二列的格子染第一种颜色
     * 第二行第一列和第一行第二列的格子染第二种颜色
     *
     * @apiNote 思路：
     * 1.数学问题，贪心
     * 2.只过了10，还有测试用列没想到，先下一题
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            long nm = N * M;
            //特判
            if (nm == 1) {
                System.out.println(1);
                continue;
            }
            if (nm % 2 == 0) {
                System.out.println(2);
                continue;
            }
            if (nm % 3 == 0) {
                System.out.println(3);
                continue;
            }
            if (N == 1 || M == 1) {
                System.out.println(Math.max(N, M));
            } else {
                System.out.println(Math.min(N, M));
            }
        }
    }
}
