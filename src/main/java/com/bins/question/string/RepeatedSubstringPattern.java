package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/8/25 14:04
 * @apiNote 重复的子字符串
 * 来源：leetcode-459
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

    /**
     * 题目描述：
     * 1.给定一个非空的字符串
     * 2.判断它是否可以由它的一个子串重复多次构成。
     * 3.给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例1
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * <p>
     * 示例2
     * 输入: "aba"
     * 输出: False
     * <p>
     * 示例3
     * 输入: "abcabcabcabc"
     * <p>
     * 输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     *
     * @apiNote 思路：
     * 1.这个解法太妙了，我只能想到暴力去匹配
     */
    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    /**
     * 解法二，暴力思想
     *
     * @apiNote 思路：
     * 1.类似于一个旋转的过程
     * 2.假设是abab
     * 3.我们从最后一个字符开始，将它移到最前面去，目的就是为了旋转
     * 4.现在是baba，我们接着旋转，现在就是abab
     * 5.可以看到通过我们不断的旋转，最终是可以得到我们的目标字符串的
     */
    public static boolean repeatedSubstringPatternV2(String s) {
        //特判
        if (s == null || s.length() <= 1) {
            return false;
        }
        String t = s;
        int len = s.length();
        while (len > 1) {
            t = t.charAt(t.length() - 1) + t.substring(0, t.length() - 1);
            if (s.equals(t)) {
                return true;
            }
            len--;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPatternV2(s));
        System.out.println(repeatedSubstringPattern(s));
    }
}
