package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/8/30 17:52
 * @apiNote 反转字符串中的单词
 * 来源：leetcode-557
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/comments/
 */
public class ReverseWords {

    /**
     * 题目描述：
     * 1.给定一个字符串
     * 2.你需要反转字符串中每个单词的字符顺序
     * 3.同时仍保留空格和单词的初始顺序
     * <p>
     * 示例：
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * <p>
     * 提示：
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * @apiNote 思路：
     * 1.暴力反转
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    static public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            builder.append(new StringBuilder(word).reverse()).append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
