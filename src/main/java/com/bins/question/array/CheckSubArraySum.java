package com.bins.question.array;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/5/25 21:17
 * @apiNote 连续的子数组的和
 * 来源：leetcode-523
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class CheckSubArraySum {


    /**
     * 题目描述：
     * 1.给定一个包含非负数的数组和一个目标整数 k
     * 2.编写一个函数来判断该数组是否含有连续的子数组
     * 3.要求其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     * <p>
     * 示例 1:
     * 输入: [23,2,4,6,7], k = 6
     * 输出: True
     * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
     * <p>
     * 示例 2:
     * 输入: [23,2,6,4,7], k = 6
     * 输出: True
     * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     * <p>
     * 说明:
     * 1.数组的长度不会超过10,000。
     * 2.你可以认为所有数字总和在 32 位有符号整数范围内
     *
     * @apiNote 思路：
     * 1.前缀和+哈希表
     * 2.这道题的测试用例太恶心了！
     * 3.本来自己写的前缀和感觉能过，但是碰到了leetcode的测试用例，真的甘拜下风！
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static boolean checkSubArraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(0, -1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            preSum = (k != 0) ? (preSum % k) : preSum;
            if (map.containsKey(preSum)) {
                if ((i - map.get(preSum)) > 1) {
                    return true;
                }
            } else {
                map.put(preSum, i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        int k = 0;
        System.out.println(checkSubArraySum(nums, k));
    }
}
