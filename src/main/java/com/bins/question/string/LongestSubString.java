package com.bins.question.string;


import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/3/17 21:38
 * @apiNote 字符串中最长的连续不重复子串
 */
public class LongestSubString {


    /**
     * 题目描述：
     * 1.已知一个字符串，求这个字符串中不包含重复字符的最长子串的长度
     * 2.如abba返回2，aaaaabc返回3，bbbbbbb返回1
     * 3.输入: "pwwkew",输出: 3
     * 4.输入: "dvdf",输出: 3
     *
     * @apiNote 思路：
     * 1.首先要注意是连续的字串
     * 2.我们可以用滑动窗口的思想
     * 3.设置一个start和end，start记录当前窗口的起始位置，end记录末尾
     * 4.因为要快速的判断当前元素是否和之前的元素重复了，所以这里使用map存
     * 5.如果出现重复的元素，那就移动start，end代表当前的元素
     * 6.这里需要注意的是我们应该如何正确的滑动，也就是如何更新start值
     * 7.假设有：dvdf，我们先将dv作为key存map，并且value是当前的位置的下一个位置
     * 8.当下次遇到d的时候我们只要将原来的d取出来，start值就是原来的d的下一个位置
     * 9.但是这里需要注意start值可能出现左移的情况，比如说abab
     * 10.所以为了防止start左移，我们需要保证start一直都是递增的（一直往右移）
     * 11.时间复杂度：O(n)
     * 12.空间复杂度：O(n)
     */
    public static int getLongestSubString(String str) {
        int len = str.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>(16);
        for (int start = 0, end = 0; end < len; end++) {
            //窗口右移
            if (map.containsKey(str.charAt(end))) {
                start = Math.max(start, map.get(str.charAt(end)));
            }
            //更新count
            maxCount = Math.max(maxCount, end - start + 1);
            //所有元素都要放map，并且value记录的是当前字符的下一个字符的位置
            map.put(str.charAt(end), end + 1);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        String str = "aabc";
        String str1 = "abc";
        String str2 = "a";
        System.out.println("字符" + str + "中的最长字串的长度为：" + getLongestSubString(str));
        System.out.println("字符" + str1 + "中的最长字串的长度为：" + getLongestSubString(str1));
        System.out.println("字符" + str2 + "中的最长字串的长度为：" + getLongestSubString(str2));
    }
}
