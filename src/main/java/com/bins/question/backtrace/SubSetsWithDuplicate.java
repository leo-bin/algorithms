package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/7/17 11:29
 * @apiNote 子集 Ⅱ
 * 来源：leetcode-90
 * 链接：https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubSetsWithDuplicate {

    /**
     * 题目描述：
     * 1.给定一个可能包含重复元素的整数数组 nums
     * 2.返回该数组所有可能的子集（幂集）
     * 3.解集不能包含重复的子集
     * <p>
     * 示例:
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     *
     * @apiNote 思路：
     * 1.暴力回溯+剪枝+去重
     */
    public static List<List<Integer>> subSetsWithDuplicate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(result, nums, track, 0);
        return result;
    }


    /**
     * 回溯
     */
    public static void backtrace(List<List<Integer>> result, int[] nums, LinkedList<Integer> track, int index) {
        result.add(new LinkedList<>(track));
        for (int i = index; i < nums.length; i++) {
            //剪枝，重复的元素不能重复使用
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrace(result, nums, track, i + 1);
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subSetsWithDuplicate(nums);
        System.out.println(result.toString());
    }
}
