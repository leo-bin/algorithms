package com.bins.question.string;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/17 18:40
 * @apiNote 字母异味词分组
 * 来源：leetcode-49
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    /**
     * 题目描述：
     * 1.给定一个字符串数组，将字母异位词组合在一起
     * 2.字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * <p>
     * 说明：
     * 所有输入均为小写字母
     * 不考虑答案输出的顺序
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.直接拿到一个字符串就进行排序，得到的就是一个key
     * 3.使用hash表来去重就行
     * 4.时间复杂度：O(n*m*(log(m)))
     * 5.空间复杂度：O(n*m)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>(16);
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.自定义hash规则
     * 2.时间复杂度：(n*m)
     * 3.空间复杂度：(n*m)
     */
    public static List<List<String>> groupAnagramsV2(String[] strs) {
        //使用一个从小到大质数序列分别代表26哥英文字母
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        Map<Integer, ArrayList<String>> map = new HashMap<>(16);
        for (String s : strs) {
            int key = 1;
            char[] chs = s.toCharArray();
            for (char c : chs) {
                key *= primes[c - 'a'];
            }
            // 把单词添加到哈希值相同的分组
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagramsV2(strs);
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
