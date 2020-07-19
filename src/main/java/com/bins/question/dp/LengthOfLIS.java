package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/19 11:03
 * @apiNote 最长上升子序列
 * 来源：leetcode-300
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {

    /**
     * 题目描述：
     * 1.给定一个无序的整数数组
     * 2.找到其中最长上升子序列的长度
     * <p>
     * 示例:
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
     * <p>
     * 说明:
     * 1.可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 2.你算法的时间复杂度应该为 O(n2) 。
     * <p>
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.我们在遍历每一个dp[i]的时候不仅需要考虑当前元素和后面元素的情况。
     * 3.还需要考虑到每一个位置的前面是否有满足条件的元素。
     * 4.如果有的话，及时记录下长度，并及时更新
     * 5.最大长度在打表的过程中产生所以需要一个临时变量记录最大长度
     * 6.时间复杂度：O(n*n)
     * 7.空间复杂度：O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        //特判
        if (nums.length <= 1) {
            return nums.length;
        }
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            //每一个位置都要往前检查是否有满足条件的元素
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(nums));
    }
}
