package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/5/21 17:41
 * @apiNote 是否是回文数
 * 来源：leetcode-9
 * 链接：https://leetcode-cn.com/problems/palindrome-number/
 */
public class IsPalindrome {


    /**
     * 题目描述：
     * 1.判断一个整数是否是回文数
     * 2.回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
     * <p>
     * 示例 1:
     * 输入: 121
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * <p>
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * @apiNote 思路：
     * 1.双指针的思想
     * 2.left指针指向头，right指针指向尾
     * 3.只有s.left==s.right,才能继续扫描，否则不是回文
     * 4.时间复杂度O(n)
     * 5.空间复杂度：O(1)
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
