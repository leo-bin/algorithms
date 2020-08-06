package com.bins.bishi.autumn2020.jingdong.bishi;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/6 18:02
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述：
     * 求以下数列的和：
     * 1.f(n)=1/5-1/10+1/15-1/20+1/25-......+1/(5*(2*n-1))-1/(5*2*n)
     * <p>
     * 输入描述
     * 单组输入
     * 每组数据一个输入，每个输入一行，输入n。（n<=100）
     * <p>
     * 输出描述
     * 输出数列前n项的和，结果四舍五入保留四位小数。
     * <p>
     * 样例输入
     * 1
     * <p>
     * 样例输出
     * 0.1000
     *
     * @apiNote 思路：
     * 1.暴力就是干
     * 2.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            result += (1.0 / (5 * (2 * i - 1))) + ((1.0 / (5 * 2 * i)) * -1);
        }
        System.out.printf("%.4f", result);
    }
}
