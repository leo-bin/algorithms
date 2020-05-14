package com.bins.question.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/27 11:56
 * @apiNote n皇后问题
 */
public class NQueens {

    /**
     * 统计所有结果
     */
    private static List<List<String>> result;


    /**
     * 题目描述：
     * 1.n皇后问题研究的是如何将n个皇后放置在n×n棋盘上，并使皇后彼此之间不能相互攻击
     * 2.给定一个整数 n，返回所有不同的 n 皇后问题的解决方案
     * 3.每一种解法包含一个明确的 n 皇后问题的棋子放置方案
     * 4.该方案中 'Q' 和 '.' 分别代表了皇后和空位
     * <p>
     * 示例:
     * 输入: 4
     * 输出:
     * [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * <p>
     * 解释: 4 皇后问题存在两个不同的解法
     * <p>
     * 提示：
     * 1.皇后，是国际象棋中的棋子，意味着国王的妻子
     * 2.皇后只做一件事，那就是“吃子”
     * 3.当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子
     * 4.当然，她横、竖、斜都可走一或七步，可进可退
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.时间复杂度：O()
     */
    public static List<List<String>> nQueens(int n) {
        //鲁棒
        if (n <= 0) {
            return null;
        }
        result = new LinkedList<>();
        //构造棋盘
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        //开始回溯
        backtrace(board, 0);
        return result;
    }

    /**
     * 每一行就是一颗回溯树
     */
    public static void backtrace(char[][] board, int row) {
        //递归结束条件
        if (row == board.length) {
            result.add(char2String(board));
            return;
        }
        //从当前行开始，回溯这一行的所有列
        for (int col = 0; col < board[row].length; col++) {
            //无效的话就跳过
            if (!isValid(board, row, col)) {
                continue;
            }
            //设置皇后的位置
            board[row][col] = 'Q';
            //换一行开始回溯
            backtrace(board, row + 1);
            //撤销皇后的位置
            board[row][col] = '.';
        }
    }


    /**
     * 判断当前皇后的左上，右上，以及自己所在的那一列是否有其他的皇后
     */
    public static boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        //判断当前所在的那一列
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        //判断左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //判断右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    /**
     * char[][]转为List<String>
     */
    public static List<String> char2String(char[][] board) {
        List<String> list = new LinkedList<>();
        for (char[] chars : board) {
            list.add(String.valueOf(chars));
        }
        return list;
    }


    public static void main(String[] args) {
        int n = 8;
        List<List<String>> result;
        for (int i = 0; i <= n; i++) {
            result = nQueens(i);
            if (result != null && result.size() >= 1) {
                System.out.println(result.toString());
            } else {
                System.out.println("无解！！");
            }
        }
    }

}
