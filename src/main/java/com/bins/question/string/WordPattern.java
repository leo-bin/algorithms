package com.bins.question.string;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/8/18 9:54
 * @apiNote 单词规律
 * 来源：leetcode-290
 * 链接：https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {

    /**
     * 题目描述：
     * 1.给定一种规律 pattern 和一个字符串 str
     * 2.判断 str 是否遵循相同的规律
     * 3.这里的 遵循 指完全匹配
     * 4.例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 示例1:
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * <p>
     * 示例 3:
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * <p>
     * 示例 4:
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * <p>
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母
     *
     * @apiNote 思路：
     * 1.直接HashMap暴力匹配
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean wordPattern(String pattern, String str) {
        StringBuilder builder = new StringBuilder();
        HashMap<String, Character> map = new HashMap<>(16);
        String[] words = str.split(" ");
        //特判
        if (pattern.length() != words.length) {
            return false;
        }
        int[] marked = new int[300];
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                builder.append(map.get(words[i]));
            } else {
                map.put(words[i], pattern.charAt(i));
                if (marked[pattern.charAt(i)] == 0) {
                    marked[pattern.charAt(i)] = pattern.charAt(i);
                    builder.append(pattern.charAt(i));
                }
            }
        }
        return builder.toString().equals(pattern);
    }


    public static void main(String[] args) {
        String pattern1 = "abba", str1 = "dog cat cat dog";
        String pattern2 = "abba", str2 = "dog cat cat fish";
        String pattern3 = "aaaa", str3 = "dog cat cat dog";
        String pattern4 = "abba", str4 = "dog dog dog dog";
        System.out.println(wordPattern(pattern1, str1));
        System.out.println(wordPattern(pattern2, str2));
        System.out.println(wordPattern(pattern3, str3));
        System.out.println(wordPattern(pattern4, str4));
    }
}
