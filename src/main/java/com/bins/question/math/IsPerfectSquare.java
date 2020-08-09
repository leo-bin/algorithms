package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/8/9 17:38
 * @apiNote 有效的完全平方数
 * 来源：leetcode-367
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    /**
     * 题目描述：
     * 1.给定一个正整数 num
     * 2.编写一个函数，如果 num 是一个完全平方数，则返回 True
     * 3.否则返回 False
     * 4.说明：不要使用任何内置的库函数，如sqrt
     * <p>
     * 示例 1：
     * 输入：16
     * 输出：True
     * <p>
     * 示例 2：
     * 输入：14
     * 输出：False
     *
     * @apiNote 思路：
     * 1.使用二分法来不断的逼近最终的值
     * 2.如果满足完全平方数那么最终逼近的值就一定是等于目标值，反之则不是
     * 3.时间复杂度：O(log(n))
     * 4.空间复杂度：O(1)
     */
    public static boolean isPerfectSquare(int num) {
        //特判
        if (num < 2) {
            return true;
        }
        long left = 1;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 36; i++) {
            System.out.println("数字" + i + "：" + isPerfectSquare(i));
        }
    }
}
