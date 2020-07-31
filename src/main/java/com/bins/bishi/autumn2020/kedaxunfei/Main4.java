package com.bins.bishi.autumn2020.kedaxunfei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/31 14:36
 * @apiNote 提前批第四题：ac:1.0
 */
public class Main4 {

    /**
     * 题目描述
     * 编程实现一个从字符串输入提取整数的程序，要求尽量多的考虑异常输入的情况
     * <p>
     * 输入要求：
     * 字符串长度大于0
     * <p>
     * 输入描述:
     * 输入一行字符串为待提取的字符串
     * <p>
     * 输出描述:
     * 输出从字符串提取的整数
     * <p>
     * 示例：
     * 输入：
     * +1a2
     * <p>
     * 输出
     * 12
     * <p>
     * 自测数据：
     * 00abc123:123
     * 0abc123:123
     * 0a32bc-3:-323
     * 3a2-1a2b-3a:32123
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chs = s.toCharArray();
        LinkedList<Integer> builder = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            int t = chs[i] - '0';
            if (t >= 0 && t <= 9) {
                builder.add(t);
            }
            if (chs[i] == '-') {
                count++;
            }
        }

        StringBuilder result = new StringBuilder();
        //排除首位是0
        while (builder.get(0) == 0) {
            builder.remove(builder.get(0));
        }
        for (int i = 0; i < builder.size(); i++) {
            result.append(builder.get(i));
        }
        System.out.println(((count & 1) == 0 ? "" : "-") + result.toString());
    }
}
