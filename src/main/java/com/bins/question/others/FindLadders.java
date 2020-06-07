package com.bins.question.others;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/6/7 12:43
 * @apiNote 单词接龙 Ⅰ
 * 来源：leetcode-127
 * 链接：https://leetcode-cn.com/problems/word-ladder/
 */
public class FindLadders {

    /**
     * 题目描述：
     * 1.给定两个单词（beginWord 和 endWord）和一个字典
     * 2.找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * 3.每次转换只能改变一个字母。
     * 4.转换过程中的中间单词必须是字典中的单词。
     * <p>
     * 说明:
     * 1.如果不存在这样的转换序列，返回 0。
     * 2.所有单词具有相同的长度。
     * 3.所有单词只由小写字母组成。
     * 4.字典中不存在重复的单词。
     * 5.你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * <p>
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出: 5
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。
     * <p>
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * 输出: 0
     * 解释: endWord "cog" 不在字典中，所以无法进行转换
     *
     * @apiNote 思路：
     * 1.bfs+图的广度优先搜索
     * 2.这个题目的难点就在于如何联想到图上面
     * 3.要不然其他的做法都是超时！
     */
    public static int ladderLnegth(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        //bfs队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //统计已经访问过的单词
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        //开始bfs搜索构建邻接图
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] chs = curWord.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char curChar = chs[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == curChar) {
                            continue;
                        }
                        //替换掉
                        chs[j] = k;
                        String nextWord = new String(chs);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                        }
                        //恢复原来的状态
                        chs[j] = curChar;
                    }
                }
            }
            step++;
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
