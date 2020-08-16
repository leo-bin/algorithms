package com.bins.question.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/16 10:47
 * @apiNote 第N个数字
 * 来源：leetcode-400
 * 链接：https://leetcode-cn.com/problems/nth-digit/
 */
public class FindNthDigit {

    /**
     * 题目描述：
     * 1.在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第n个数字
     * 2.注意:n是正数且在32位整数范围内 ( n < 2^31)
     * <p>
     * 示例 1:
     * 输入:
     * 3
     * <p>
     * 输出:
     * 3
     * <p>
     * 示例 2:
     * 输入:
     * 11
     * <p>
     * 输出:
     * 0
     * <p>
     * 说明:
     * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分
     *
     * @apiNote 思路：
     * 1.
     */
    public static int findNthDigit(int n) {
        long num = n;
        long size = 1;
        long max = 9;
        while (n > 0) {
            //判断不在当前位数内
            if (num - max * size > 0) {
                num = num - max * size;
                size++;
                max = max * 10;
            } else {
                long count = num / size;
                long left = num % size;
                if (left == 0) {
                    return (int) (((long) Math.pow(10, size - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, size - 1) + count) / ((long) Math.pow(10, (size - left))) % 10);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 11;
        for (int i = 1; i <= n; i++) {
            System.out.println(findNthDigit(i));
        }
    }
}
