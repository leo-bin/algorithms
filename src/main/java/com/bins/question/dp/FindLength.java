package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/7/12 10:06
 * @apiNote 最长重复子数组
 * 来源：leetcode-718
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class FindLength {

    /**
     * 题目描述：
     * 1.给两个整数数组 A 和 B
     * 2.返回两个数组中公共的、长度最长的子数组的长度
     * <p>
     * 示例：
     * 输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1]
     * <p>
     * 提示：
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     * @apiNote 思路：
     * 1.动态规划
     * 2.这里需要明白连续子数组和子序列的细微差别
     * 3.前者强调的是一个连续性，后者则是不需要连续，可以间隔出现
     * 4.所以前者的dp一般都是求的前一个状态，也就是一般用dp[i-1][j-1]
     * 5.后者的dp则可以分几种情况讨论，但是大部分都是d[i-1][j]和dp[i][j-1]
     * 6.时间复杂度：O(m*n)
     * 7.空间复杂度：O(m*n)
     */
    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int maxLen = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 2, 1};
        int[] B1 = {3, 2, 1, 4, 7};
        System.out.println(findLength(A1, B1));

        int[] A2 = {0, 0, 0, 0, 0};
        int[] B2 = {0, 0, 0, 0, 0};
        System.out.println(findLength(A2, B2));

        int[] A3 = {0, 1, 1, 1, 1};
        int[] B3 = {1, 0, 1, 0, 1};
        System.out.println(findLength(A3, B3));
    }
}
