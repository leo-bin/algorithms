package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/26 10:33
 * @apiNote
 */
public class Main5 {

    /**
     * 题目描述：
     * 1.今天上课，老师教了小易怎么计算加法和乘法
     * 2.乘法的优先级大于加法
     * 3.但是如果一个运算加了括号，那么它的优先级是最高的
     * 例如：
     * 1+2*3=7
     * 1*(2+3)=5
     * 1*2*3=6
     * (1+2)*3=9
     * 4.现在小易希望你帮他计算给定3个数a，b，c
     * 5.在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值
     * <p>
     * 输入描述:
     * 一行三个数a，b，c (1 <= a, b, c <= 10)
     * <p>
     * 输出描述:
     * 能够获得的最大值
     * <p>
     * 输入例子1:
     * 1 2 3
     * <p>
     * 输出例子1:
     * 9
     *
     * @apiNote 思路：
     * 1.这题太水了，没一点用
     * 2.就四种情况，写出来比大小就行
     */
    public static int code(int a, int b, int c) {
        int max = Integer.MIN_VALUE;
        max = Math.max(max, (a + b) * c);
        max = Math.max(max, (a * b) + c);
        max = Math.max(max, a * (b + c));
        max = Math.max(max, a * b * c);
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(code(a, b, c));
    }
}
