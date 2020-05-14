package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/5/8 12:49
 * @apiNote 最大正方形
 * 来源：leetcode-221
 * 链接：https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {


    /**
     * 题目描述：
     * 1.在一个由 0 和 1 组成的二维矩阵内
     * 2.找到只包含 1 的最大正方形，并返回其面积
     * <p>
     * 示例:
     * 输入:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * 输出: 4
     *
     * @apiNote 思路：
     * 1.dp
     * 2.dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
     * 3.时间复杂度：O(m*n)
     * 4.空间复杂度：O(m*n)
     */
    public static int maximalSquare(char[][] matrix) {
        //鲁棒
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //1.dp数组
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        //正方形的最大的边
        int maxSize = 0;
        //2.根据状态方程打表求最大的正方形的边长
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min((Math.min(dp[i - 1][j], dp[i][j - 1])), dp[i - 1][j - 1]) + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }


    public static void main(String[] args) {

    }
}
