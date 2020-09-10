package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/9/10 11:14
 * @apiNote 实现strStr
 * 来源：leetcode-28
 * 链接：https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {

    /**
     * 题目描述：
     * 1.实现 strStr() 函数
     * 2.给定一个 haystack 字符串和一个 needle 字符串
     * 3.在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
     * 4.如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * <p>
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0
     * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符
     *
     * @apiNote 思路：
     * 1.调api
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 暴力
     *
     * @apiNote 思路：
     * 1.暴力思路很简单，虽然会超时，但是有更好的KMP算法
     * 2.我们先尝试一下
     * 3.时间复杂度：O(n*n)
     * 4.空间复杂度：O(1)
     */
    public static int strStrV2(String haystack, String needle) {
        //特判
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return -1;
        }
        int count, start;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                count = 0;
                start = i;
                for (int j = 0, index = i; index < haystack.length() && j < needle.length(); index++, j++) {
                    if (haystack.charAt(index) == needle.charAt(j)) {
                        count++;
                    }
                }
                if (count == needle.length()) {
                    return start;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStrV2(haystack, needle));
    }
}
