package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/7/17 10:15
 * @apiNote 子集
 * 来源：leetcode-78
 * 链接：https://leetcode-cn.com/problems/subsets/
 */
public class SubSets {

    /**
     * 题目描述：
     * 1.给定一组不含重复元素的整数数组 nums
     * 2.返回该数组所有可能的子集（幂集）
     * 3.说明：解集不能包含重复的子集
     * <p>
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     *
     * @apiNote 思路：
     * 1.暴力回溯+剪枝+去重
     * 2.这题和之前写的思路基本一样，直接回溯干完事了。
     */
    public static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(result, nums, track, 0);
        return result;
    }


    /**
     * 回溯
     */
    public static void backtrace(List<List<Integer>> result, int[] nums, LinkedList<Integer> track, int index) {
        //递归结束条件
        result.add(new LinkedList<>(track));
        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            backtrace(result, nums, track, i + 1);
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subSets(nums);
        System.out.println(result.toString());
    }
}
