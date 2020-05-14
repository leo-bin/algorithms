package com.bins.question.scale;

/**
 * @author leo-bin
 * @date 2020/4/12 22:03
 * @apiNote 二进制中1的个数
 */
public class NumberOf1 {


    /**
     * 题目描述
     * 1.输入一个整数，输出该数二进制表示中1的个数
     * 2.其中负数用补码表示
     *
     * @apiNote 思路：
     * 1.使用位运算解题
     * 2.注意的是-5的二进制原码是：1000 0101
     */
    public static int numberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }


    public static void main(String[] args) {
        int n = 5;
        int n1 = -5;
        System.out.println(n + "的二进制数中有" + numberOf1(n) + "个1");
        System.out.println(n1 + "的二进制数中有" + numberOf1(n1) + "个1");
    }
}
