package com.bins.bishi.alibaba;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/1 15:58
 * @apiNote
 */
public class Main {


    /**
     * 题目描述：
     * 1.小强很喜欢二进制的串，现在给你一个二进制串，可以翻转若干次，翻转规则如下:
     * 2.你可以选择任一个位置将这位进行翻转，同时他的左面和右面相邻的个位置也进行翻转，翻转是0变成1或者1变成0
     * 3.假设现在一个二进制串为：01010，我们选择在第三个位置翻转，则第二个位置和第四个位置也跟着翻转，所以反转后变成00000
     * 4.若翻转位置在最左侧，则只有右侧相邻元素跟着进行翻转，若翻转位置在最右侧，则只有左侧相邻元素跟着翻转。
     * 5.现在小强给你这个二进制串，他想知道能不能通过翻转，使得这个二进制串的所有位置都是0
     * 6.若可以，请找到最少的操作次数，若不可以输出"NO"
     * <p>
     * 输入描述:
     * 1.第一行输入一个整数，代表有组测试数据。
     * 2.接下来行，每一行一个字符串，保证只有和。
     * <p>
     * 输出描述:
     * 1.对于每一组数据，输出一行，代表最少的操作次数
     * 2.若不可以，输出NO
     * <p>
     * 输入
     * 2
     * 01
     * 011
     * <p>
     * 输出
     * NO
     * 1
     * <p>
     * 说明：
     * 1.对于第二组，我们选择翻转第三个位置
     * 2.由于第三个位置在最右侧，故只有第二个位置跟他一起翻转，所以答案是1
     *
     * @apiNote 思路：
     * 1.
     */
    public static void trunNumber(int n, String[] bins) {
        int count = 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (isAllZero(bins[i])) {
                System.out.println(0);
            }

        }
    }

    public static boolean isAllZero(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == '0')) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] bins = new String[n];
        for (int i = 0; i < n; i++) {
            bins[i] = scanner.next();
        }
        trunNumber(n, bins);
    }
}
