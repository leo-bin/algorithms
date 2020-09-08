package com.bins.question.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/8 16:23
 * @apiNote 组合
 * 来源：leetcode-77
 * 链接：https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    /**
     * 题目描述：
     * 1.给定两个整数 n 和 k
     * 2.返回 1 ... n 中所有可能的k个数的组合
     * <p>
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @apiNote 思路：
     * 1.回溯
     */

    private static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        //特判
        if (n < k) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(n, k, 1, track);
        return result;
    }

    /**
     * 回溯
     */
    public static void backtrace(int n, int k, int index, LinkedList<Integer> track) {
        //递归结束条件
        if (track.size() == k) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i <= n; i++) {
            track.add(i);
            backtrace(n, k, i + 1, track);
            track.pollLast();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
