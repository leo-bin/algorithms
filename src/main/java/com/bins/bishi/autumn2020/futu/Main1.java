package com.bins.bishi.autumn2020.futu;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/23 18:05
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 2020年，直播已经成为去哪儿网酒店预售的新武器
     * 去哪儿网CEO刚哥想从公司的m名员工中挑选n名参与自己的直播
     * 已知m小于100请问一共有多少种选法
     * <p>
     * 输入描述
     * m（公司员工数）
     * n （挑选的员工数）
     * <p>
     * 输出描述
     * p(挑选方法)
     * <p>
     * 样例输入
     * 4
     * 2
     * 样例输出
     * 6
     *
     * @apiNote 思路：
     * 1.求阶乘问题，递归解决
     * 2.ac了36%，肯定是溢出了
     */

    /**
     * n的阶乘
     */
    public static long fac(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //特判
        if (m <= 0 || n <= 0) {
            System.out.println(0);
        } else if (m < n) {
            System.out.println(0);
        } else if (m == n) {
            System.out.println(1);
        } else {
            System.out.println(fac(m) / (fac(n) / fac(m - n)));
        }*/
        System.out.println(fac(20));
    }
}
