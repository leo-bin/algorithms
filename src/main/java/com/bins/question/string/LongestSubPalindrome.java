package com.bins.question.string;


/**
 * @author leo-bin
 * @date 2020/3/21 14:38
 * @apiNote 最长回文子串
 * 来源：leetcode-5
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestSubPalindrome {

    /**
     * 题目描述：
     * 1.给定一个字符串 s
     * 2.找到 s 中最长的回文子串。
     * 3.你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @apiNote 思路：
     * 1.暴力枚举
     * 2.将所有可能的情况都列举出来，每列出一种情况，就验证是否是回文串，是的话，保存该字符串的长度
     * 3.下次在和新的回文串的长度进行比较，取最大的。
     * 4.时间复杂度：O(n*n*n)=O(n^3)
     * 5.空间复杂度：O(1)
     */
    public static String longestSubPalindromeV1(String s) {
        //鲁棒
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        //保存回文串
        String result = "";
        //临时截取的字符串
        String tmp;
        //保存截取的回文串的最大长度
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                tmp = s.substring(i, j);
                //因为&&的作用，只要前面的判断为false，后面就不会继续判断了
                if (isPalindrome(tmp) && tmp.length() > max) {
                    result = tmp;
                    max = result.length();
                }
            }
        }
        return result;
    }


    /**
     * 是否为回文串
     *
     * @apiNote 思路：
     * 1.首尾比较，判断是否相等
     * 2.假设是str=aba，只要先比较第一个和最后一个字符判断是否相等即可
     * 3.这里需要注意的是，空格“”，单个字符“a”都属于回文串
     */
    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * dp解决
     *
     * @apiNote 思路：
     * 1.之前的暴力解法时间复杂度太大了，这里使用dp的思想来解题
     * 2.dp[i][j]定义为字串s[i-j]是否为回文字符串,true or false
     * 3.dp[i][i]=true
     * 4.状态方程为：dp[i][j]=(s[i]==s[j]) && (dp[i+1][j-1]==true)
     * 5.时间复杂度：O(n*n)
     * 6.空间复杂度：O(n*n)
     */
    public static String longestSubPalindromeV2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //这里只需要定义最长回文子串的起始位置以及长度，最后进行截取
        int maxLen = 1;
        int start = 0;
        //1.定义dp方程
        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        //2.初始化dp（单个字符就是回文的）
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //3.根据状态方程打表
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chs[i] != chs[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //如果找到回文字串，那就记录长度和起始位置，并更新maxLen
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabb";
        String str3 = "aabbc";
        String str4 = "aba";
        String str5 = "ababa";
        System.out.println("**********************************************************************");
        System.out.println("Q2.给定字符串是否是回文字符串？*****************************");
        System.out.println("字符：" + str1 + "是不是回文串：" + isPalindrome(str1));
        System.out.println("字符：" + str4 + "是不是回文串：" + isPalindrome(str4));
        System.out.println("字符：" + str5 + "是不是回文串：" + isPalindrome(str5));
        System.out.println("*********************************************************************");
        System.out.println("Q3.给定字符串中的最长回文字符串是哪一个？*********************************");
        System.out.println("1.暴力枚举的方法：");
        System.out.println("给定字符串：" + str1 + "组成的最长回文串为：" + longestSubPalindromeV1(str1));
        System.out.println("给定字符串：" + str4 + "组成的最长回文串为：" + longestSubPalindromeV1(str4));
        System.out.println("给定字符串：" + str5 + "组成的最长回文串为：" + longestSubPalindromeV1(str5));
    }
}
