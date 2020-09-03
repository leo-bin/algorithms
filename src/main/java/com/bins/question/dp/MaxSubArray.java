package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/21 16:30
 * @apiNote 最大的子序列之和
 * 来源：剑指offer-42
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class MaxSubArray {

    /**
     * 题目描述：
     * 1.给定一个整数数组 nums
     * 2.找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
     *
     * @apiNote 思路：
     * 1.采用dp解决
     * 2.先给出dp[nums.length]数组的定义
     * 3.dp数组中存放的是每一轮相加之后的最大值
     * 4.dp[0]=nums[0]
     * 5.dp[i]=max((dp[i-1]+nums[i]),nums[i])
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int maxSubArray(int[] nums) {
        //特判
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {3, 3, 2, 2, -11, -1, 2, 5, 6};
        System.out.println("数组：" + Arrays.toString(nums) + "的最大子序列的和是：" + maxSubArray(nums));
        System.out.println("数组：" + Arrays.toString(nums1) + "的最大子序列的和是：" + maxSubArray(nums1));
    }
}
