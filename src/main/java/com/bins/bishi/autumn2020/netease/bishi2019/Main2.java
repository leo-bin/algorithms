package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/24 10:54
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.小易觉得高数课太无聊了，决定睡觉
     * 2.不过他对课上的一些内容挺感兴趣
     * 3.所以希望你在老师讲到有趣的部分的时候叫醒他一下
     * 4.你知道了小易对一堂课每分钟知识点的感兴趣程度
     * 5.并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次
     * 6.这会使得他在接下来的k分钟内保持清醒
     * 7.你需要选择一种方案最大化小易这堂课听到的知识点分值
     * <p>
     * 输入描述:
     * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
     * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分
     * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒
     * <p>
     * 输出描述:
     * 小易这堂课听到的知识点的最大兴趣值。
     * <p>
     * 输入例子1:
     * 6 3
     * 1 3 5 2 5 4
     * 1 1 0 1 0 0
     * <p>
     * 输出例子1:
     * 16
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(int[] scores, int[] flags, int n, int k) {
        //先找叫醒点
        int max = -1, bestTime = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int cur = 0;
            while (j < k + i && j < n) {
                if (flags[j] == 0) {
                    cur += scores[j];
                }
                j++;
            }
            if (cur > max) {
                max = cur;
                bestTime = i;
            }
        }
        //更新叫醒点范围内的清醒状态
        for (int i = bestTime; i < (bestTime + k) && i < n; i++) {
            flags[i] = 1;
        }
        //从头开始计算分数
        return calculate(scores, flags, n);
    }


    public static int calculate(int[] scores, int[] flags, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (flags[i] == 1) {
                sum += scores[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] scores = new int[n];
        int[] flags = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            flags[i] = scanner.nextInt();
        }
        //叫醒后可以保持一堂课
        if (n <= k) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += scores[i];
            }
            System.out.println(sum);
        }
        System.out.println(code(scores, flags, n, k));
    }
}
