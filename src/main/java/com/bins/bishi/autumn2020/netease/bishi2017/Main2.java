package com.bins.bishi.autumn2020.netease.bishi2017;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 10:05
 * @apiNote
 */
public class Main2 {


    /**
     * 暴力回溯(数据量较小的情况下可以过，但是这里需要考虑优化)
     */
    public static void code(String s, String t) {
        char[] chs = s.toCharArray();
        if (backtrace(chs, t, new StringBuilder(), 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    /**
     * 回溯
     */
    public static boolean backtrace(char[] chs, String target, StringBuilder builder, int index) {
        //递归结束条件
        if (builder.length() > chs.length) {
            return false;
        }
        if (builder.toString().equals(target)) {
            return true;
        }
        for (int i = index; i < chs.length; i++) {
            //去重
            if (i > index && chs[i] == chs[i - 1]) {
                continue;
            }
            builder.append(chs[i]);
            if (backtrace(chs, target, builder, i + 1)) {
                return true;
            }
            builder.deleteCharAt(builder.length() - 1);
        }
        return false;
    }

    /**
     * 题目描述：
     * 1.牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒
     * 2.藏宝盒上有一个机关，机关每次会显示两个字符串s和 t
     * 3.根据古老的传说，牛牛需要每次都回答t是否是s的子序列
     * 4.注意，子序列不要求在原字符串中是连续的
     * 5.例如串abc
     * 6.它的子序列就有 {空串, a, b, c, ab, ac, bc, abc}8种
     * <p>
     * 输入描述:
     * 每个输入包含一个测试用例
     * 每个测试用例包含两行长度不超过10的不包含空格的可见 ASCII 字符串
     * <p>
     * 输出描述:
     * 输出一行 “Yes” 或者 “No” 表示结果。
     * <p>
     * 示例1
     * 输入
     * x.nowcoder.com
     * ooo
     * <p>
     * 输出
     * Yes
     *
     * @apiNote 思路：
     * 1.这里考虑用动态规划来优化
     * 2.通过打表可以发现，我们可以设dp[i][j]为当s的长度是i，t的长度是j时，t是否是s的子序列
     * 3.所以就有两种情况：一：s.charAt[i]==t.charAt(j) 或者二：s.charAt[i]==t.charAt(j)
     * 4.对于一来说dp[i][j]=dp[i-1][j-1](和上一个状态保持一致就行)
     * 5.对于二来说dp[i][j]=dp[i-1][j](相当于s往前面移动一个)
     * 6.时间复杂度：O(n*n)
     * 7.空间复杂度：O(n*n)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        //code(s, t);

        //1.定义dp数组
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //2.初始化dp
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = 0;
        }

        dp[0][0] = 0;
        //3.根据状态方程打表
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }
        System.out.println(dp[s.length()][t.length()] == 1 ? "Yes" : "No");
    }
}
