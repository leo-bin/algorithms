package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/9/10 15:06
 * @apiNote 外观数列
 * 来源：leetcode-38
 * 链接：https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay {

    /**
     * 题目描述：
     * 1.给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项
     * 2.注意：整数序列中的每一项将表示为一个字符串
     * 3.「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述
     * 4.前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
     * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
     * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
     * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
     * <p>
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     * 解释：这是一个基本样例
     * <p>
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"
     * 也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"
     * 所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"
     *
     * @apiNote 思路：
     * 1.一开始想着暴力去做的，但是觉得暴力的做法太low了，没想到题解全是暴力，效率还不错
     * 2.时间复杂度：O(n*m)
     * 3.空间复杂度：O(n)
     */
    public static String countAndSay(int n) {
        //递归结束条件
        if (n == 1) {
            return "1";
        }
        StringBuilder builder = new StringBuilder();
        String pre = countAndSay(n - 1);
        //统计上一个结果
        for (int i = 0; i < pre.length(); i++) {
            int j = i + 1, count = 1;
            char cur = pre.charAt(i);
            while (j < pre.length() && cur == pre.charAt(j++)) {
                i++;
                count++;
            }
            builder.append(count).append(cur);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
