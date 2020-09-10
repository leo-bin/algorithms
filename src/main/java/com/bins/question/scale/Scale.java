package com.bins.question.scale;

/**
 * @author leo-bin
 * @date 2020/9/10 21:44
 * @apiNote
 */
public class Scale {

    /**
     * 题目描述：
     * 1.32进制转10进制
     *
     * @apiNote 思路：
     * 1.
     */
    public static String change10To32(String num) {
        int f = 10;
        int t = 32;
        return new java.math.BigInteger(num, f).toString(t);
    }

    public static String change32To10(String num) {
        int f = 32;
        int t = 10;
        return new java.math.BigInteger(num, f).toString(t);
    }

    public static void main(String[] args) {

    }
}
