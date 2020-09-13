package com.bins.question.backtrace;

/**
 * @author leo-bin
 * @date 2020/7/18 9:16
 * @apiNote 单词搜索
 * 来源：leetcode-79
 * 链接：https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {

    /**
     * 题目描述：
     * 1.给定一个二维网格和一个单词，找出该单词是否存在于网格中
     * 2.单词必须按照字母顺序，通过相邻的单元格内的字母构成
     * 3.其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
     * 4.同一个单元格内的字母不允许被重复使用
     * <p>
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     * @apiNote 思路：
     * 1.暴力dfs
     * 2.注意这里通过迭代每一个元素，保证每一个元素都能进行dfs搜索
     */
    public static boolean exist(char[][] board, String word) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        //保证每一个元素都能被搜索到
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, 0, i, j, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯
     */
    public static boolean dfs(char[][] board, char[] words, int currentIndex, int i, int j, boolean[][] marked) {
        //递归结束条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || marked[i][j]) {
            return false;
        }
        if (board[i][j] != words[currentIndex]) {
            return false;
        }
        if (currentIndex == words.length - 1) {
            return true;
        }
        marked[i][j] = true;
        //上下左右分别递归
        if (dfs(board, words, currentIndex + 1, i + 1, j, marked)
                || dfs(board, words, currentIndex + 1, i - 1, j, marked)
                || dfs(board, words, currentIndex + 1, i, j + 1, marked)
                || dfs(board, words, currentIndex + 1, i, j - 1, marked)) {
            return true;
        }
        marked[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println(exist(board, word1));
        System.out.println(exist(board, word2));
        System.out.println(exist(board, word3));
    }
}
