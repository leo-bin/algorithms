package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/11 17:33
 * @apiNote 寻找不同路径(有障碍物的)
 * 来源：leetcode-63
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacleGrid {

    /**
     * 题目描述：
     * 1.一个机器人位于一个m x n网格的左上角（起始点在下图中标记为“Start” ）
     * 2.机器人每次只能向下或者向右移动一步
     * 3.机器人试图达到网格的右下角（在下图中标记为“Finish”）
     * 4.现在考虑网格中有障碍物
     * 5.那么从左上角到右下角将会有多少条不同的路径？
     * 6.网格中的障碍物和空位置分别用 1 和 0 来表示
     * 7.说明：m 和 n 的值均不超过 100
     * <p>
     * 示例 1:
     * 输入:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * @apiNote 思路：
     * 1.依旧是使用动态规划的解法
     * 2.但是不同点是这里在初始化dp数组以及在计算路径的时候需要先判断-是否有障碍物
     * 3.其他的没什么变化
     * 4.时间复杂度：O(m*n)
     * 5.空间复杂度：O(m*n)
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //特判
        if (obstacleGrid.length <= 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] != 1 ? dp[i][j - 1] + dp[i - 1][j] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }
}
