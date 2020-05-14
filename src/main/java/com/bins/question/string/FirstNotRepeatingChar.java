package com.bins.question.string;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/4/11 20:46
 * @apiNote 第一个不重复的字符
 */
public class FirstNotRepeatingChar {


    /**
     * 题目描述：
     * 1.在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符
     * 2.并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.先是一次循环统计出所有元素出现的次数，存在map中，key为元素本身，value是次数
     * 3.然后依次遍历str，通过map.get(str[i])是否等于1来判断是否返回当前下标
     * 4.遍历完还找不带返回-1
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int firstNotRepeatingChar(String str) {
        int len = str.length();
        //鲁棒
        if (len == 1) {
            return 0;
        }
        char[] chs = str.toCharArray();
        //1.统计次数，存map
        HashMap<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chs[i])) {
                int count = map.get(chs[i]);
                map.put(chs[i], ++count);
            } else {
                map.put(chs[i], 1);
            }
        }
        //2.找value等于1的key
        for (int i = 0; i < len; i++) {
            if (map.get(chs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "aacbbba";
        String str1 = "cababader";
        String str2 = "aaabbbbc";
        String str3 = "aaaaaaaaa";
        System.out.println(firstNotRepeatingChar(str));
        System.out.println(firstNotRepeatingChar(str1));
        System.out.println(firstNotRepeatingChar(str2));
        System.out.println(firstNotRepeatingChar(str3));
    }
}
