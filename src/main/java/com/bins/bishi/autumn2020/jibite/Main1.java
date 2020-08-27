package com.bins.bishi.autumn2020.jibite;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/27 20:25
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述
     * 给定一个由英文字母组成的字符串
     * 假定字符 c1 和 c2 在字符串中的位置分别为 p1 和 p2
     * 求 p1 和 p2 差的绝对值的最大值
     * <p>
     * 输入描述:
     * 输入只有一行，依次为一个由英文字母组成的字符串、字符1和字符2
     * 字符串长度不超过 64，字母不区分大小写
     * <p>
     * 输出描述:
     * 输出一个整数，为字符最大距离，如果给定的字符不在字符串中，则输出 -1 即可
     * <p>
     * 示例1
     * 输入
     * ba A b
     * 输出
     * 1
     *
     * @apiNote 思路：
     * 1.双指针
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().toLowerCase();
        String s1 = scanner.next().toLowerCase();
        String s2 = scanner.next().toLowerCase();

        char c1 = s1.charAt(0), c2 = s2.charAt(0);
        int max = -1;
        for (int i = 0, i1 = 0, j = s.length() - 1, j1 = s.length() - 1; ; ) {
            while (i < s.length() && s.charAt(i) != c1) {
                i++;
            }
            while (j > 0 && s.charAt(j) != c2) {
                j--;
            }
            if (i >= s.length() || j < 0) {
                break;
            }
            max = Math.abs(i - j);
            while (i1 < s.length() && s.charAt(i1) != c2) {
                i1++;
            }
            while (j1 > 0 && s.charAt(j1) != c1) {
                j1--;
            }
            if (i1 >= s.length() || j1 < 0) {
                break;
            }
            max = Math.max(Math.abs(i1 - j1), max);
            break;
        }
        System.out.println(max);
    }
}
