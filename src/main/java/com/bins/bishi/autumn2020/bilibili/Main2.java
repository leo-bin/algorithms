package com.bins.bishi.autumn2020.bilibili;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/13 18:22
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给定一个只包含括号的字符串
     * 2.判断字符串是否有效
     * 3.其中，括号种类包含： ‘(’，’)’，’{’，’}’，’[’，’]'
     * 4.有效字符串需满足：
     * 1) 左括号必须用相同类型的右括号闭合
     * 2）左括号必须以正确的顺序闭合
     * 5.注意空字符串可被认为是有效字符串
     * <p>
     * 示例1
     * 输入
     * "{[]}"
     * <p>
     * 输出
     * true
     * <p>
     * 示例2
     * 输入
     * "([)]"
     * <p>
     * 输出
     * false
     * <p>
     * 示例3
     * 输入
     * "([]"
     * <p>
     * 输出
     * false
     *
     * @apiNote 思路：
     * 1.栈+暴力模拟
     */
    public static boolean isValid(String s) {
        //特判
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            //遇到右括号做匹配
            if (c == ')' && '(' == stack.peek()) {
                stack.pop();
            } else if (c == '}' && '{' == stack.peek()) {
                stack.pop();
            } else if (c == ']' && '[' == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "{[]}";
        String s2 = "([)]";
        String s3 = "([]";
        String s4 = "{{{{{{";
        String s5 = "";
        String s6 = "{";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
    }
}
