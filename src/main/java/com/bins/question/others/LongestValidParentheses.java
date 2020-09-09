package com.bins.question.others;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/9/9 14:32
 * @apiNote 最长有效括号
 * 来源：leetcode-32
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * 题目描述：
     * 1.给定一个只包含 '(' 和 ')' 的字符串
     * 2.找出最长的包含有效括号的子串的长度。
     * <p>
     * 示例 1:
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * <p>
     * 示例 2:
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     *
     * @apiNote 思路：
     * 1.我们尝试将这个问题分成两个问题来看
     * 2.首先我将整个字符串用栈模拟一遍，求出那些能够匹配的括号的下标
     * 3.使用一个对应的数组记录下标的情况：0代表不能匹配，1代表可以匹配
     * 4.之后就变成了：[0,1,1],我们就只要求连续的1的长度就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] marked = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    marked[i] = 1;
                    marked[stack.pop()] = 1;
                }
            }
        }
        //求连续的1的个数
        int maxLen = 0;
        for (int i = 0; i < marked.length; i++) {
            if (marked[i] == 1) {
                int j = i, curLen = 0;
                while (j < marked.length && marked[j++] == 1) {
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = ")()";
        String s2 = ")()())";
        String s3 = ")()()(";
        String s4 = "()(())";
        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
        System.out.println(longestValidParentheses(s3));
        System.out.println(longestValidParentheses(s4));
    }
}
