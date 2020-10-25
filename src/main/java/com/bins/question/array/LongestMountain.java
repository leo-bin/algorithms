package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/10/25 15:41
 * @apiNote 数组中的最长山脉
 * 来源：leetcode-845
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class LongestMountain {

    /**
     * 题目描述：
     * 1.我们把数组A中符合下列属性的任意连续子数组B称为“山脉”：
     * 2.B.length>=3
     * 3.存在0<i< B.length-1使得B[0]<B[1]< ... B[i-1]<B[i]>B[i+1]>...>B[B.length-1]
     * 4.注意：B可以是A的任意子数组，包括整个数组A
     * 5.给出一个整数数组A，返回最长“山脉”的长度
     * 6.如果不含有“山脉”则返回0
     * <p>
     * 示例 1：
     * 输入：[2,1,4,7,3,2,5]
     * 输出：5
     * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5
     * <p>
     * 示例 2：
     * 输入：[2,2,2]
     * 输出：0
     * 解释：不含 “山脉”
     * <p>
     * 提示：
     * 0 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     *
     * @apiNote 思路：
     * 1.这题没写出来，看了题解解法，真的很难想到枚举山顶的并且从山顶进行两边扩展的解法
     * 2.大致思路就是分别从左到右和从右到左遍历原数组
     * 3.每次都以当前元素作为山顶并统计左边或者右边自己可以延申到的元素个数
     * 4.这里用了类似于dp的思路去求每一个山顶元素的元素个数
     * 5.base case就是dp[0]=0
     * 6.状态方程就是dp[i]=dp[i-1]+1
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(n)
     */
    public static int longestMountain(int[] A) {
        //特判
        if (A.length <= 0) {
            return 0;
        }
        int[] left = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            left[i] = A[i] > A[i - 1] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[A.length];
        for (int j = A.length - 2; j > 0; j--) {
            right[j] = A[j] > A[j + 1] ? right[j + 1] + 1 : 0;
        }
        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            if (left[i] > 0 && right[i] > 0) {
                maxLen = Math.max(maxLen, left[i] + right[i] + 1);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 2, 5, 3};
        System.out.println(longestMountain(A));
    }
}
