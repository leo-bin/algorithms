package com.bins.question.backtrace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/22 15:50
 * @apiNote 全排列问题 Ⅱ（可重复的全排列）
 * 来源：leetcode-47
 * 链接：https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteⅡ {

    private static List<List<Integer>> result = new LinkedList<>();


    /**
     * 题目描述：
     * 1.给定一个可包含重复数字的序列
     * 2.返回所有不重复的全排列
     * <p>
     * 示例:
     * <p>
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.回溯的套路还是一样的
     * 3.但是这里加了一个boolean数组，目的就是为了解决重复的元素
     * 4.而且为了解决同样的元素重复进行排列的问题我们采用先排序然后判断是否相同的方式实现剪枝
     * 5.时间复杂度：O(n*n!)
     * 6.空间复杂度：O(n*n!)
     */
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        //去重的前提就是要先排序
        Arrays.sort(nums);
        permutehelper(nums, track, flag);
        return result;
    }


    /**
     * 回溯
     */
    public static void permutehelper(int[] nums, LinkedList<Integer> track, boolean[] flag) {
        //递归结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        //回溯
        for (int i = 0; i < nums.length; i++) {
            //剪枝并且去重
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                continue;
            }
            //已经使用过的元素不能重复使用
            if (!flag[i]) {
                flag[i] = true;
                track.add(nums[i]);
                permutehelper(nums, track, flag);
                track.removeLast();
                flag[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permute(nums);
        if (result.size() > 0) {
            System.out.println(result.toString());
        }
    }
}
