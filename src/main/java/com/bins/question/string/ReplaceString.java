package com.bins.question.string;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/13 16:35
 * @apiNote 字符串替换
 */
public class ReplaceString {


    /**
     * 题目描述：
     * 1.给定一个仅由小写字母x和y组成且长度不超过10^5的字符串
     * 2.每次可以将字符串中的一个子串xy替换成字符串yyx
     * 3.那么至少要替换多少次才能让字符串中不存在子串xy？
     * <p>
     * 输入描述:
     * 输入给定的字符串
     * <p>
     * 输出描述:
     * 输出最少替换次数对10^9+7取模后的结果
     * <p>
     * 输入例子1:
     * xxy
     * <p>
     * 输出例子1:
     * 3
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int count = 0, res = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == 'y') {
                count += 1;
            }
            if (s.charAt(i) == 'x') {
                res = (res + count) % (1000000007);
                count = (count * 2) % (1000000007);
            }
        }
        System.out.println(res % (1000000007));
    }
}
