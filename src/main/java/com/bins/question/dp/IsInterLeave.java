package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/8/21 12:24
 * @apiNote 交错字符串
 * 来源：leetcode-97
 * 链接：https://leetcode-cn.com/problems/interleaving-string/
 */
public class IsInterLeave {

    /**
     * 题目描述：
     * 1.给定三个字符串 s1, s2, s3
     * 2.验证 s3 是否是由s1和s2交错组成的
     * <p>
     * 示例 1：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出：false
     *
     * @apiNote 思路：
     * 1.dp思想，我们只要套用求不同的路径那题的思想打个表就能理解了
     * 2.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        //特判
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //初始化dp
        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= s2.length() && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        dp[0][0] = true;
        //打表
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
