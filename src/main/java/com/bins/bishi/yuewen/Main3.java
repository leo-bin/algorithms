package com.bins.bishi.yuewen;

/**
 * @author leo-bin
 * @date 2020/5/19 19:37
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 1.爬楼梯
     *
     * @apiNote 思路：
     * 1.dp
     */
    public static int stairs(int n) {
        //鲁棒
        if (n <= 2) {
            return n;
        }
        //定义dp数组
        int[] dp = new int[n + 1];
        //2.初始化dp数组
        dp[1] = 1;
        dp[2] = 2;
        //3.根据状态方程打表
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            System.out.println(stairs(i));
        }
    }
}
