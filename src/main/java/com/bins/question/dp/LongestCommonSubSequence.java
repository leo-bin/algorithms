package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/4/14 18:09
 * @apiNote 最长公共子序列
 */
public class LongestCommonSubSequence {


    /**
     * 题目描述：
     * 1.给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列
     * 2.一个字符串的子序列是指这样一个新的字符串
     * 3.它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串
     * 4.例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列
     * 5.两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列
     * 6.若这两个字符串没有公共子序列，则返回 0
     * <p>
     * 示例 1:
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 示例 2:
     * <p>
     * 示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3
     * 示例 3:
     * <p>
     * 示例3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0
     * <p>
     * 提示:
     * 1 <= text1.length <= 1000
     * 1 <= text2.length <= 1000
     * 输入的字符串只含有小写英文字符
     *
     * @apiNote 思路：
     * 1.dp
     * 2.虽然题目中没有明确说明，dp的状态是怎么样的，但是我们能够推测出状态方程
     * 3.首先，我们在判断的时候，如果遇到不相等的话，那就需要删除当前的字符
     * 4.两个字符串，删哪一个？比较长度就行！删序列最短的就行！
     * 5.什么意思？就是去掉某个字符之后，当前位置的最长的子序列是最大的！
     * 6.dp[0][0-len2+1]=0,dp[0-len1+1][0]
     * 7.状态方程等于：dp[i][j]=max(dp[i][j-1],dp[i-1][j])(这里就是判断当前位置，是删除str1，还是str2中的字符)
     * 8.时间复杂度：O(n*n)
     * 9.空间复杂度：O(n*n)
     */
    public static int longestCommonSubSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        //1.创建dp数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        //2.初始化dp方程
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }
        //3.根据状态方程打表
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abc";
        String str11 = "abc";
        String str22 = "def";
        System.out.println(longestCommonSubSequence(str1, str2));
        System.out.println(longestCommonSubSequence(str11, str22));
    }
}
