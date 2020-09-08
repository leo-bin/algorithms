package com.bins.bishi.autumn2020.xiaomi;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/8 17:37
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.密码生成器
     * 2.注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度
     * 3.检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间
     * 4.符合要求，返回 0；长度不符合返回 1；类型不符合要求返回2
     * 5.可以一次输入多组密码，以空格符间隔，空格符不作为密码。
     * <p>
     * 输入描述
     * 需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
     * <p>
     * 输出描述
     * 每个密码的检查结果，每个结果需要换行输出
     * <p>
     * 样例输入
     * 123 12345678 123abcABC!!!
     * <p>
     * 样例输出
     * 1
     * 2
     * 0
     *
     * @apiNote 思路：
     * 1.暴力匹配
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        for (String s1 : strings) {
            //1.不符合长度
            if (s1.length() < 8 || s1.length() > 120) {
                System.out.println(1);
            }
            //2.匹配类型
            else {
                int i = 0, j = 0, z = 0, k = 0;
                for (char c : s1.toCharArray()) {
                    if (Character.isLowerCase(c)) {
                        i++;
                    } else if (Character.isUpperCase(c)) {
                        j++;
                    } else if (Character.isDigit(c)) {
                        z++;
                    } else {
                        k++;
                    }
                }
                if (i >= 1 && j >= 1 && z >= 1 && k >= 1) {
                    //匹配成功
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            }
        }
    }
}
