package com.bins.question.binary;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/7/14 12:17
 * @apiNote 在排序数组中查找元素的第一个和最后一个位置
 * 来源：leetcode-34
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    /**
     * 题目描述：
     * 1.给定一个按照升序排列的整数数组 nums，和一个目标值 target
     * 2.找出给定目标值在数组中的开始位置和结束位置
     * 3.你的算法时间复杂度必须是 O(log n) 级别
     * 4.如果数组中不存在目标值，返回 [-1, -1]
     * <p>
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * <p>
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     *
     * @apiNote 思路：
     * 1.首先看这个时间复杂度，想都不用想就知道只能用二分了
     * 2.这里根据二分查找的思想写一个变种的二分模板
     * 3.根据不同的场景决定是找第一个还是最后一个
     * 4.时间复杂度：O(log(n))
     * 5.空间复杂度：O(1)
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int firstIndex = binarySearchByType(nums, target, -1);
        int lastIndex = binarySearchByType(nums, target, 1);
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }

    /**
     * 根据不同的type决定是查找第一个还是最后一个,type为0找第一个，为1找最后一个
     */
    public static int binarySearchByType(int[] nums, int target, int type) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                while (mid >= 0 && mid < nums.length && nums[mid] == target) {
                    mid = mid + type;
                }
                return mid - type;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
