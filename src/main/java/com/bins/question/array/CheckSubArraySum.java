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
     * 3.要求其大小至少为2，总和为k的倍数，即总和为n*k，其中n也是一个整数
     * <p>
     * 示例 1:
     * 输入: [23,2,4,6,7], k = 6
     * 输出: True
     * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6
     * <p>
     * 示例 2:
     * 输入: [23,2,6,4,7], k = 6
     * 输出: True
     * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42
     * <p>
     * 说明:
     * 1.数组的长度不会超过10,000
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
                //保证连续
                if ((i - map.get(preSum)) > 1) {
                    return true;
                }
            } else {
                map.put(preSum, i);
            }
        }
        return false;
    }


    /**
     * 解法二，回溯
     *
     * @apiNote 思路：
     * 1.第二次写这道题，什么前缀和是啥我不知道，反正我是忘了
     * 2.暴力回溯就是干
     * 3.md超时了cao
     */
    public static boolean checkSubArraySumV2(int[] nums, int k) {
        return check(nums, k, 0, 0, 0);
    }

    /**
     * 回溯
     */
    public static boolean check(int[] nums, int target, int count, int currentSum, int index) {
        //递归结束条件
        if (count >= 2 && (currentSum == target || (target != 0 && currentSum % target == 0))) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            //保证连续
            if (i > index && (i - index >= 1 && count >= 1)) {
                continue;
            }
            currentSum += nums[i];
            count += 1;
            if (check(nums, target, count, currentSum, i + 1)) {
                return true;
            }
            count -= 1;
            currentSum -= nums[i];
        }
        return false;
    }

    /**
     * 解法三，前缀和
     *
     * @apiNote 思路：
     * 1.根据前缀和可以求出任意一个子数组的和
     * 2.最后只要遍历前缀和数组判断是否满足倍数的情况即可
     * 3.时间复杂度：O(n*n)
     * 4.空间复杂度：O(n)
     */
    public static boolean checkSubArraySumV3(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        //1.求每一个位置的前缀和
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        //2.求所有区间相差2个位置或以上的前缀和之差
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 2; j < preSum.length; j++) {
                int t = preSum[j] - preSum[i];
                if ((t == 0 && k == 0) || (k != 0 && t % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        int k = 0;
        System.out.println(checkSubArraySum(nums, k));
        System.out.println(checkSubArraySumV2(nums, k));
    }
}
