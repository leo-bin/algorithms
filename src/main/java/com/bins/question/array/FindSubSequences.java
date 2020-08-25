package com.bins.question.array;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/25 11:50
 * @apiNote 递增子序列
 * 来源：leetcode-491
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class FindSubSequences {

    /**
     * 题目描述：
     * 1.给定一个整型数组
     * 2.你的任务是找到所有该数组的递增子序列
     * 3.递增子序列的长度至少是2
     * <p>
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * <p>
     * 说明:
     * 给定数组的长度不会超过15
     * 数组中的整数范围是 [-100,100]
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况
     *
     * @apiNote 思路：
     * 1.先尝试暴力回溯
     * 2.这个题目的难点就在于如何高效的去重和高效的判断子序列是否是递增的
     * 3.首先去重，我们第一想法就是使用HashSet，将所有子序列作为String存起来
     * 4.但是很明显需要将序列转成String很耗时，不可取，我们可以另辟蹊径
     * 5.我们的目的就是判断每一个子序列是否一样罢了，可以直接对子序列求hash函数，得到一个唯一的hash值
     * 6.那么这一判断就优化到O(1)
     * 7.然后就是高效判断子序列是否递增的，这一操作其实在求子序列的时候我就可以同时去做了
     * 8.因为需要满足当前的值比上一个值要大否则就不是递增的
     */

    private static List<List<Integer>> results = new ArrayList<>();

    public static List<List<Integer>> findSubSequences(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(nums, track, 0);
        return results;
    }

    /**
     * 回溯
     */
    public static void backtrace(int[] nums, LinkedList<Integer> track, int index) {
        //递归结束条件
        if (track.size() >= 2) {
            results.add(new ArrayList<>(track));
        }
        Set<Integer> marked = new HashSet<>();
        //接着递归
        for (int i = index; i < nums.length; i++) {
            //去重,属于当前层的不进行递归
            if (marked.contains(nums[i])) {
                continue;
            }
            marked.add(nums[i]);
            //判断是否满足递增
            if (track.size() == 0 || nums[i] >= track.peekLast()) {
                track.add(nums[i]);
                backtrace(nums, track, i + 1);
                track.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        List<List<Integer>> result = findSubSequences(nums);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
