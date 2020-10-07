package com.bins.question.backtrace;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/10/7 15:10
 * @apiNote 被围绕的区域
 * 来源：leetcode-130
 * 链接：https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedArea {

    /**
     * 题目描述：
     * 1.给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）
     * 2.找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
     * <p>
     * 示例:
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * <p>
     * 运行你的函数后，矩阵变为：
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * <p>
     * 解释:
     * 被围绕的区间不会存在于边界上
     * 换句话说，任何边界上的 'O' 都不会被填充为 'X'
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的
     *
     * @apiNote 思路：
     * 1.dfs搜索
     * 2.这里有点取巧，因为题目给定的是边界上的O一定不会被包围，那么边界上的O就是一个缺口！
     * 3.我们只要从这个缺口打进去，一个一个的找和这个缺口相连的位置，全部置为特殊符合“#”
     * 4.之后我们全表遍历一次，遇到了特殊符号“#”就表示这个是和之前缺口相连的位置，一定不会被包围的
     */
    public static void solve(char[][] board) {
        //特判
        if (board.length <= 0) {
            return;
        }
        //左右边界开始“感染“
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        //上下边界开始”感染“
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        //重新标记
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * dfs
     */
    public static void dfs(char[][] board, int i, int j) {
        //递归结束条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        //标记当前位置表示被‘感染’了（不连通）
        board[i][j] = '#';
        //四个方向接着搜索
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for (char[] s : board) {
            System.out.println(Arrays.toString(s));
        }
    }
}
