package com.bins.question.others;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/4/22 12:14
 * @apiNote 反转整型
 */
public class ReverseInt {


    /**
     * 题目描述：
     * 1.给出一个 32位的有符号整数，你需要将这个整数中每位上的数字进行反转
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * <p>
     * 注意:
     * 1.假设我们的环境只能存储得下32位的有符号整数，则其数值范围为[−2^31, 2^31 − 1]
     * 2.请根据这个假设，如果反转后整数溢出那么就返回0
     *
     * @apiNote 思路：
     * 1.暴力+栈
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int reverseInt(int x) {
        //鲁棒
        if (x == 0) {
            return 0;
        }
        //符号位
        int flag = x > 0 ? 1 : -1;
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            //去掉符号位
            if (str.charAt(i) != '-') {
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        long result = Long.parseLong(stringBuilder.toString());
        //通过和自己比较判断是否溢出
        return (int) result != result ? 0 : (int) result * flag;
    }


    /**
     * 解法二，贪心+数学技巧
     *
     * @apiNote 思路：
     * 1.因为最后一位变成了第一位，所以从最后一位开始每次*10
     * 2.直到为0
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int reverseIntV2(int x) {
        //鲁棒
        if (x == 0) {
            return x;
        }
        long result = 0;
        while (x != 0) {
            //得到最后一位，然后*10
            result = result * 10 + x % 10;
            //去掉最后一位
            x = x / 10;
        }
        return (int) result != result ? 0 : (int) result;
    }


    public static void main(String[] args) {
        int n = 123;
        int n1 = -123;
        int n2 = 333333;
        int n3 = -45678910;
        int n4 = 1234567899;
        System.out.println(reverseInt(n));
        System.out.println(reverseInt(n1));
        System.out.println(reverseInt(n2));
        System.out.println(reverseInt(n3));
        System.out.println(reverseInt(n4));
    }
}
