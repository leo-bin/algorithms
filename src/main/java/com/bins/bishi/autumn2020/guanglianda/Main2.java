package com.bins.bishi.autumn2020.guanglianda;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/22 11:54
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.有一种排序算法定义如下
     * 2.该排序算法每次只能把一个元素提到序列的开头
     * 3.例如2，1，3，4
     * 4.只需要一次操作把1提到序列起始位置就可以使得原序列从小到大有序
     * 5.现在给你个乱序的1-n的排列，请你计算最少需要多少次操作才可以使得原序列从小到大有序。
     * <p>
     * 输入描述
     * 输入第一行包含一个正整数n ，表示序列的长度。(1<=n<=100000)
     * 接下来一行有n个正整数，表示序列中的n个元素，中间用空格隔开。(1<=a_i<=n)
     * <p>
     * 输出描述
     * 输出仅包含一个整数，表示最少的操作次数
     * <p>
     * 样例输入
     * 4
     * 2 1 3 4
     * 样例输出
     * 1
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(int[] nums) {

        return 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(code(nums));
    }
}
