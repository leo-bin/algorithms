package com.bins.bishi.autumn2020.nowcoder;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/17 19:39
 * @apiNote code1
 */
public class Main1 {

    /**
     * 第一题
     *
     * @param x 每天的房租费
     * @param f 初始时拥有的苹果
     * @param d 初始时拥有的钱
     * @param p 一个水果的价格
     * @apiNote 思路：
     * 1.我们可以将问题分为两个阶段来看
     * 2.第一阶段：不用买水果，吃现成的，那么一天的花费就等于：x
     * 3.第三阶段：既要付房租还要买水果，所以一天的花费就等于：x+p
     * 4.第一阶段的天数其实就是f，并且第一阶段花了：stage1Cost=f*p
     * 5.第二阶段的天数的就是：(初始时的钱-第一阶段花的钱)/(第二阶段的花费）
     * 6.写成公式就是：(d-stage1Cost)/(x+p)
     * 7.但是我们还需要考虑初始时的钱够不够撑过第一阶段的！
     * 8.也就是说如果：d/x<f,那说明一开始的钱都不够f天！
     * 9.那么就没有第二阶段了！那么我们直接就能算出总天数=d/x
     */
    public static int code1(int x, int f, int d, int p) {
        //特判
        if (d / x < f) {
            return d / x;
        }
        int stage1Cost = f * x;
        int stage2 = (d - stage1Cost) / (x + p);
        return stage2 + f;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(code1(x, f, d, p));
    }
}
