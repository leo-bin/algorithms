package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/4/11 21:22
 * @apiNote 求1+2+3+。。。n的和
 * 来源：leetcode面试题64，剑指offer原题
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumOf1AndN {


    /**
     * 题目描述：
     * 1.求1+2+3+...+n
     * 2.要求不能使用乘除法
     * 3.也不能用for、while、if、else、switch、case等关键字
     * 4.也不能使用条件判断语句（A?B:C）
     *
     * @apiNote 思路：
     * 1.不能使用循环那就说明要使用递归
     * 2.不能用if和while说明条件运算只能使用&&或者||的短路特性来做条件的判断
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int sumOf1AndN(int n) {
        boolean flag = (n > 0) && ((n += sumOf1AndN(n - 1)) > 0);
        return n;
    }


    public static void main(String[] args) {
        int n = 8;
        for (int i = 1; i <= n; i++) {
            System.out.println(sumOf1AndN(i));
        }
    }
}
