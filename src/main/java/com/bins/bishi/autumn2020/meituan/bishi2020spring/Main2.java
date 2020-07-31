package com.bins.bishi.autumn2020.meituan.bishi2020spring;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/31 10:55
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给出两个字符串，分别是模式串P和目标串T
     * 2.判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0
     * 3.模式串中‘？’可以匹配目标串中的任何字符
     * 4.模式串中的 ’*’可以匹配目标串中的任何长度的串模
     * 5.式串的其它字符必须和目标串的字符匹配
     * 6.例如P=a?b，T=acb，则P 和 T 匹配。
     * <p>
     * 输入描述:
     * 输入第一行包含一个字符串p， (1 ≤ |p| ≤ 20).
     * 输入第二行包含一个字符串t， (1 ≤ |t| ≤ 20).
     * <p>
     * 输出描述:
     * 输出仅包含0和1的整数，0表示p和t不匹配，1表示p和t匹配。
     * <p>
     * 输入例子1:
     * a?b
     * ab
     * <p>
     * 输出例子1:
     * 0
     * <p>
     * 输入例子2:
     * a*b
     * ab
     * <p>
     * 输出例子2:
     * 1
     * <p>
     * 输入例子3:
     * a*b
     * a(cb
     * <p>
     * 输出例子3:
     * 1
     * <p>
     * 输入：
     * *145**5]6461
     * s5dwee1455]6461
     * 输出：
     * 1
     *
     * @apiNote 思路：
     * 1.暴力匹配
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        int count = 0;
        for (int i = 0, j = 0; i < str1.length(); i++, j++) {
            if (j >= str2.length()) {
                count++;
                break;
            }
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);
            if (char1 != char2 && char1 == '*') {
                if (++i < str1.length()) {
                    while (str1.charAt(i) == '*') {
                        i++;
                    }
                    char t = str1.charAt(i);
                    while (j < str2.length() && str2.charAt(j) != t) {
                        j++;
                    }
                    if (j >= str2.length()) {
                        count++;
                    }
                }
            } else if (char1 != char2 && char1 != '?') {
                count++;
            }
        }
        System.out.println(count == 0 ? 1 : 0);
    }
}
