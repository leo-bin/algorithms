package com.bins.question.backtrace;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/7/16 11:08
 * @apiNote 组合总数 Ⅱ
 * 来源：leetcode-40
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumⅡ {

    /**
     * 题目描述：
     * 1.给定一个数组 candidates 和一个目标数 target
     * 2.找出 candidates 中所有可以使数字和为 target 的组合
     * 3.candidates 中的每个数字在每个组合中只能使用一次
     * 4.所有数字（包括目标数）都是正整数。
     * 5.解集不能包含重复的组合
     * <p>
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * <p>
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @apiNote 思路：
     * 1.暴力回溯+剪枝+去重
     * 2.这道题和上一道是类似的题目，同样都可以使用回溯模板想到思路
     * 3.但是难就难在如何去重！之前那题通过限制其实索引来去重
     * 4.但是这里还不够，因为原数组中竟然有重复的元素出现！
     * 5.一开始我是使用set才勉强通过的，速度可想而知不咋滴
     * 6.看了评论才知道只要递归的时候判断当前元素等于上一个元素就能够直接去重了！
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrace(result, candidates, target, 0, track, 0);
        return result;
    }


    /**
     * 回溯
     */
    public static void backtrace(List<List<Integer>> result, int[] candidates, int target,
                                 int curSum, LinkedList<Integer> track, int index) {
        //递归结束条件
        if (curSum == target) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (curSum + candidates[i] > target) {
                return;
            }
            //不能使用重复元素(相当于去重)
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            backtrace(result, candidates, target, curSum + candidates[i], track, i + 1);
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result.toString());
    }
}
