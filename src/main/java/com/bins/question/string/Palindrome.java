package com.bins.question.string;

import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/3/21 14:38
 * @apiNote 回文字符
 */
public class Palindrome {


    /**
     * 1.求能够组成的最长回文字符串的长度
     * 例如：
     * str=abc
     * 输出：0
     * 构成的回文串为：没有回文串
     * <p>
     * str=aabb
     * 输出：4
     * 构成的回文串为：abba
     *
     * @apiNote 思路：
     * 能够够成回文串的两种情况：
     * 1.字符出现次数为偶数的组合（aabb）
     * 2.字符出现次数为奇数的组合加上字符出现次数为偶数的组合(aabbc)
     * 3.那我们就只要统计字符出现的次数就行了
     * 4.如果字符出现的次数全部都是偶数，那就是返回字符串的长度
     * 5.如果某个字符出现了一次，那就返回字符串的长度+1
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int longestPalindrome(String str) {
        if (str.length() == 0) {
            return 0;
        }
        //次数
        int count = 0;
        //转换为字符型数组
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
            } else {
                set.remove(chars[i]);
                count++;
            }
        }
        if (set.isEmpty()) {
            return count * 2;
        } else {
            return count * 2 + 1;
        }
    }


    /**
     * 2.最大回文子串（暴力解法）
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
    public static String longestPalindrome2(String str) {
        //鲁棒
        int len = str.length();
        if (len == 0 || len == 1) {
            return str;
        }
        //保存回文串
        String result = "";
        //临时截取的字符串
        String test = "";
        //保存截取的回文串的最大长度
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                test = str.substring(i, j);
                //因为&&的作用，只要前面的判断为false，后面就不会继续判断了
                if (isPalindrome(test) && test.length() > max) {
                    result = test;
                    max = Math.max(max, result.length());
                }
            }
        }
        return result;
    }


    /**
     * 3.是否为回文串
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
     * 4.给定字符能够构成的最长回文串
     *
     * @apiNote 思路：
     * 1.之前的暴力解法时间复杂度太大了，这里使用dp的思想来解题
     * 2.
     */
    public static String longestPalindrome3(String str) {
        String result = "";
        // TODO: BY leo-bin 2020/3/23
        // TODO-LIST:


        return result;
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabb";
        String str3 = "aabbc";
        String str4 = "aba";
        String str5 = "ababa";
        System.out.println("***************************回文串测试*********************************");
        System.out.println("Q1.给定字符串能够构成的最长回文字符的长度是多少？***************************");
        System.out.println("字符串" + str1 + "能够构成的最长回文串的长度是：" + longestPalindrome(str1));
        System.out.println("字符串" + str2 + "能够构成的最长回文串的长度是：" + longestPalindrome(str2));
        System.out.println("字符串" + str3 + "能够构成的最长回文串的长度是：" + longestPalindrome(str3));
        System.out.println("**********************************************************************");
        System.out.println("Q2.给定字符串是否是回文字符串？*****************************");
        System.out.println("字符：" + str1 + "是不是回文串：" + isPalindrome(str1));
        System.out.println("字符：" + str4 + "是不是回文串：" + isPalindrome(str4));
        System.out.println("字符：" + str5 + "是不是回文串：" + isPalindrome(str5));
        System.out.println("*********************************************************************");
        System.out.println("Q3.给定字符串中的最长回文字符串是哪一个？*********************************");
        System.out.println("1.暴力枚举的方法：");
        System.out.println("给定字符串：" + str1 + "组成的最长回文串为：" + longestPalindrome2(str1));
        System.out.println("给定字符串：" + str4 + "组成的最长回文串为：" + longestPalindrome2(str4));
        System.out.println("给定字符串：" + str5 + "组成的最长回文串为：" + longestPalindrome2(str5));
    }
}
