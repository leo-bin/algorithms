package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/5/21 17:30
 * @apiNote 回文子串的个数
 * 来源：leetcode-647
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class CountSubPalindrome {


    /**
     * 题目描述：
     * 1.给定一个字符串，你的任务是计算这个字符串中有多少个回文子串
     * 2.具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串
     * <p>
     * 示例 1:
     * 输入: "abc"
     * 输出: 3
     * 解释: 三个回文子串: "a", "b", "c".
     * <p>
     * 示例 2:
     * 输入: "aaa"
     * 输出: 6
     * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.
     */
    public static int countSubPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int count = len;
        //1.定义dp方程
        boolean[][] dp = new boolean[len][len];
        //2.初始化dp,单个字符必是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //3.根据状态方程打表
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //如果找到回文字串，那就记录长度和起始位置，并更新maxLen
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
