package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/6/19 9:49
 * @apiNote 验证回文串
 * 来源：leetcode-125
 * 链接:https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindromeⅡ {

    /**
     * 题目描述：
     * 1.给定一个字符串，验证它是否是回文串
     * 2.只考虑字母和数字字符，可以忽略字母的大小写
     * 3.说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     *
     * @apiNote 思路：
     * 1.双指针思想，但是这里直接对String做正则的话速度太慢了
     * 2.我们选择自己做匹配
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static boolean isPalindrome(String s) {
        char[] chs = s.toLowerCase().toCharArray();
        int len = chs.length;
        for (int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
            while (i < len && !isMatch(chs[i])) {
                i++;
            }
            while (j >= 0 && !isMatch(chs[j])) {
                j--;
            }
            if (i < len && j >= 0 && (chs[i] != chs[j])) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断字符是否满足英文，数字
     */
    public static boolean isMatch(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
    }


    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
    }
}
