package com.bins.bishi.autumn2020.yongyou;

/**
 * @author leo-bin
 * @date 2020/8/18 15:35
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给定一个字符串（只包含大小写英文字母， a 到 z ）
     * 2.利用字符连续重复出现的次数，编写一种压缩算法，实现字符串压缩功能
     * 比如，字符串 abbcccaadddd 会变为 a1b2c3a2d4 。
     * 要求：压缩后的长度必须始终小于或等于原字符串长度，否则返回原先的字符串
     * <p>
     * 示例1
     * 输入
     * "abbccdddaaaa"
     * <p>
     * 输出
     * "a1b2c2d3a4"
     * <p>
     * 说明
     * "abbccdddaaaa"压缩后为"a1b2c2d3a4"，比原字符串长度短
     * <p>
     * 示例2
     * 输入
     * "abccd"
     * <p>
     * 输出
     * "abccd"
     * <p>
     * 说明
     * "abccd"压缩后为"a1b1c2d1"，比原字符串长度更长
     *
     * @apiNote 思路：
     * 1.暴力匹配
     * 2.
     */
    public static String compress(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length - 1; ) {
            int count = 1;
            int j = i + 1;
            while (j < chs.length && chs[i] == chs[j]) {
                count++;
                j++;
            }
            builder.append(chs[i]).append(count);
            i += count;
        }
        String result = builder.toString();
        return result.length() <= str.length() ? result : str;
    }


    public static void main(String[] args) {
        String str1 = "abbccdddaaaa";
        String str2 = "abccd";
        System.out.println(compress(str1));
        System.out.println(compress(str2));
    }
}
