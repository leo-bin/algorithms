package com.bins.question.string;


/**
 * @author leo-bin
 * @date 2020/4/17 20:17
 * @apiNote 左旋转字符
 * 来源：剑指offer-58-Ⅱ
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class LeftRotateString {

    /**
     * 题目描述：
     * 1.汇编语言中有一种移位指令叫做循环左移（ROL）
     * 2.现在有个简单的任务，就是用字符串模拟这个指令的运算结果
     * 3.对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
     * 4.例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果
     * 5.即“XYZdefabc”
     *
     * @apiNote 思路：
     * 1.暴力
     */
    public static String leftRotateString(String s, int n) {
        //特判
        if (s.length() <= 1 || s.length() == n) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }


    /**
     * 解法二，字符串拼接
     */
    public static String leftRotateStringV2(String s, int n) {
        //特判
        if (s.length() <= 1 || s.length() == n) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString(str, 3));
        System.out.println(leftRotateStringV2(str, 3));
    }
}
