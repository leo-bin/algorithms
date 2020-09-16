package com.bins.bishi.autumn2020.tianyiyun;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/16 19:32
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 读入一个自然数N，求按从小到大的顺序的第N个丑数并输出
     * 注：把只包含因子2、3和5的数称作丑数（Ugly Number）
     * 例如6、8都是丑数，但14不是，因为它包含因子7
     * 习惯上我们把1当做是第一个丑数
     * <p>
     * 输入描述:
     * 输入包括一个整数N(1<=N<=1500)
     * 输出描述:
     * 每输入一个测试数据，就输出第N个丑数
     * <p>
     * 示例1
     * 输入
     * 3
     * 输出
     * 3
     * <p>
     * 示例2
     * 输入
     * 7
     * 输出
     * 8
     *
     * @apiNote 思路：
     * 1.暴力匹配
     * 2.只a了70%
     */
    public static int code(int n) {
        //特判
        if (n < 7) {
            return n;
        }
        int target = 6, count = 6;
        for (int i = 7; count < n; i++) {
            if (check(i)) {
                target = i;
                count++;
            }
        }
        return target;
    }

    /**
     * 校验是否是丑数
     */
    public static boolean check(int n) {
        if (n % 2 == 0) {
            n /= 2;
        }
        if (n % 3 == 0) {
            n /= 3;
        }
        if (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(code(n));
    }
}
