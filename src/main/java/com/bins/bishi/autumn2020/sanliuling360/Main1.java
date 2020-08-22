package com.bins.bishi.autumn2020.sanliuling360;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/22 17:37
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 现在的调查问卷越来越多了，所以出现了很多人恶意刷问卷的情况
     * 已知某问卷需要填写名字，如果名字仅由大小写英文字母组成且长度不超过10
     * 则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷
     * 请你判断出由多少有效问卷（只要名字是真实有效的，就认为问卷有效）
     * <p>
     * 输入描述
     * 输入第一行包含一个正整数n，表示收到的问卷数量。(1<=n<=2000)
     * 接下来有n行，每行有一个由大小写英文字母，数字，下划线组成的字符串
     * 分别表示一份问卷的名字，字符串长度不超过100。
     * <p>
     * 输出描述
     * 输出只有一个整数，表示有效问卷数量。
     * <p>
     * 样例输入
     * 5
     * BA
     * aOWVXARgUbJDG
     * OPPCSKNS
     * HFDJEEDA
     * ABBABBBBAABBBAABAAA
     * <p>
     * 样例输出
     * 3
     *
     * @apiNote 思路：
     * 1.暴力匹配
     */

    private static int count = 0;

    /**
     * 匹配
     */
    public static boolean check(String s) {
        //特判
        if (s.length() > 10) {
            return false;
        }
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (check(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
