package com.bins.question.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/17 20:17
 * @apiNote 左旋转字符
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
    public static String leftRotateString(String str, int n) {
        int len = str.length();
        //鲁棒
        if (len == 0 || len == 1 || len == n) {
            return str;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(str.charAt(i));
        }
        for (int j = 0; j < n; j++) {
            list.add(list.get(0));
            list.remove(0);
        }
        return list.toString().
                replaceAll(",", "").
                replace("[", "").
                replace("]", "").
                replaceAll(" ", "");
    }


    /**
     * 解法二，字符串拼接
     */
    public static String leftRotateStringV2(String str, int n) {
        int len = str.length();
        //鲁棒
        if (len == 0 || len == 1 || len == n) {
            return str;
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2 + s1;
    }


    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString(str, 3));
        System.out.println(leftRotateStringV2(str, 3));
    }

}
