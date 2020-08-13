package com.bins.bishi.autumn2020.beike;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/11 17:32
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述
     * 牛牛很喜欢字符串，但是相对于字符串，他更喜欢回文字符串
     * 我们定义一个串为回文字符串，当且仅当它从前往后读和从后往前读相同
     * 现在，牛牛想知道，对于任意一个字符串，它至少需要替换多少个字符才能将它变为回文字符串
     * 一次替换操作中，牛牛可以选择任何一个位置的字符，将其变为另一个字符
     * <p>
     * 输入描述:
     * 第一行一个整数N，表示回文串的长度
     * 接下来一行N个小写字母表示字符串
     * <p>
     * 输出描述:输出一个整数表示答案
     * <p>
     * 示例1
     * 输入
     * 5
     * acacb
     * <p>
     * 输出
     * 1
     * 说明：将最后的b变为a即可
     * <p>
     * 示例2
     * 输入
     * 4
     * acac
     * <p>
     * 输出
     * 2
     * <p>
     * 备注:保证字符串中的字符均为小写字母
     *
     * @apiNote 思路：
     * 1.暴力+贪心
     * 2.直接秒了，下一题
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String s = scanner.next();

        int count = 0;
        for (int i = 0, j = N - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
