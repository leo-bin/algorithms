package com.bins.question.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/7/9 9:22
 * @apiNote 恢复空格
 * 来源：leetcode-面试题 17.13
 * 链接：https://leetcode-cn.com/problems/re-space-lcci/
 */
public class ReSpace {

    /**
     * 题目描述：
     * 1.哦，不！你不小心把一个长篇文章中的空格、标点都删掉了
     * 2.并且大写也弄成了小写
     * 3.像句子"I reset the computer. It still didn’t boot!"
     * 4.已经变成了"iresetthecomputeritstilldidntboot"
     * 5.在处理标点符号和大小写之前，你得先把它断成词语
     * 6.当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里
     * 7.假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数
     * <p>
     * 示例：
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     * <p>
     * 提示：
     * 0 <= len(sentence) <= 1000
     * dictionary中总字符数不超过 150000
     * 你可以认为dictionary和sentence中只包含小写字母
     *
     * @apiNote 思路：
     * 1.动态规划
     * 2.假设dp[i]代表句子前i个最少未识别字符串长度
     * 3.时间复杂度：O(n*n)
     * 4.空间复杂度：O(n)
     */
    public static int reSpace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];
        HashSet<String> set = new HashSet<>(new ArrayList<>(Arrays.asList(dictionary)));
        for (int i = 1; i <= len; i++) {
            //假设当前字符作为单词不在字典中，所以当前未匹配字符串长度就是之前的长度加上自己的长度，也就是1
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        String[] dictionary1 = {"looked", "just", "like", "her", "brother"};
        String sentence1 = "jesslookedjustliketimherbrother";
        System.out.println(reSpace(dictionary1, sentence1));

        String[] dictionary2 = {"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp", "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "pzpstvqzrzprqkkkd", "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj", "zk", "pqkjkzpvdpktzskdkvzjkkj", "sr", "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"};
        String sentence2 = "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr";
        System.out.println(reSpace(dictionary2, sentence2));
    }
}
