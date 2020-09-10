package com.bins.bishi.autumn2020.tuhu;


/**
 * @author leo-bin
 * @date 2020/9/10 19:56
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 对于给定的非负整数r和n（r≤n），请编写程序计算组合数C(r,n) = n! / r! / (n-r)!。
     * （本题目用于测试的所有用例，都保证结果小于231-1）
     * <p>
     * 示例1
     * 输入
     * 2,3
     * 输出
     * 3
     *
     * @apiNote 思路：
     * 1.为什么只过了37%？
     * 2.
     */
    public static int code(int r, int n) {
        if (r == n) {
            return 1;
        }
        return (int) (combine(n) / combine(r) / combine(n - r));
    }

    /**
     * n的阶乘
     */
    public static long combine(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * combine(n - 1);
    }

    public static void main(String[] args) {
        int r = 3;
        int n = 3;
        System.out.println(code(r, n));
    }
}
