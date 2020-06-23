package com.bins.question.scale;

/**
 * @author leo-bin
 * @date 2020/6/23 9:40
 * @apiNote 二进制求和
 * 来源：leetcode-67
 * 链接：https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary {

    /**
     * 题目描述：
     * 1.给你两个二进制字符串，返回它们的和（用二进制表示）
     * 2.输入为 非空 字符串且只包含数字 1 和 0
     * <p>
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     * <p>
     * 提示：
     * 每个字符串仅由字符 '0' 或 '1' 组成
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        //进位
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            result.append(carry <= 1 ? carry : carry % 2);
            carry = carry <= 1 ? 0 : 1;
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String a1 = "11";
        String b1 = "1";
        String a2 = "1010";
        String b2 = "1011";
        String a3 = "1111";
        String b3 = "1111";
        System.out.println(addBinary(a1, b1));
        System.out.println(addBinary(a2, b2));
        System.out.println(addBinary(a3, b3));
    }
}
