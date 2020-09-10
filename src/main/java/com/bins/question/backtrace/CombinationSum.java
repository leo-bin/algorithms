package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/7/16 9:53
 * @apiNote 组合总数
 * 来源：leetcode-39
 * 链接：https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

    /**
     * 题目描述：
     * 1.给定一个无重复元素的数组 candidates 和一个目标数 target
     * 2.找出 candidates 中所有可以使数字和为 target 的组合
     * 3.candidates 中的数字可以无限制重复被选取
     * 4.所有数字（包括 target）都是正整数
     * 5.解集不能包含重复的组合
     * <p>
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     * <p>
     * 示例 2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     *
     * @apiNote 思路：
     * 1.暴力回溯+剪枝+去重
     * 2.这个题目的关键就是去重！
     * 3.虽然题目说了，可以使用同一个元素无限次，但是需考虑到元素的使用顺序！
     * 4.这里通过将每次递归到的索引传给下一次递归。
     * 5.这样就能保证下一次递归无法使用之前已经用过的元素！
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        //通过一次排序进行剪枝，提高搜索速度
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
            track.add(candidates[i]);
            //将当前递归索引一并传过去，使得下次递归使用的元素中不会出现之前使用过的元素
            backtrace(result, candidates, target, curSum + candidates[i], track, i);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result.toString());
    }
}
