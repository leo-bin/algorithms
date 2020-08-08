package com.bins.bishi.autumn2020.netease.bishi2020;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 12:38
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 现在有n个物品，每一个物品都有一个价值，现在想将这些物品分给两个人
     * 要求这两个人每一个人分到的物品的价值总和相同（个数可以不同，总价值相同即可）
     * 剩下的物品就需要扔掉，现在想知道最少需要扔多少价值的物品才能满足要求分给两个人
     * <p>
     * 输入描述:
     * 第一行输入一个整数 T，代表有 T 组测试数据
     * 对于每一组测试数据，一行输入一个整数 n ，代表物品的个数。
     * 接下来 n 个数，a[i] 代表每一个物品的价值
     * 1<= T <= 10
     * 1 <= n <= 15
     * 1 <= a[i] <= 100000
     * <p>
     * 输出描述:
     * 对于每一组测试数据，输出一个答案代表最少需要扔的价值
     * <p>
     * 示例1
     * 输入
     * 1
     * 5
     * 30 60 5 15 30
     * <p>
     * 输出
     * 20
     * 说明
     * 扔掉第三个和第四个物品，然后将第一个物品和第五个物品给第一个人
     * 第二个物品给第二个人，每一个人分到的价值为60
     * 扔掉的价值为20
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int sum = 0;
            for (int number : nums) {
                sum += number;
            }

            for (int j = 0; j < n; j++) {

            }
        }
    }
}
