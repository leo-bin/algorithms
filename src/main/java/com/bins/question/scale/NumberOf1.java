package com.bins.question.scale;

/**
 * @author leo-bin
 * @date 2020/4/12 22:03
 * @apiNote 二进制中1的个数
 * 来源：leetcode-191
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1 {


    /**
     * 题目描述
     * 1.编写一个函数，输入是一个无符号整数(32位)
     * 2.返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     * <p>
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * <p>
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * <p>
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'
     *
     * @apiNote 思路：
     * 1.使用位运算解题
     * 2.注意的是-5的二进制原码是：1000 0101
     * 3.时间复杂度：O(1)（毕竟只有32位）
     * 4.空间复杂度：O(1)
     */
    public static int numberOf1(int n) {
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
