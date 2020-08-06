package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/23 10:29
 * @apiNote 完全平方数
 * 来源：leetcode-279
 * 链接：https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquares {

    /**
     * 题目描述：
     * 1.给定正整数 n
     * 2.找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n
     * 3.你需要让组成和的完全平方数的个数最少
     * <p>
     * 示例 1:
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4
     * <p>
     * 示例 2:
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9
     *
     * @apiNote 思路：
     * 1.动态规划
     * 2.考虑到存在最优子结构的问题，所以使用dp
     * 3.假设dp[i]是当n等于i时的能够组成的最小平方数
     * 4.我们每次都需要用到：1 2 3 4 5 的平方和进行判断是否等于目标和
     * 5.假设目标和n=12，那么它要用到的平方数就一定是小于n本身的！
     * 6.在这里就是：1 2 3
     * 7.那我们只需要从1到n进行遍历，代表dp[i]的每一个状态
     * 8.然后从1到（i-j*j）进行判断
     * 9.所以有状态方程：dp[i]=Min(dp[i],dp[i-j*j])
     * 10.时间复杂度：O(n*sqrt(n))
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
