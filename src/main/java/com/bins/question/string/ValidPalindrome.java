package com.bins.question.string;


/**
 * @author leo-bin
 * @date 2020/5/19 9:34
 * @apiNote 验证回文字符串 Ⅱ
 * 来源：leetcode-680
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {


    /**
     * 题目描述：
     * 1.给定一个非空字符串 s，最多删除一个字符
     * 2.判断是否能成为回文字符串
     * <p>
     * 示例 1:
     * 输入: "aba"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符
     * <p>
     * 注意:
     * 1.字符串只包含从 a-z 的小写字母
     * 2.字符串的最大长度是50000
     *
     * @apiNote 思路：
     * 1.双指针解法
     * 2.我们可以通过设定两个指针left和right分别从前往后和从后往前扫面字符串
     * 3.如果出现不相等，那就需要判断删除哪一个字符才能使得删除之后的字符是回文字符
     * 4.这里有一种很牛逼的思路就是，当此时我们找到s.left!=s.right时
     * 5.我们只需要分别判断子串：
     * 6.s[left+1,right]和s[left,right-1]其中有一个是回文的，那么结果就一定是回文
     * 7.比如说，s="abdda",此时的left指向b,right指向d
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(1)
     */
    public static boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 验证是否是回文字符串
     */
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "a";
        String s4 = "aa";
        String s5 = "ab";
        String s6 = "aabb";
        String s7 = "bddb";
        String s8 = "cbbcc";
        System.out.println(validPalindrome(s1));
        System.out.println(validPalindrome(s2));
        System.out.println(validPalindrome(s3));
        System.out.println(validPalindrome(s4));
        System.out.println(validPalindrome(s5));
        System.out.println(validPalindrome(s6));
        System.out.println(validPalindrome(s7));
        System.out.println(validPalindrome(s8));
    }
}
