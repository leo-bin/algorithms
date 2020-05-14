package com.bins.question.math;

import java.math.BigDecimal;

/**
 * @author leo-bin
 * @date 2020/4/10 15:17
 * @apiNote 开根号
 */
public class SquareRoot {


    /**
     * 题目描述：
     * 1.在没有任何数学库函数的情况下，求一个数 m 开 n 次方的结果
     * <p>
     * 输入描述:
     * 每组输入只有1行，包括有一个正实数m和一个正整数n，其中1 <= n <= 32, 1<=m<=2^n。
     * <p>
     * <p>
     * 输出描述:
     * 输出只有一行，打印m开n次方的结果，小数点后面保留12位
     * <p>
     * 输入例子1:
     * 2 10
     * <p>
     * 输出例子1:
     * 1.071773462536
     *
     * @apiNote 思路：
     * 1.解法一，调用api实现
     */
    public static double sqrt(int m, int n) {
        double result = Math.pow(m, 1.0 / n);
        BigDecimal bigDecimal = new BigDecimal(result);
        result = bigDecimal.setScale(12, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }


    /**
     * 解法二，自己实现幂次方的方法
     */
    public static double sqrtV2(int m, int n) {
        double result = 0.0;

        return result;
    }

    /**
     * 自己实现a的b次方
     *
     * @apiNote 思路：
     * 1.
     */
    public static double pow(double a, double b) {
        double result = 0.0;
        // TODO: BY leo-bin 2020/4/11
        // TODO-LIST: 未解决

        return result;
    }


    public static void main(String[] args) {
        int m = 2;
        int n = 10;
        int m1 = 27;
        int n1 = 3;
        System.out.println("方法一，api实现：");
        System.out.println(sqrt(m, n));
        System.out.println(sqrt(m1, n1));

    }
}
