package com.bins.bishi.autumn2020.meituan.bishi2020spring;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/7/30 15:36
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给出一个布尔表达式的字符串，比如：true or false and false
     * 2.表达式只包含true，false，and和or，现在要对这个表达式进行布尔求值
     * 3.计算结果为真时输出true、为假时输出false，不合法的表达时输出error（比如：true true）
     * 4.表达式求值是注意and 的优先级比 or 要高
     * 5.比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
     * <p>
     * <p>
     * 输入描述:
     * 输入第一行包含布尔表达式字符串s，s只包含true、false、and、or几个单词（不会出现其它的任何单词）
     * 且单词之间用空格分隔
     * (1 ≤ |s| ≤ 103)
     * <p>
     * 输出描述:
     * 输出true、false或error，true表示布尔表达式计算为真
     * false表示布尔表达式计算为假，error表示一个不合法的表达式。
     * <p>
     * 输入例子1:
     * and
     * <p>
     * 输出例子1:
     * error
     * <p>
     * 输入例子2:
     * true and false
     * <p>
     * 输出例子2:
     * false
     * <p>
     * 输入例子3:
     * true or false and false
     * <p>
     * 输出例子3:
     * true
     *
     * @apiNote 思路：
     * 1.
     */
    /**
     * 题目描述：
     * 1.
     *
     * @apiNote 思路：
     * 1.暴力匹配+栈
     * 2.
     */
    public static String code(String[] words) {
        //特判
        if (words.length == 1) {
            return "and".equals(words[0]) || "or".equals(words[0]) ? "error" : words[0];
        }
        Stack<String> stack = new Stack<>();
        stack.push(words[0]);
        String result = "false";
        //先保证and先算
        for (int i = 1; i < words.length; i++) {
            String current = words[i];
            if ("and".equals(current) && i < words.length - 1) {
                String pre = stack.pop();
                String next = words[++i];
                if ("and".equals(pre) || "or".equals(pre) || "and".equals(next) || "or".equals(next)) {
                    return "error";
                }
                if ("false".equals(pre) || "false".equals(next)) {
                    stack.push("false");
                } else {
                    stack.push("true");
                }
            } else {
                stack.add(current);
            }
        }

        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        //保证最后剩下的一定是有效的表达式
        if ("or".equals(list.get(0)) || "or".equals(list.get(list.size() - 1))) {
            return "error";
        }

        int count1 = 0;
        int count2 = 0;
        for (String s : list) {
            if (!"or".equals(s)) {
                count1++;
                count2 = 0;
            } else {
                count1 = 0;
                count2++;
            }
            if (count1 == 2 || count2 == 2) {
                return "error";
            }
        }

        //最后只剩下or true 和false了就直接计算
        for (String current : list) {
            if ("true".equals(current)) {
                return "true";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] words = s.split(" ");
        System.out.println(code(words));
    }
}
