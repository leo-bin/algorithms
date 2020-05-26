package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/5/26 11:48
 * @apiNote 统计全为1的正方形子矩阵
 * 来源：leetcode-1277
 * 链接：https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquares {


    /**
     * 题目描述：
     * 1.给你一个 m * n 的矩阵
     * 2.矩阵中的元素不是 0 就是 1
     * 3.请你统计并返回其中完全由 1 组成的正方形子矩阵的个数
     * <p>
     * 示例 1：
     * 输入：matrix =
     * [
     * [0,1,1,1],
     * [1,1,1,1],
     * [0,1,1,1]
     * ]
     * 输出：15
     * 解释：
     * 边长为 1 的正方形有 10 个。
     * 边长为 2 的正方形有 4 个。
     * 边长为 3 的正方形有 1 个。
     * 正方形的总数 = 10 + 4 + 1 = 15.
     * <p>
     * 示例 2：
     * 输入：matrix =
     * [
     * [1,0,1],
     * [1,1,0],
     * [1,1,0]
     * ]
     * 输出：7
     * 解释：
     * 边长为 1 的正方形有 6 个。
     * 边长为 2 的正方形有 1 个。
     * 正方形的总数 = 6 + 1 = 7
     *
     * @apiNote 思路：
     * 1.dp解决
     * 2.答案没看懂
     * 3.
     */
    public static int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //1.定义dp数组
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int count = 0;
        //2.根据状态方程打表
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        int[][] matrix2 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(countSquares(matrix1));
        System.out.println(countSquares(matrix2));
    }
}
