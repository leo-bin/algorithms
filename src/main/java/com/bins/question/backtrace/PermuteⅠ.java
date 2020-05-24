package com.bins.question.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/5/24 9:21
 * @apiNote 全排列（不可重复的全排列）
 * 来源：leetcode-46
 * 链接：https://leetcode-cn.com/problems/permutations/
 */
public class PermuteⅠ {

    /**
     * 存放所有的可能
     */
    private static List<List<Integer>> result = new LinkedList<>();


    /**
     * 题目描述：
     * 1.全排列的问题
     * 2.给你一个不重复的数组，返回它的所有全排列的结果
     * <p>
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.典型的回溯问题，我们只要构造一棵决策树即可解决
     * 3.对于重复的路径我们通过一个list来存储走过的路
     */
    public static List<List<Integer>> permute(int[] nums) {
        //使用LinkedList存储临时路径，便于删除
        LinkedList<Integer> track = new LinkedList<>();
        permuteHelper(nums, track);
        return result;
    }


    /**
     * 回溯，生成所有排列可能
     */
    public static void permuteHelper(int[] nums, LinkedList<Integer> track) {
        //1.递归结束条件，当临时路径中存储的元素个数等于给定的元素个数
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        //2.继续递归,分别从每一个元素开始进行回溯
        for (int i = 0; i < nums.length; i++) {
            //已有的路径中不能出现重复的元素
            if (track.contains(nums[i])) {
                continue;
            }
            //加入路径中
            track.add(nums[i]);
            //接着回溯
            permuteHelper(nums, track);
            //撤销当前的元素，相等于往回走了一格
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute(nums);
        System.out.println(lists.toString());
    }
}
