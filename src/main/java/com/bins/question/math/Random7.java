package com.bins.question.math;

import java.util.Random;

/**
 * @author leo-bin
 * @date 2020/9/4 22:10
 * @apiNote 使用random7实现random7
 * 来源：leetcode-470
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 */
public class Random7 {

    private static Random random = new java.util.Random();

    /**
     * 随机返回0-7之前的一个随机数
     */
    public static int random7() {
        return random.nextInt(7) + 1;
    }

    /**
     * 题目描述：
     * 1.使用random7实现random10
     * 2.已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数
     * 3.试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数
     * 4.不要使用系统的 Math.random() 方法
     *
     * @apiNote 思路：
     * 1.首先不管怎么样我们只有一个random7，如果想要生成一个1-10的数的话只能做加法或者惩乘法运算
     * 2.如果是直接使用惩乘法：random7*random7，那么生成的结果不一定是等概率的
     * 3.如果直接使用加法运算呢？random7+random7，这个也是不公平的，可以自己写一些测试数据看看
     * 4.我们一般都是使用：(random7-1)*7+random7来生成1-49之间的数
     * 5.而且这样子计算出的结果一定是等概率的，这一点也可以试着写一些测试数据看看
     * 6.时间复杂度：O(1)
     * 7.空间复杂度：O(1)
     */
    public static int random10() {
        int n;
        do {
            n = (random7() - 1) * 7 + random7();
        } while (n > 40);
        return n % 10 + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            System.out.println(random10());
        }
    }
}
