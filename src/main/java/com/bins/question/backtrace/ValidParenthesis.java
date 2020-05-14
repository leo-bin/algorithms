package com.bins.question.backtrace;


import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/5/13 10:17
 * @apiNote 有效的括号
 * 来源：LeetCode-20
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParenthesis {


    /**
     * 题目描述：
     * 1.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     * 2.有效字符串需满足:
     * 3.左括号必须用相同类型的右括号闭合。
     * 4.左括号必须以正确的顺序闭合。
     * <p>
     * 5.注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * <p>
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * <p>
     * 示例 4*
     * 输入: "([)]"
     * 输出: false
     * <p>
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     *
     * @apiNote 思路：
     * 1.栈实现
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean isValid(String s) {
        //鲁棒
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if ((len & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        //统计配对次数
        int count = 0;
        while (i < len) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(s.charAt(i));
            } else if (current == ')' || current == ']' || current == '}') {
                if (!stack.isEmpty()) {
                    if (isCorrect(stack.pop(), current)) {
                        count++;
                    } else {
                        return false;
                    }
                }
            }
            i++;
        }
        return count == len / 2;
    }


    /**
     * 检查是否是一对
     */
    public static boolean isCorrect(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        } else if (left == '[' && right == ']') {
            return true;
        } else if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "((";
        String s7 = "]]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
        System.out.println(isValid(s7));
    }
}
