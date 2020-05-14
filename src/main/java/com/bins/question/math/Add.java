package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/4/12 10:13
 * @apiNote 不用加减乘除做加法
 */
public class Add {


    /**
     * 题目描述：
     * 1.写一个函数，求两个整数之和
     * 2.要求在函数体内不得使用+、-、*、/四则运算符号
     *
     * @apiNote 思路：
     * 1.使用异或和与的思想
     * 2.首先两个数的异或可以得到这两个数的和，但是不包括进制
     * 3.然后使用&运算并且对结果左移1位即可得到两个数相加的进位是多少
     * 4.循环判断，直到进位为0，推出循环，此时两个数相加的结果就是最终结果
     */
    public static int add(int num1, int num2) {
        int result, ans;
        do {
            // 每一位相加
            result = num1 ^ num2;
            // 进位
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }


    /**
     * @apiNote 思路：
     * 1.api解决
     */
    private static int addV2(int num1, int num2) {
        return Integer.sum(num1, num2);
    }


    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int num11 = 111;
        int num22 = 899;
        int num33 = 5;
        int num44 = 7;
        System.out.println("异或加移位操作：");
        System.out.println(add(num1, num2));
        System.out.println(add(num11, num22));
        System.out.println(add(num33, num44));
        System.out.println("api解决：");
        System.out.println(addV2(num1, num2));
        System.out.println(addV2(num11, num22));
        System.out.println(addV2(num33, num33));
    }
}
