package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/11 17:38
 * @apiNote 寻找不同路径
 * 来源：leetcode-62
 * 链接：https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    /**
     * 题目描述：
     * 1.一个机器人位于一个m x n网格的左上角（起始点在下图中标记为“Start”）
     * 2.机器人每次只能向下或者向右移动一步
     * 3.机器人试图达到网格的右下角（在下图中标记为“Finish”）
     * 4.问总共有多少条不同的路径？
     * <p>
     * 示例 1:
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * <p>
     * 示例 2:
     * 输入: m = 7, n = 3
     * 输出: 28
     *
     * @apiNote 思路：
     * 1.动态规划
     * 2.我们思考一下，根据题目的限制，最后我们只能从终点的左边或者上边走一步到达终点
     * 3.我们把问题简化一下，假设现在m=2，n=2
     * 4.地图抽象一下就是这样子：
     * [起点，空格1]
     * [空格2，终点]
     * 5.根据之前的思考，从起点到两个空格分别属于两种不同的走法，最后走一步到达终点，那总路径就是1+1
     * 6.ok，我们把上面的文字用数字具象化
     * 7.假设地图是一个二维矩阵m*n(从0开始)
     * 8.终点坐标就是[m-1,n-1],为了便于理解，令m-1=i，n-1=j，即[i,j]
     * 9.那么空格1和空格2的坐标分别就是:[i,j-1],[i-1,j]
     * 10.所以最后的结果就是dp[i][j]=dp[i][j-1]+dp[i-1][j]
     * 11.时间复杂度:O(m*n)
     * 12.空间复杂度：O(m*n)
     */
    public static int uniquePaths(int m, int n) {
        //1.定义dp数组
        int[][] dp = new int[m][n];
        //2.初始化dp
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //3.根据状态方程打表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m1 = 7;
        int n1 = 3;
        System.out.println(uniquePaths(m1, n1));

        int m2 = 2;
        int n2 = 2;
        System.out.println(uniquePaths(m2, n2));
    }
}
