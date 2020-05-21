package com.bins.question.string;

import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/5/21 17:17
 * @apiNote 最长回文串
 * 来源：leetcode-409
 * 链接：https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome {


    /**
     * 题目描述：
     * 1.给定一个包含大写字母和小写字母的字符串
     * 2.找到通过这些字母构造成的最长的回文串
     * 3.在构造过程中，请注意区分大小写
     * 4.比如 "Aa" 不能当做一个回文字符串
     * <p>
     * 示例 1:
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7
     *
     * @apiNote 思路：
     * 1.题目的需要我们统计最长回文字符串的长度
     * 2.并且可以通过任意组合所有字符串
     * 3.暴力肯定超时还很繁琐
     * 4.通过观察不难发现，只需统计字符串中出现次数为偶数的组合数以及偶数次的组合加一个出现次数为奇数的字符
     * 5.比如说，aabb，偶数个组合的个数就是2，那么最长的回文串就是abba，长度算是2*2
     * 6.比如说是aabbc，偶数个数的组合是aabb，加上一个c，所以就是：abcba，长度是2*2+1
     * 7.在这里我们可以使用一个哈希表 来保存之前字符出现的次数
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        //统计偶数出现的次数
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(chs[i])) {
                set.add(chs[i]);
            } else {
                set.remove(chs[i]);
                count++;
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabb";
        String str3 = "aabbc";
        System.out.println("Q1.给定字符串能够构成的最长回文字符的长度是多少？***************************");
        System.out.println("字符串" + str1 + "能够构成的最长回文串的长度是：" + longestPalindrome(str1));
        System.out.println("字符串" + str2 + "能够构成的最长回文串的长度是：" + longestPalindrome(str2));
        System.out.println("字符串" + str3 + "能够构成的最长回文串的长度是：" + longestPalindrome(str3));
    }
}
