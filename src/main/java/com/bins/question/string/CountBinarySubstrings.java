package com.bins.question.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/10 15:08
 * @apiNote 计数二进制子串
 * 来源：leetcode-696
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings {

    private static int count = 0;

    /**
     * 题目描述：
     * 1.给定一个字符串 s
     * 2.计算具有相同数量0和1的非空(连续)子字符串的数量
     * 3.并且这些子字符串中的所有0和所有1都是组合在一起的
     * 4.重复出现的子串要计算它们出现的次数。
     * <p>
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * <p>
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0
     * <p>
     * 注意：
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符
     *
     * @apiNote 思路：
     * 1.暴力回溯
     * 2.思路肯定是正确的，代码也没问题
     * 3.但是遇到了特别变态的测试用例比如说字符串非常大，基本就没用了
     */
    public static int countBinarySubstrings(String s) {
        char[] chs = s.toCharArray();
        backtrace(chs, new StringBuilder(), 0);
        return count;
    }

    /**
     * 回溯求连续的子序列组合
     */
    public static void backtrace(char[] chs, StringBuilder builder, int index) {
        //递归结束条件
        if (builder.length() > chs.length) {
            return;
        }
        if ((builder.length() & 1) == 0 && check(builder.toString())) {
            count++;
        }
        //接着找连续子串
        for (int i = index; i < chs.length; i++) {
            //保证连续
            if (i > index && (i - index) >= 1 && builder.length() != 0) {
                continue;
            }
            builder.append(chs[i]);
            backtrace(chs, builder, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    /**
     * 判断子字符串是否满足条件
     */
    public static boolean check(String s) {
        if (s.length() <= 1) {
            return false;
        }
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        boolean result = false;
        StringBuilder builder = new StringBuilder();
        int i = right.length();
        while (i-- > 0) {
            builder.append(1);
        }
        long target = Long.parseLong(builder.toString());

        if (l == 0) {
            result = r == target;
        } else if (r == 0) {
            result = l == target;
        }
        return result;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.贪心
     */
    public static int countBinarySubstringsV2(String s) {
        List<Integer> counts = new ArrayList<>();
        char[] chs = s.toCharArray();
        int cur = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == chs[i - 1]) {
                cur++;
            } else {
                counts.add(cur);
                cur = 1;
            }
        }
        counts.add(cur);

        //统计相邻的count中的最小值的总和
        int sum = 0;
        for (int i = 0; i < counts.size() - 1; i++) {
            sum += Math.min(counts.get(i), counts.get(i + 1));
        }
        return sum;
    }


    public static void main(String[] args) {
        String s1 = "00110011";
        String s2 = "10101";
        String s3 = "000111000";
        System.out.println(countBinarySubstringsV2(s2));
    }
}
