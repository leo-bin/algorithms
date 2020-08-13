package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/3/24 13:54
 * @apiNote 最大公约数
 */
public class MaxDivisor {

    /**
     * 求两个数的最大公约数（解法一：辗转相除，迭代版）
     *
     * @apiNote 思路：
     * 1.假设a=10，b=25，a%b=5
     * 2.然后a=10，b=5，10%5=0
     * 3.所以a和b的最大公约数就是5
     * 4.时间复杂度为：O(logn)
     * 5.空间复杂度：O(1)
     */
    public static int gcdV1(int a, int b) {
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }


    /**
     * 最小公倍数
     *
     * @apiNote 思路：
     * 1.因为，a*b=gcd*lcm
     * 2.所以，lcm=a*b/gcd
     */
    public static int lcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }


    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 25;
        System.out.println(gcdV1(num1, num2));
        System.out.println(lcm(num1, num2, gcdV1(num1, num2)));
    }
}
