package com.bins.question.others;


import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/8 21:35
 * @apiNote 生命游戏
 */
public class LifeOfGame {


    /**
     * 题目描述：
     * 1.给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞
     * 2.每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）
     * 3.每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     * 4.如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
     * 5.如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
     * 6.如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
     * 7.如果死细胞周围正好有三个活细胞，则该位置死细胞复活
     * 8.根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态
     * 9.下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的
     * <p>
     * 示例：
     * 输入：
     * [
     * [0,1,0],
     * [0,0,1],
     * [1,1,1],
     * [0,0,0]
     * ]
     * <p>
     * 输出：
     * [
     * [0,0,0],
     * [1,0,1],
     * [0,1,1],
     * [0,1,0]
     * ]
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(m*n)
     * 3.空间复杂度：O(m*n)
     */
    public static void lifeOfGame(int[][] board) {
        int lenX = board.length;
        if (lenX > 0) {
            int lenY = board[0].length;
            //1.构造一个新的矩阵用来存放原来的数组，把原来的数组包住
            int[][] old = new int[lenX + 2][lenY + 2];
            int oldX = old.length;
            int oldY = old[0].length;
            //2.初始化这个数组
            for (int j = 0; j < lenY; j++) {
                old[0][j] = 0;
                old[oldX - 1][j] = 0;
            }
            for (int i = 0; i < lenX; i++) {
                old[i][0] = 0;
                old[i][oldY - 1] = 0;
            }
            for (int i = 1; i < oldX - 1; i++) {
                for (int j = 1; j < oldY - 1; j++) {
                    old[i][j] = board[i - 1][j - 1];
                }
            }
            for (int i = 1; i < oldX - 1; i++) {
                for (int j = 1; j < oldY - 1; j++) {
                    int n = old[i - 1][j - 1] + old[i - 1][j] +
                            old[i - 1][j + 1] + old[i][j - 1] +
                            old[i][j + 1] + old[i + 1][j - 1] +
                            old[i + 1][j] + old[i + 1][j + 1];
                    //活细胞
                    if (board[i - 1][j - 1] == 1) {
                        //活细胞死亡
                        if (n < 2 || n > 3) {
                            board[i - 1][j - 1] = 0;
                        }
                    }
                    //死细胞
                    if (board[i - 1][j - 1] == 0) {
                        //死细胞复活
                        if (n == 3) {
                            board[i - 1][j - 1] = 1;
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        lifeOfGame(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
