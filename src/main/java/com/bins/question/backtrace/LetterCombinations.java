package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/26 10:25
 * @apiNote 电话号码的字母组合
 * 来源：leetcode-17
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    /**
     * 题目描述：
     * 1.给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
     * 2.给出数字到字母的映射如下（与电话按键相同）:
     * 1--=!@#
     * 2---abc
     * 3---def
     * 4---ghi
     * 5---jkl
     * 6---mno
     * 7---pqrs
     * 8---tuv
     * 9---wxyz
     * 3.注意 1 不对应任何字母
     * <p>
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
     *
     * @apiNote 思路：
     * 1.这种题目应该没有太多的奇淫技巧可言
     * 2.本质上就是一个组合的问题，我们直接使用回溯就能解决
     * 3.但是这个题目我觉得出的很好，它不像我们之前做过的那个回溯
     * 4.它有两种可能的走向
     * 5.这个走向指的是我们之前一般来说都是对一个对象进行随机组合，比如说一个String=abc
     * 6.或者说是一个序列：1，2，3进行组合
     * 7.但是今天这种我们的结果需要从多个对象中进行随机选取，然后拼在一起得到最后的结果
     * 8.这里可以使用一个k来确定我们使用的对象是哪一个，每次+1就行
     */
    private static List<String> results = new ArrayList<>();
    private static String[] chs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        //特判
        if (digits == null || digits.length() <= 0) {
            return results;
        }
        backtrace(digits.toCharArray(), new StringBuilder(), 0);
        return results;
    }

    /**
     * 回溯
     */
    public static void backtrace(char[] digits, StringBuilder builder, int index) {
        //递归结束条件
        if (index == digits.length) {
            results.add((builder.toString()));
            return;
        }
        String current = chs[digits[index] - '0'];
        for (char c : current.toCharArray()) {
            builder.append(c);
            backtrace(digits, builder, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
