package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/9/10 15:38
 * @apiNote 加一
 * 来源：leetcode-66
 * 链接：https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    /**
     * 题目描述：
     * 1.给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
     * 2.最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
     * 3.你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321
     *
     * @apiNote 思路：
     * 1.暴力匹配
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        digits[0] = 1;
        return result;
    }


    public static void main(String[] args) {

    }
}
