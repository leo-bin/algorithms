package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/15 9:07
 * @apiNote 解数独
 * 来源：leetcode-37
 * 链接：https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SolveSudoKu {

    /**
     * 题目描述：
     * 编写一个程序，通过已填充的空格来解决数独问题
     * 一个数独的解法需遵循如下规则：
     * 数字 1-9 在每一行只能出现一次
     * 数字 1-9 在每一列只能出现一次
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
     * 空白格用 '.' 表示
     * 一个数独
     * 答案被标成红色。
     * Note:
     * 给定的数独序列只包含数字 1-9 和字符 '.'
     * 你可以假设给定的数独只有唯一解
     * 给定数独永远是 9x9 形式的
     *
     * @apiNote 思路：
     * 1.没啥好的办法，就是暴力回溯+剪枝
     * 2.但是需要注意的是如何巧妙的保存之前使用的数字
     * 3.这里的标记数组很难想到
     */

    /**
     * 标记数组，分别代表 行，列，和3*3块：
     */
    private static boolean[][] cols = new boolean[9][9];
    private static boolean[][] rows = new boolean[9][9];
    private static boolean[][][] blocked = new boolean[3][3][9];
    private static List<int[]> spaces = new ArrayList<>();
    private static boolean valid = false;

    public static void solveSudoKu(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    //记录空格坐标
                    spaces.add(new int[]{i, j});
                } else {
                    //标记数字
                    int num = board[i][j] - '0' - 1;
                    cols[i][num] = rows[j][num] = blocked[i / 3][j / 3][num] = true;
                }
            }
        }
        backtrace(board, 0);
    }

    /**
     * 回溯
     */
    public static void backtrace(char[][] board, int index) {
        //递归结束条件
        if (index == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(index);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!cols[i][digit] && !rows[j][digit] && !blocked[i / 3][j / 3][digit]) {
                cols[i][digit] = rows[j][digit] = blocked[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                backtrace(board, index + 1);
                cols[i][digit] = rows[j][digit] = blocked[i / 3][j / 3][digit] = false;
            }
        }
    }


    public static void print(char[][] board) {
        for (char[] c : board) {
            System.out.println(Arrays.toString(c));
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        print(board);
        solveSudoKu(board);
        System.out.println("..................................");
        print(board);
    }
}
