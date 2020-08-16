package com.bins.question.math;


/**
 * @author leo-bin
 * @date 2020/8/16 10:05
 * @apiNote 有效的正方形
 * 来源：leetcode-593
 * 链接：https://leetcode-cn.com/problems/valid-square/
 */
public class ValidSquare {

    /**
     * 题目描述：
     * 1.给定二维空间中四点的坐标，返回四点是否可以构造一个正方形
     * 2.一个点的坐标（x，y）由一个有两个整数的整数数组表示
     * <p>
     * 示例:
     * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
     * 输出: True
     * <p>
     * 注意:
     * 所有输入整数都在 [-10000，10000] 范围内。
     * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
     * 输入点没有顺序
     *
     * @apiNote 思路：
     * 1.根据正方形的特性，求任意一个点到其他三个点的距离就行
     * 2.时间和空间都是O(1)
     */
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) && check(p2, p1, p3, p4) && check(p3, p1, p2, p4) && check(p4, p1, p2, p3);
    }

    public static boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a = (int) (Math.pow(Math.abs(p2[0] - p1[0]), 2) + Math.pow(Math.abs(p2[1] - p1[1]), 2));
        int b = (int) (Math.pow(Math.abs(p3[0] - p1[0]), 2) + Math.pow(Math.abs(p3[1] - p1[1]), 2));
        int c = (int) (Math.pow(Math.abs(p4[0] - p1[0]), 2) + Math.pow(Math.abs(p4[1] - p1[1]), 2));
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }
        return ((a == b) && (a + b) == c) || ((a == c) && (a + c) == b) || ((b == c) && (b + c) == a);
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {5, 0};
        int[] p3 = {5, 4};
        int[] p4 = {0, 4};
        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
