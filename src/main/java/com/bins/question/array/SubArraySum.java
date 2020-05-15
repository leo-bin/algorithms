package com.bins.question.array;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/5/15 10:28
 * @apiNote 和为K的子数组
 * 来源：leetcode-560
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 */
public class SubArraySum {


    /**
     * 题目描述：
     * 1.定一个整数数组和一个整数 k
     * 2.你需要找到该数组中和为 k 的连续的子数组的个数
     * <p>
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况
     * <p>
     * 说明 :
     * 1.数组的长度为 [1, 20,000]
     * 2.数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
     *
     * @apiNote 思路：
     * 1.暴力法
     * 2.直接两个for求出所有可能的子数组的和，同时判断是否等于k
     * 3.等于k就计数就行
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(1)
     */
    public static int subArraySumV1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        //统计次数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }



    /**
     * 解法二，前缀和
     *
     * @apiNote 思路：
     * 1.构建前缀和数组，以快速计算区间和
     * 2.注意在计算区间和的时候，下标有偏移
     * 3.时间复杂度：O(n*n)
     * 4.空间复杂度：O(n)
     */
    public static int subArraySumV2(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 解法三，前缀和+哈希表
     *
     * @apiNote 思路：
     * 1.currentSum-k的含义就是，当前的前缀和-之前的某个前缀和==k
     * 2.这里有个技巧，当前的前缀和-之前的某个前缀和的结果等于数组中的某个连续子数组的和！
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int subArraySumV3(int[] nums, int k) {
        //使用map来保存所有前缀和以及他出现的次数
        //key:某个前缀和    value:这个前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(16);
        //初始化，这里就是考虑到当前的前缀和-k=0的情况
        map.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            //记录当前的前缀和以及他的出现次数
            //这里可能大家会感到疑惑，当前前缀和的出现次数为什么不直接给1？
            //这因为还要考虑到数组中某个数可能为0！
            //也就是说当前的前缀和可能会不只出现一次！所以需要在这里进行累加！
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int[] nums2 = {1, 1, 1, 2, 3};
        int k2 = 3;
        int[] nums3 = {-1, -1, 1};
        int k3 = 0;
        System.out.println(subArraySumV1(nums1, k1));
        System.out.println(subArraySumV1(nums2, k2));
        System.out.println(subArraySumV1(nums3, k3));
    }
}
