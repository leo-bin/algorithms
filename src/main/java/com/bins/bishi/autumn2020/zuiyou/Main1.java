package com.bins.bishi.autumn2020.zuiyou;

import java.math.BigInteger;

/**
 * @author leo-bin
 * @date 2020/9/10 18:13
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：实现36进制转10进制
     * 请实现一个36进制转10进制的函数，不能用语言已有库函数直接转化
     * 请注意转化出来的长整型能支持的最大值：9223372036854775807和最小值：-9223372036854775807
     * <p>
     * 输入描述:
     * 输入参数类型为：36进制字符串，要支持转长整型最大值是"1y2p0ij32e8e7"
     * <p>
     * 输出描述:
     * 符合条件输出转化的长整型，不符合条件的输入转化后输出0
     * 超过最大或最小输入则只输出转化后能支持的最大或最小长整型值
     * <p>
     * 示例1
     * 输入
     * 1y2p0ij32e8e7
     * <p>
     * 输出
     * 9223372036854775807
     * <p>
     * 示例2
     * 输入
     * -sgsf
     * <p>
     * 输出
     * -1328127
     * 说明
     * 36进制负数转化成十进制也是负数
     * <p>
     * 示例3
     * 输入
     * zzzzzzzzzzzzz
     * <p>
     * 输出
     * 9223372036854775807
     * <p>
     * 说明
     * 超过最大输入则只输出转化后能支持的最大长整型值
     * <p>
     * 示例4
     * 输入
     * &avd1
     * 输出
     * 0
     * 说明
     * 不符合要求的输入输出0
     *
     * @apiNote 思路：
     * 1.调用api实现36进制转10进制
     */
    public static long code(String s) {
        try {
            BigInteger integer = new BigInteger(s, 36);
            return Long.parseLong(integer.toString(10));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 手写
     *
     * @apiNote 思路：
     * 1.直接算呗
     */
    public static long code2(String s) {
        //特判
        if (s.length() <= 0) {
            return 0;
        }
        //考虑负数
        int flag = 1;
        if (s.charAt(0) == '-') {
            flag = -1;
        }
        //构造36进制表
        int[] words = new int[150];
        for (int i = 0, a = 0; i <= 9; i++, a++) {
            words[i] = a;
        }
        for (int i = 97, a = 10; i <= 122; i++, a++) {
            words[i] = a;
        }
        long result = 0;
        //负数的话首位不需要参与计算
        int limit = flag == 1 ? -1 : 0;
        for (int i = 0, j = s.length() - 1; i < s.length() && j > limit; i++, j--) {
            result += Math.pow(36, i) * words[s.charAt(j)];
        }
        return result * flag;
    }

    public static void main(String[] args) {
        String s = "-sgsf";
        System.out.println(code(s));
        System.out.println(code2(s));
    }
}
