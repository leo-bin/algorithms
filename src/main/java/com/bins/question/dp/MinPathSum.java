package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/15 11:39
 * @apiNote 最小路径和
 * 来源：leetcode-64
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    /**
     * 题目描述：
     * 1.给定一个包含非负整数的 m x n 网格
     * 2.请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
     * 3.每次只能向下或者向右移动一步
     * <p>
     * 示例:
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.这个题目
     */
    public static int minPathSum(int[][] grid) {
        //特判
        if (grid.length <= 0) {
            return 0;
        }
        //1.定义dp数组
        int[][] dp = new int[grid.length][grid[0].length];
        //2.初始化dp
        dp[0][0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //3.根据状态方程打表
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
