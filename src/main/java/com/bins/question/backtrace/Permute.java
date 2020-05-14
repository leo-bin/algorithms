package com.bins.question.backtrace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/22 15:50
 * @apiNote 全排列问题
 */
public class Permute {

    /**
     * 存放所有的可能
     */
    private static List<List<Integer>> result = new LinkedList<>();

    private static HashSet<String> set = new HashSet<>();


    /**
     * 题目描述：
     * 1.全排列的问题
     * 2.给你一个不重复的数组，返回它的所有全排列的结果
     *
     * @apiNote 思路：
     * 1.回溯
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
            //撤销标记
        }
    }


    /**
     * 可去重的，并且有重复的全排列
     */
    public static HashSet<String> permuteV2(String[] strs) {
        LinkedList<String> track = new LinkedList<>();
        boolean[] flag = new boolean[strs.length];
        permuteHelperV2(strs, track, flag);
        return set;
    }

    /**
     * 回溯
     */
    public static void permuteHelperV2(String[] strs, LinkedList<String> track, boolean[] flag) {
        //递归结束条件
        if (track.size() == strs.length) {
            LinkedList<String> tmp = new LinkedList<>(track);
            set.add(tmp.toString().replaceAll(",", "").replaceAll(" ", ""));
        }
        //回溯
        for (int i = 0; i < strs.length; i++) {
            //已经使用过的元素不能重复使用
            if (!flag[i]) {
                flag[i] = true;
                track.add(strs[i]);
                permuteHelperV2(strs, track, flag);
                track.removeLast();
                flag[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        String[] strs = {"1", "1", "2"};
        List<List<Integer>> lists = permute(nums);
        HashSet<String> set = permuteV2(strs);
        System.out.println(lists.toString());
        System.out.println(set.toString());
    }
}
