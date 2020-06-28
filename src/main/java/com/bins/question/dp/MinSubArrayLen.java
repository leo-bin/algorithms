package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/6/28 9:42
 * @apiNote 长度最小的子数组
 * 来源：leetcode-209
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {

    /**
     * 题目描述：
     * 1.给定一个含有 n 个正整数的数组和一个正整数 s
     * 2.找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度
     * 3.如果不存在符合条件的连续子数组，返回 0
     * <p>
     * 示例:
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组
     * <p>
     * 进阶:
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法
     *
     * @apiNote 思路：
     * 1.滑动窗口的思想
     * 2.
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        //特判
        if (len <= 0) {
            return 0;
        }
        int minLen = len + 1;
        int curSum = nums[0];
        for (int i = 0, j = 0; i < len; i++) {
            while (curSum < s && ++j < len) {
                curSum += nums[j];
            }
            //越界直接break
            if (j >= len) {
                break;
            }
            //更新长度，然后左窗口右移
            minLen = Math.min(minLen, j - i + 1);
            curSum -= nums[i];
        }
        //找到了返回minLen，没找到返回0
        return minLen == len + 1 ? 0 : minLen;
    }

    /**
     * 同一种解法，不同写法
     *
     * @apiNote 思路：
     * 1.在题解看到一种同样也是用滑动窗口的解法
     * 2.唉，为什么人家写出的代码就是比自己的简洁优雅还要快？
     * 3.还是多写题吧，孰能生巧，加油！
     */
    public static int minSubArrayLenV2(int s, int[] nums) {
        int minLen = nums.length + 1;
        int curSum = 0;
        for (int i = 0, j = 0; j < nums.length; ) {
            curSum += nums[j++];
            while (curSum >= s) {
                //更新长度，然后左窗口右移
                minLen = Math.min(minLen, j - i);
                curSum -= nums[i++];
            }
        }
        //找到了返回minLen，没找到返回0
        return minLen == nums.length + 1 ? 0 : minLen;
    }


    public static void main(String[] args) {
        int s1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s1, nums1));

        int s2 = 7;
        int[] nums2 = {2, 3, 1};
        System.out.println(minSubArrayLen(s2, nums2));
    }
}
