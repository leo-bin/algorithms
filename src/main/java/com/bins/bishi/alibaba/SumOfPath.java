package com.bins.bishi.alibaba;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/3/29 14:26
 * @apiNote 总共有多少种走法（蘑菇街校招真题）
 */
public class SumOfPath {

    /**
     * 题目描述：
     * <p>
     * 1.有一个X*Y的网格，小团要在此网格上从左上角到右下角
     * 2.只能走格点且只能向右或向下走。
     * 3.请设计一个算法，计算小团有多少种走法。
     * 4.给定两个正整数int x,int y，请返回小团的走法数目。
     *
     * @apiNote 思路：
     * 1.典型的dp问题
     * 2.假设dp[i][j]为当i=x，j=y时，所有走法
     * 3.根据题目条件可以知道dp的初始值是，dp[0][0]=0,dp[0][0-j]=1,dp[0-i][0]=1
     * 4.状态方程为，dp[i][j]=dp[i][j-1]+dp[i-1][j]+1
     * 5.时间复杂度为：O(n*n)
     * 6.空间复杂度为：O(n*n)
     */
    public static int sumOfPath(int x, int y) {
        //鲁棒
        if (x < 1 || y < 1) {
            return 0;
        }
        //1.定义dp数组
        int[][] dp = new int[x + 1][y + 1];
        //2.初始化dp数组
        for (int j = 0; j <= y; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i <= x; i++) {
            dp[i][0] = 1;
        }
        dp[0][0] = 0;
        //3.根据状态方程给dp打表
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[x - 1][y - 1];
    }


    /**
     * Scanner scanner = new Scanner(System.in);
     * int x = scanner.nextInt();
     * int y = scanner.nextInt();
     * System.out.println(sumOfPath(x + 1, y + 1));
     */
    public static void main(String[] args) {
        for (int x = 0; x <= 4; x++) {
            for (int y = 0; y <= 5; y++) {
                System.out.println(x + "x" + y + "的矩阵一共有：" + sumOfPath(x+1, y+1) + "种走法");
            }
        }
    }
}
