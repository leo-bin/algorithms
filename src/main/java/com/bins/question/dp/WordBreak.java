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
     * 2.判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 3.拆分时可以重复使用字典中的单词。
     * 4.你可以假设字典中没有重复的单词。
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
        //用set来存储字典
        HashSet<String> set = new HashSet<>(wordDict);
        //1.创建dp数组
        boolean[] dp = new boolean[len + 1];
        //2.初始化dp数组(空字符串可以拆分成任何字典)
        dp[0] = true;
        //3.根据dp的状态公式填充dp数组
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                //注意这里，dp[j]是用来隔断字符的，如果dp[j]=false，说明，s[0-j+1]已经被分过了
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
