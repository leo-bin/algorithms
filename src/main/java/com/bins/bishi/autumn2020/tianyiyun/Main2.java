package com.bins.bishi.autumn2020.tianyiyun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/16 19:33
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.实现删除字符串中出现次数最少的字符
     * 2.若多个字符出现次数一样，则都删除
     * 3.输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序
     * <p>
     * 输入描述:
     * 字符串只包含小写英文字母,不考虑非法输入，输入的字符串长度小于等于100个字节
     * 输出描述:
     * 删除字符串中出现次数最少的字符后的字符串
     * <p>
     * 示例1
     * 输入
     * abcdd
     * 输出
     * dd
     * <p>
     * 示例2
     * 输入
     * assddfg
     * 输出
     * ssdd
     *
     * @apiNote 思路：
     * 1.哈希表+暴力
     * 2.ac了
     */
    public static String code(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        int minCount = Integer.MAX_VALUE;
        char[] chs = s.toCharArray();
        for (char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //记录最小出现次数
        for (Map.Entry entry : map.entrySet()) {
            minCount = Math.min(minCount, (int) entry.getValue());
        }
        for (int i = 0; i < chs.length; i++) {
            if (map.get(chs[i]) == minCount) {
                chs[i] = '1';
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : chs) {
            if (c != '1') {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(code(s));
    }
}
