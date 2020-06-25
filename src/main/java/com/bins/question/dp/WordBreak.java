package com.bins.question.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/3/26 10:20
 * @apiNote 单词拆分
 */
public class WordBreak {

    /**
     * 单词拆分
     * 1.给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict
     * 2.判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
     * 3.拆分时可以重复使用字典中的单词
     * 4.你可以假设字典中没有重复的单词
     * <p>
     * 示例 1：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"
     * <p>
     * 示例 2：
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"
     * 注意你可以重复使用字典中的单词。
     * <p>
     * 示例 3：
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.设dp[i]为，s[0-i]是否存在于字典中
     * 3.只有当s[0-i]存在于字典中，dp[i]=true
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(n)
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        //1.字典使用set而不是list是要加快contains速度，list中contains是全文遍历O(n)，而set是哈希表O(1)
        HashSet<String> set = new HashSet<>(wordDict);
        //2.遍历s同时构造单独的单词去字典中判断是否存在
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                //3.dp[j]的作用是判断当前是否可以拆，为true说明在j之前的单词已经拆过了，所以这里j可以继续拆
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        //test1
        String s1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println("字符：" + s1 + "被空格拆分之后的字符，是否存在于字典：" + wordDict1.toString() + "中：" + wordBreak(s1, wordDict1));

        //test2
        String s2 = "applepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple");
        wordDict2.add("pen");
        System.out.println("字符：" + s2 + "被空格拆分之后的字符，是否存在于字典：" + wordDict2.toString() + "中：" + wordBreak(s2, wordDict2));

        //test3
        String s3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");
        System.out.println("字符：" + s3 + "被空格拆分之后的字符，是否存在于字典：" + wordDict3.toString() + "中：" + wordBreak(s3, wordDict3));
    }
}
