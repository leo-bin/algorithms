package com.bins.bishi.autumn2020.meituan.bishi2017;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/28 15:16
 * @apiNote
 */
public class Main4 {

    /**
     * 题目描述:
     * 1.给出两个字符串（可能包含空格）
     * 2.找出其中最长的公共连续子串,输出其长度。
     * <p>
     * 输入描述:
     * 输入为两行字符串（可能包含空格），长度均小于等于50.
     * <p>
     * 输出描述:
     * 输出为一个整数，表示最长公共连续子串的长度。
     * <p>
     * 输入例子1:
     * abcde
     * abgde
     * <p>
     * 输出例子1:
     * 2
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int maxLen = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        System.out.println(maxLen);
    }
}
