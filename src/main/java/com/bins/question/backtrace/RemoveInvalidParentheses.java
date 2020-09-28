package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leo-bin
 * @date 2020/9/16 15:10
 * @apiNote 删除无效的括号
 * 来源：leetcode-301
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/
 */
public class RemoveInvalidParentheses {

    /**
     * 题目描述：
     * 1.删除最小数量的无效括号
     * 2.使得输入的字符串有效，返回所有可能的结果
     * 3.说明: 输入可能包含了除 ( 和 ) 以外的字符
     * <p>
     * 示例 1:
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     * <p>
     * 示例 2:
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     * <p>
     * 示例 3:
     * 输入: ")("
     * 输出: [""]
     *
     * @apiNote 思路：
     * 1.这种题基本没啥办法，就是枚举
     * 2.这里是通过类似于bfs搜索的方式，求出每一个可能的子串是否是匹配的。
     */
    public static List<String> removeInvalidParenth(String s) {
        Set<String> set = new HashSet<>();
        set.add(s);
        List<String> result = new ArrayList<>();
        while (true) {
            //直接判断当前集合中的字符是否满足
            for (String ss : set) {
                if (isValid(ss)) {
                    result.add(ss);
                }
            }
            //如果这一批次有结果的话那就提前结束
            if (result.size() > 0) {
                return result;
            }
            Set<String> nextSet = new HashSet<>();
            //枚举所有删除一个字符之后的结果
            for (String sss : set) {
                for (int i = 0; i < sss.length(); i++) {
                    if (sss.charAt(i) == '(' || sss.charAt(i) == ')') {
                        nextSet.add(sss.substring(0, i) + sss.substring(i + 1, sss.length()));
                    }
                }
            }
            set = nextSet;
        }
    }

    /**
     * 检验字符串是否有效
     */
    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> result = removeInvalidParenth(s);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
