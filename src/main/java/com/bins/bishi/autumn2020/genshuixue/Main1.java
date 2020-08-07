package com.bins.bishi.autumn2020.genshuixue;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/8/7 18:24
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给出一个字符串s（仅含有小写英文字母和括号）
     * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     * 注意，您的结果中不应包含任何括号。
     * <p>
     * 示例 1：
     * 输入：s = "(abcd)"
     * 输出："dcba"
     * <p>
     * 示例 2：
     * 输入：s = "(u(love)i)"
     * 输出："iloveu"
     * <p>
     * 示例 3：
     * 输入：s = "(ed(eb(oc))em)"
     * 输出："meebcode"
     * <p>
     * 示例 4：
     * 输入：s = "a(bcdefghijkl(mno)p)q"
     * 输出："apmnolkjihgfedcbq"
     *
     * @apiNote 思路：
     * 1.
     */
    public String reverseParentheses(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (chs[i] != ')') {
                stack.push(chs[i]);
            } else {
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty()) {
                    char ch = stack.pop();
                    if (ch != '(') {
                        builder.append(ch);
                    } else {
                        break;
                    }
                }

                for (int j = 0; j < builder.length(); j++) {
                    stack.push(builder.charAt(j));
                }
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        Main1 main1 = new Main1();
        String s1 = "(abcd)";
        String s2 = "(u(love)i)";
        String s3 = "(ed(eb(oc))em)";
        String s4 = "a(bcdefghijkl(mno)p)q";
        System.out.println(main1.reverseParentheses(s1));
        System.out.println(main1.reverseParentheses(s2));
        System.out.println(main1.reverseParentheses(s3));
        System.out.println(main1.reverseParentheses(s4));
    }
}
