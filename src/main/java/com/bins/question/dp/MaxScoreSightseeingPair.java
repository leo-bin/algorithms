package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/6/17 8:41
 * @apiNote 最佳观光组合
 * 来源：leetcode-1014
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair/
 */
public class MaxScoreSightseeingPair {

    /**
     * 题目描述：
     * 1.给定正整数数组 A，A[i] 表示第 i 个观光景点的评分
     * 2.并且两个景点 i 和 j 之间的距离为 j - i
     * 3.一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）
     * 4.景点的评分之和减去它们两者之间的距离
     * 5.返回一对观光景点能取得的最高分
     * <p>
     * 示例：
     * 输入：[8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
     * <p>
     * 提示：
     * 2 <= A.length <= 50000
     * 1 <= A[i] <= 1000
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.我们观察题目给出的公式：max=A[i]+A[j]+i-j
     * 3.要让max最大，我们只需要保证A[i]+i最大就行
     * 4.剩下的，我们只需通过一次遍历所有元素+A[j]的同时求最大值就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static int maxScoreSightseeingPair(int[] A) {
        //特判
        if (A.length <= 1) {
            return 0;
        }
        int i = 0;
        int max = A[i] + i;
        for (int j = 1; j < A.length; j++) {
            max = Math.max(max, A[i] + A[j] + i - j);
            i = A[i] + i > A[j] + j ? i : j;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] A1 = {8, 1, 5, 2, 6};
        int[] A2 = {8, 1, 1, 1, 1, 1, 1, 7, 7};
        int[] A3 = {4, 7, 5, 8};
        int[] A4 = {7, 1, 10, 6, 3, 5, 10, 2};
        System.out.println(maxScoreSightseeingPair(A1));
        System.out.println(maxScoreSightseeingPair(A2));
        System.out.println(maxScoreSightseeingPair(A3));
        System.out.println(maxScoreSightseeingPair(A4));
    }
}
