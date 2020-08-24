package com.bins.bishi.autumn2020.tencent;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author leo-bin
 * @date 2020/8/23 19:46
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述
     * 输入一个字符串 s，s 由小写英文字母组成
     * 保证 s 长度小于等于 5000 并且大于等于 1。
     * 在 s 的所有不同的子串中，输出字典序第 k 小的字符串。
     * 字符串中任意个连续的字符组成的子序列称为该字符串的子串。
     * 字母序表示英文单词在字典中的先后顺序，即先比较第一个字母
     * 若第一个字母相同，则比较第二个字母的字典序，依次类推，则可比较出该字符串的字典序大小
     * <p>
     * 输入描述:
     * 第一行输出一个字符串 s，保证 s 长度小于等于 5000 大于等于 1
     * 第二行一个整数 k (1<= k <= 5)，保证 s 不同子串个数大于等于 k
     * <p>
     * 输出描述:
     * 输出一个字符串表示答案
     * <p>
     * 示例1
     * 输入
     * aabb
     * 3
     * <p>
     * 输出
     * aab
     * <p>
     * 说明
     * 不同的子串依次为：
     * a aa aab aabb ab abb b bb 所以答案为aab
     *
     * @apiNote 思路：
     * 1.先暴力看能过多少
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        s.append(scanner.next());
        int k = scanner.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                set.add(s.substring(j, i + 1));
            }
        }
        int index = 1;
        for (String str : set) {
            if (index++ == k) {
                System.out.println(str);
            }
        }
    }
}
