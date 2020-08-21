package com.bins.bishi.autumn2020.youzan;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/20 17:56
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给你一个整数数组 nums
     * 2.请你找出并返回能被5整除的元素最大和
     * <p>
     * 示例1
     * 输入
     * [3,6,5,1,8]
     * 输出
     * 20
     * 说明
     * 选出数字 6, 5,1 和 8，它们的和是 20（可被 5 整除的最大和）
     * <p>
     * 示例2
     * 输入
     * [6]
     * <p>
     * 输出
     * 0
     * 说明
     * 6 不能被 5 整除，所以无法选出数字，返回 0
     * <p>
     * 示例3
     * 输入
     * [1,2,3,4,4]
     * <p>
     * 输出
     * 10
     * 说明
     * 选出数字 1,2, 3和4 ，或者选出数字2,4和4 ，它们的和均是 10（可被 5 整除的最大和）
     * <p>
     * 备注:
     * 1 <= nums.length <= 4 * 10^4
     * 1 <= nums[i] <= 10^4
     *
     * @apiNote 思路：
     * 1.回溯
     */

    private static int maxSum = 0;

    public   static int maxSumDivFive(int[] nums) {
        backtrace(nums, 0, 0);
        return maxSum;
    }

    /**
     * 回溯
     */
    public static void backtrace(int[] nums, int curSum, int index) {
        //递归结束条件
        if (curSum % 5 == 0) {
            maxSum = Math.max(maxSum, curSum);
        }
        //接着递归
        for (int i = index; i < nums.length; i++) {
            curSum += nums[i];
            backtrace(nums, curSum, i+1);
            curSum -= nums[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 8, 5};
        System.out.println(maxSumDivFive(nums));
    }
}
