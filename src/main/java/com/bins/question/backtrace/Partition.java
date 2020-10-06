package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/10/6 15:15
 * @apiNote 分割回文串
 * 来源：leetcode-131
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Partition {

    /**
     * 题目描述：
     * 1.给定一个字符串 s，将 s 分割成一些子串
     * 2.使每个子串都是回文串
     * 3.返回 s 所有可能的分割方案。
     * <p>
     * 示例:
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @apiNote 思路：
     * 1.题目给的很直接，只要求出所有分割的方法并判断是否回文即可
     * 2.这里可以直接使用回溯的方法从后往前求出所有可以分割的组合，并且判断是否是回文即可
     * 3.这个也是利用回溯去求子串的一个经典做法，笔试经常会出类似的题型
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrace(s, result, new LinkedList<>(), 0);
        return result;
    }

    /**
     * 回溯
     */
    public static void backtrace(String s, List<List<String>> result, LinkedList<String> track, int index) {
        //递归结束条件
        if (index == s.length()) {
            result.add(new ArrayList<>(track));
            return;
        }
        //接着往后面递归
        for (int i = index; i < s.length(); i++) {
            String string = s.substring(index, i + 1);
            if (!isPalindrome(string)) {
                continue;
            }
            track.add(string);
            backtrace(s, result, track, i + 1);
            track.pollLast();
        }
    }

    /**
     * 判断是否是回文串
     */
    public static boolean isPalindrome(String s) {
        //特判
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        for (List<String> res : result) {
            System.out.println(res.toString());
        }
    }
}
