package com.bins.bishi.autumn2020.xiaomi;


import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/8 17:37
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
     * 同一个单元格内的字母不允许被重复使用。
     * 二维网格为：
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 输入描述
     * 需要查询的单词
     * <p>
     * 输出描述
     * true 代表单词存在，false表示不存在
     * <p>
     * 样例输入
     * SEE
     * 样例输出
     * true
     *
     * @apiNote 思路：
     * 1.回溯
     */

/*    SEE
3 4
    A B C E
    S F C S
    A D E E*/
    public static boolean code(String[][] words, String word) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length; j++) {
                if (dfs(words, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯
     */
    public static boolean dfs(String[][] words, int i, int j, int index, String target) {
        //递归结束条件
        if (i < 0 || i >= words.length || j < 0 || j >= words[0].length) {
            return false;
        }
        if (index >= target.length()) {
            return false;
        }
        if (index == target.length() - 1) {
            if (words[i][j].equals(target.charAt(index) + "")) {
                return true;
            } else {
                return false;
            }
        }
        if (!words[i][j].equals(target.charAt(index) + "")) {
            return false;
        }
        //上下左右分别进行dfs
        return dfs(words, i + 1, j, index + 1, target) ||
                dfs(words, i, j + 1, index + 1, target) ||
                dfs(words, i - 1, j, index + 1, target) ||
                dfs(words, i, j - 1, index + 1, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] words = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                words[i][j] = scanner.next();
            }
        }
        System.out.println(code(words, word));
    }
}
