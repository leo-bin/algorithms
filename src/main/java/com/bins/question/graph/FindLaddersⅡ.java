package com.bins.question.graph;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/6/7 10:37
 * @apiNote 单词接龙
 * 来源：leetcode-126
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii/
 */
public class FindLaddersⅡ {


    private static List<List<String>> result = new ArrayList<>();
    private static int minSize = Integer.MAX_VALUE;


    /**
     * 题目描述：
     * 1.给定两个单词（beginWord 和 endWord）和一个字典 wordList
     * 2.找出所有从 beginWord 到 endWord 的最短转换序列
     * 3.转换需遵循如下规则：
     * 4.每次转换只能改变一个字母
     * 5.转换过程中的中间单词必须是字典中的单词。
     * <p>
     * 说明:
     * 1.如果不存在这样的转换序列，返回一个空列表
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
     * 输出:
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * <p>
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * 输出: []
     * 解释:
     * endWord "cog" 不在字典中，所以不存在符合要求的转换序列
     *
     * @apiNote 思路：
     * 1.回溯+暴力+剪枝
     * 2.超时了。。。
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> track = new LinkedList<>();
        HashSet<String> flag = new HashSet<>();
        track.add(beginWord);
        flag.add(beginWord);
        backtrace(beginWord, endWord, wordList, track, flag);
        return result;
    }


    /**
     * 回溯
     */
    public static void backtrace(String curWord, String endWord,
                                 List<String> wordList, List<String> track, HashSet<String> flag) {
        //1.递归结束条件
        if (curWord.equals(endWord)) {
            if (track.size() < minSize) {
                result.clear();
                minSize = track.size();
                result.add(new LinkedList<>(track));
            } else if (track.size() == minSize) {
                result.add(new LinkedList<>(track));
            }
            return;
        }
        //如果当前长度到达了min，但是还是没有到达结束单词的话就提前结束
        if (track.size() >= minSize) {
            return;
        }
        //2.找下一个未使用过的并且和当前单词只相差一个字母的单词
        for (String s : wordList) {
            if (!flag.contains(s) && checkWord(s, curWord)) {
                flag.add(s);
                track.add(s);
                backtrace(s, endWord, wordList, track, flag);
                track.remove(s);
                flag.remove(s);
            }
        }
    }


    /**
     * 检查是否满足a和b只相差一个字母
     */
    public static boolean checkWord(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }


    /**
     * 解法二，
     *
     * @apiNote 思路：
     * 1.bfs+回溯
     * 2.时间复杂度：O(小于O(n*n*n))
     */
    public List<List<String>> findLaddersV2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }
        // 第 1 步：使用广度优先遍历得到后继结点列表 successors
        // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
        Map<String, Set<String>> successors = new HashMap<>(16);
        boolean found = bfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }
        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }


    private boolean bfs(String beginWord, String endWord, Set<String> wordSet,
                        Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // 记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        int wordLen = beginWord.length();
        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (charArray[j] == k) {
                            continue;
                        }
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    found = true;
                                }
                                nextLevelVisited.add(nextWord);
                                queue.offer(nextWord);
                                // 维护 successors 的定义
                                successors.computeIfAbsent(currentWord, a -> new HashSet<>());
                                successors.get(currentWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            if (found) {
                break;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }

    private void dfs(String beginWord, String endWord,
                     Map<String, Set<String>> successors,
                     Deque<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!successors.containsKey(beginWord)) {
            return;
        }
        Set<String> successorWords = successors.get(beginWord);
        for (String nextWord : successorWords) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, successors, path, res);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        System.out.println(res.toString());
    }
}
