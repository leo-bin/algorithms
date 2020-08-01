package com.bins.question.math;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 9:37
 * @apiNote 数字构造
 * 来源：牛客-美团专题
 * 链接：https://www.nowcoder.com/practice/01d7d4cc93e44330ae45b4d8b8d06619?tpId=128&&tqId=33801&rp=1&ru=/ta/exam-meituan&qru=/ta/exam-meituan/question-ranking
 */
public class BuildNumber {

    /**
     * 题目描述：
     * 1.对于一个十进制数而言，它的数位和等于将它各位数字相加得到的和
     * 2.比如 231 的数位和 是 6，3179 的数位和是 20
     * 3.现在你知道某个十进制数的数位和等于 s
     * 4.并且这个数不包含 0，且任意相邻的数位是不同的
     * 5.比如112或者102都是不满足条件的
     * 6.现在你想知道满足这样的条件的最大的数是多少?
     * <p>
     * 输入描述:
     * 第一行包含一个整数𝑠，1 ≤ 𝑠 ≤ 42
     * <p>
     * 输出描述:
     * 输出满足条件的最大整数
     * <p>
     * 示例1:
     * 输入
     * 1
     * <p>
     * 输出
     * 1
     * <p>
     * 示例2:
     * 输入
     * 2
     * <p>
     * 输出
     * 2
     *
     * @apiNote 思路：
     * 1.贪心找规律
     */
    public static String code(int number) {
        StringBuilder builder = new StringBuilder();
        if (number % 3 == 1) {
            builder.append("1");
        }
        for (int i = 0; i < number / 3; i++) {
            builder.append("21");
        }
        if (number % 3 == 2) {
            builder.append("2");
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(code(number));
    }
}
