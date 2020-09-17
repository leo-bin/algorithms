package com.bins.question.string;

/**
 * @author leo-bin
 * @date 2020/3/24 0:21
 * @apiNote 反转字符串
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
     * 2.时间复杂度：O(1)
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
        int len = str.length();
        if (len == 0) {
            return str;
        }
        char tmp;
        int left = -1;
        int right = len;
        char[] chs = str.toCharArray();
        while (++left < --right) {
            tmp = chs[right];
            chs[right] = chs[left];
            chs[left] = tmp;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println("解法一：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr(str));
        System.out.println("解法二：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr2(str));
        System.out.println("解法三：原始字符串为：" + str + "::::" + "经过反转之后的字符串为：" + reverseStr3(str));
    }
}
