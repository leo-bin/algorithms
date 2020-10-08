package com.bins.question.string;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/24 0:21
 * @apiNote 反转字符串
 * 来源：leetcode-344
 * 链接：https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

    /**
     * 反转字符串（解法一：暴力循环）
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(n)
     */
    public static String reverseStr(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] chs = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = chs.length - 1; i >= 0; i--) {
            result.append(chs[i]);
        }
        return result.toString();
    }

    /**
     * 反转字符串（解法二：递归解决）
     *
     * @apiNote 思路：
     * 1.每一次递归调用都去掉原来的第一个字符，然后在右边拼接上这个字符
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static String reverseStr2(String str) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }

    /**
     * 反转字符串（解法三：双指针同时遍历）
     *
     * @apiNote 思路：
     * 1.设定两个指针left，right
     * 2.left指向char[]最左边，right指向char[]最右边，同时遍历
     * 3.每次都交换left和right指向的值
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static String reverseStr3(String str) {
        //特判
        if (str == null || str.length() <= 0) {
            return str;
        }
        char tmp;
        int left = 0;
        int right = str.length() - 1;
        char[] chs = str.toCharArray();
        while (left++ < right--) {
            tmp = chs[right];
            chs[right] = chs[left];
            chs[left] = tmp;
        }
        return new String(chs);
    }

    /**
     * 题目描述：
     * 1.编写一个函数，其作用是将输入的字符串反转过来
     * 2.输入字符串以字符数组char[]的形式给出
     * 3.不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     * 4.你可以假设数组中的所有字符都是ASCII码表中的可打印字符。
     * <p>
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * <p>
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * @apiNote 思路：
     * 1.双指针交换
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println("解法一：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr(str));
        System.out.println("解法二：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr2(str));
        System.out.println("解法三：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr3(str));

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(s));
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
