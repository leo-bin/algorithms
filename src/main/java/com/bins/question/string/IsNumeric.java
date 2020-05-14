package com.bins.question.string;

import java.util.regex.Pattern;

/**
 * @author leo-bin
 * @date 2020/4/17 22:09
 * @apiNote 表示数值的字符串
 */
public class IsNumeric {

    /**
     * 字符串中表示数值的正则
     */
    private static Pattern pattern = Pattern.compile("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");


    /**
     * 题目描述：
     * 1.请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
     * 2.例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
     * 3. 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
     *
     * @apiNote 思路：
     * 1.正则表达式解法
     */
    public static boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return pattern.matcher(string).matches();
    }


    /**
     * 利用异常处理解决
     */
    public static boolean isNumericV2(char[] str) {
        try {
            double result = Double.parseDouble(String.valueOf(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] chs = {'5', 'e', '2'};
        char[] chs1 = {'1', 'a', '3', '.', '1', '4'};
        System.out.println(isNumeric(chs));
        System.out.println(isNumeric(chs1));
    }
}
