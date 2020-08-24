package com.bins.bishi.autumn2020.tencent;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/23 21:41
 * @apiNote
 */
public class Main5 {


    /**
     * 题目描述
     * 小Q喜欢比较回文串
     * 有一天他突然想知道s串在[l,r]最少被拆分成多少个回文子串
     * 他想请聪明的你帮帮他
     * <p>
     * 输入描述:
     * 输入包含一组样例，接下来一行输入一个字符串s
     * 接着输入一个数字Q代表询问个数
     * 接下来Q行每行输入两个数字 l,r 代表询问的区间，s的区间为[1, |s|]
     * 1 <= |s| <= 400, 1 <= Q <= 100000, 1 <= l <= r <= |s|
     * 注意：|s|表示s串的长度
     * <p>
     * 输出描述:
     * 输出总共Q行，每行输出一个数字
     * 表示对于每个询问，s串在[l,r]最少被拆分成多少个回文子串
     * <p>
     * 示例1
     * 输入
     * ababa
     * 4
     * 1 4
     * 1 5
     * 1 2
     * 1 3
     * 输出
     * 2
     * 1
     * 2
     * 1
     * 说明
     * 询问为1 4 得到是abab，最少分为2个回文子串，aba与b，输出2；询问为1 5 得到的是ababa 就是1个回文串，输出1
     *
     * @apiNote 思路：
     * 1.
     */

    /**
     * 贪心
     */
    public static void code(String s, int left, int right) {
        String sub = s.substring(left - 1, right);
        if (check(sub)) {
            System.out.println(1);
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < sub.length(); i++) {
                set.add(sub.charAt(i));
            }
            System.out.println(set.size());
        }
    }

    /**
     * 判断是否是回文字符串
     */
    public static boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            code(s, left, right);
        }
    }
}
