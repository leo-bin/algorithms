package com.bins.bishi.alibaba;

/**
 * @author leo-bin
 * @date 2020/3/29 1:30
 * @apiNote 求矩阵构成的数组的绝对值之差的和的最小值
 */
public class MinSumMatrixArray {


    /**
     * 题目描述：
     * 1.给你一个3*n的矩阵
     * 2.从a中的每一列里面随机拿一个数，组成一个数组b
     * 3.让你求|b[i]-b[i+1]|+...|b[n-1]+b[n]|的最小值
     * <p>
     * 输入描述：
     * 第一行，一个正整数n
     * 第二行到第四行输入一个3*n的矩阵a，每一行输入n个正整数
     * 2<=n<=10^5,1<=a[i][j]<=10^9
     * 输出:
     * 一个正整数表示结果
     *
     * @apiNote 思路：
     * 1.dp动态规划解题
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     */
    public static int minSum(int n, int[][] a) {
        //定义一个dp数组
        int[] dp = new int[n + 1];
        //初始化dp数组
        dp[0] = 0;
        dp[1] = 0;
        for (int e = 2; e <= n; e++) {
            //数组b
            int[] b = new int[e];
            dp[e] = Integer.MAX_VALUE;
            for (int i = 0; i < e; i++) {
                //1.按照顺序构建b数组
                for (int j = 0; j < e; j++) {
                    b[j] = a[i][j];
                }
                int tmp = 0;
                for (int z = 0; z < e - 1; z++) {
                    tmp += Math.abs(b[z] - b[z + 1]);
                }
                dp[e] = Math.min(dp[e], tmp);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("最小值是：" + minSum(n, a));

        int n1 = 2;
        int[][] a1 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("最小值是：" + minSum(n1, a1));
    }
}
