package com.bins.bishi.autumn2020.tencent;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/23 19:46
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述
     * 有一个数字n，现在想把这个数字拆成两个非负整数a和b，使得a+b=n
     * 对于每一种方案，我们定义一个价值val=s(a)+s(b)
     * 其中s(x)代表x的数位和，例如数字x = 1234，那么s(x) = 1 + 2 + 3 + 4 = 10。
     * 现在想让你求可以选择的方案中val值最大的为多少？
     * <p>
     * 输入描述:
     * 第一行输入一个整数T，代表接下来有T组测试数据。
     * 对于每一组测试数据，输入一个整数n。
     * 1 <= T <= 100
     * 1 <= n <= 10^12
     * <p>
     * 输出描述:
     * 对于每一组测试数据，输出最大的价值为多少
     * <p>
     * 示例1
     * 输入
     * 1
     * 35
     * <p>
     * 输出
     * 17
     * <p>
     * 说明
     * 35 = 19 + 16
     * val = 1 + 9 + 1 + 6
     * 这是所有可能中最大值。
     * 35 = 29  + 6也是可行的解
     *
     * @apiNote 思路：
     * 1.
     */


    /**
     * 分别位数之和
     */
    public static long check(long a) {
        long sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long n = scanner.nextInt();
            long max = 0;
            for (int j = 1; j <= n; j++) {
                long a = j;
                long b = n - j;
                max = Math.max(max, check(a) + check(b));
            }
            System.out.println(max);
        }
    }
}
