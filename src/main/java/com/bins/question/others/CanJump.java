package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/6/22 14:59
 * @apiNote 跳跃游戏
 * 来源：leetcode-面试题55
 * 链接：https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    /**
     * 题目描述：
     * 1.给定一个非负整数数组，你最初位于数组的第一个位置
     * 2.数组中的每个元素代表你在该位置可以跳跃的最大长度
     * 3.判断你是否能够到达最后一个位置
     * <p>
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * <p>
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置
     *
     * @apiNote 思路：
     * 1.暴力+回溯
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(n)
     * 4.md虽然写出来了，但是超时了。。。
     */
    public static boolean canJump(int[] nums) {
        //特判
        if (nums.length <= 1) {
            return true;
        }
        //回溯
        return backtrace(nums[0], 0, nums);
    }


    /**
     * 暴力回溯
     */
    public static boolean backtrace(int current, int index, int[] nums) {
        //1.递归结束条件
        if (index == nums.length - 1) {
            return true;
        }
        if (current == 0) {
            return false;
        }
        //2.从下一个跳跃区间开始回溯
        for (int i = index + 1; i <= current + index && i < nums.length; i++) {
            if (backtrace(nums[i], i, nums)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解法二，贪心
     *
     * @apiNote 思路：
     * 1.我们这样去想问题
     * 2.我们只要一次遍历，遍历的同时更新目前能够走的最远的距离s
     * 3.只要当前走的位置比这个能够走的最远距离还要大的话，是不是就说明走不到了？
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static boolean canJumpV2(int[] nums) {
        //能够走的最远距离
        int s = 0;
        for (int curIndex = 0; curIndex < nums.length; curIndex++) {
            //如果当前能够跳的最远距离无法到达当前位置，那就跳不到了
            if (s < curIndex) {
                return false;
            }
            //更新当前能够跳的最远距离
            s = Math.max(s, curIndex + nums[curIndex]);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
    }
}
