package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/5/14 11:08
 * @apiNote 找不同
 * 来源：leetcode-389
 * 链接：https://leetcode-cn.com/problems/find-the-difference/
 */
public class FindTheDifference {


    /**
     * 题目描述：
     * 1.给定两个字符串 s 和 t，它们只包含小写字母
     * 2.字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母
     * 3.请找出在 t 中被添加的字母
     * <p>
     * 示例:
     * 输入：
     * s = "abcd"
     * t = "abcde"
     * <p>
     * 输出：
     * e
     * 解释：
     * 'e' 是那个被添加的字母
     *
     * @apiNote 思路：
     * 1.虽然这个题目给你的是字符串让你返回字符
     * 2.但是我们需要知道的是，字符的本质其实就是ascci码
     * 3.而assci码就是数字
     * 4.所以我们可以继续使用异或的思想！
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static char findTheDifference(String s, String t) {
        char xor = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            xor ^= s.charAt(i);
            xor ^= t.charAt(i);
        }
        xor ^= t.charAt(i);
        return xor;
    }



    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }
}
