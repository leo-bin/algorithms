package com.bins.bishi.autumn2020.jingdong.practice;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/5 9:49
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.数列的定义如下：
     * 2.数列的第一项为n，以后各项为前一项的平方根
     * 3.求数列的前m项的和。
     * <p>
     * 输入描述
     * 输入数据有多组，每组占一行
     * 由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
     * <p>
     * 输出描述
     * 对于每组输入数据，输出该数列的和
     * 每个测试实例占一行，要求精度保留2位小数。
     * <p>
     * 样例输入
     * 81 4
     * 2 2
     * <p>
     * 样例输出
     * 94.73
     * 3.41
     *
     * @apiNote 思路：
     * 1.
     */
    public static void code(int n, int m) {
        double result = 0.0;
        double db = n;
        for (int i = 0; i < m; i++) {
            result += db;
            db = Math.sqrt(db);
        }
        //保留两位小数
        System.out.printf("%.2f", result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            code(n, m);
            System.out.println();
        }
    }
}
