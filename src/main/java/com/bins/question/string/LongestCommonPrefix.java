package com.bins.question.string;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/6 9:59
 * @apiNote 最长公共前缀
 */
public class LongestCommonPrefix {


    /**
     * 题目描述：
     * 1.编写一个函数来查找字符串数组中的最长公共前缀
     * 2.如果不存在公共前缀，返回空字符串 ""
     * <p>
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * <p>
     * 说明:
     * 所有输入只包含小写字母 a-z
     *
     * @apiNote 思路
     * 1.使用Arrays.sort对字符串数组按照字典序进行排序
     * 2.接下来就只需要比较排序完后的数组的第一个字符串和最后一个字符串
     * 3.时间复杂度：O(n*log(n))
     * 4.空间复杂度：O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        StringBuilder result = new StringBuilder();
        //鲁棒
        if (len == 0) {
            return "";
        }
        //按照字典排序
        Arrays.sort(strs);
        //求排序之后第一个字符串和最后一个字符串
        int first = strs[0].length();
        int last = strs[len - 1].length();
        int count = Math.min(first, last);
        for (int i = 0; i < count; i++) {
            //找公共的字符
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                result.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String[] strs = {"abc", "ab", "bc"};
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
    }
}
