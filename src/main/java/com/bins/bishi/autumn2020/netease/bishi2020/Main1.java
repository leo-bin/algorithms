package com.bins.bishi.autumn2020.netease.bishi2020;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 12:38
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述
     * 牛牛现在有一个包含 n 个正整数的数组 a
     * 牛牛可以将其中的每个数 a[i] 都拆成若干个和为 a[i] 的正整数
     * 牛牛想知道拆后（也可以一个数都不拆）这个数组最多能有多少个素数
     * <p>
     * 输入描述:
     * 第一行一个正整数 n 代表数组长度
     * 第二行 n 个正整数代表 a[i] 的值
     * 1<= n <= 1e6, 1<= a[i] <= 1e9
     * <p>
     * 输出描述:
     * 拆后数组最多的素数个数
     * <p>
     * 示例1
     * 输入
     * 3
     * 1 1 1
     * 输出
     * 0
     * 说明：由于1不能再拆，并且1不是素数，所以拆后最多有0个素数
     * <p>
     * 示例2
     * 输入
     * 3
     * 5 3 7
     * 输出：
     * 6
     * <p>
     * 说明：
     * 3不拆；
     * 5可以拆成{2,3}，变成2个素数；
     * 7可以拆成{2,2,3}，变成3个素数
     * 所以最后拆后数组最多有6个素数
     *
     * @apiNote 思路：
     * 1.暴力+贪心就是干
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        long count = 0;
        for (int i : nums) {
            if (i == 1) {
                continue;
            }
            if (i == 2 || i == 3) {
                count++;
                continue;
            }
            count += i / 2;
        }
        System.out.println(count);
    }
}
