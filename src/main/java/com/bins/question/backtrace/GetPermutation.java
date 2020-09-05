package com.bins.question.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/9/5 10:18
 * @apiNote 第K个排列
 * 来源：leetcode-60
 * 链接：https://leetcode-cn.com/problems/permutation-sequence/
 */
public class GetPermutation {

    /**
     * 题目描述：
     * 1.给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 2.按大小顺序列出所有排列情况，并一一标记
     * 3.当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * <p>
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * <p>
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     *
     * @apiNote 思路：
     * 1.暴力回溯+剪枝
     * 2.能够但是比较慢
     */
    private static int count = 0;
    private static String result;

    public static String getPermutation(int n, int k) {
        boolean[] marked = new boolean[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrace(nums, k, new StringBuilder(), marked);
        return result;
    }

    /**
     * 回溯
     */
    public static void backtrace(int[] nums, int k, StringBuilder builder, boolean[] marked) {
        //递归结束条件
        if (builder.length() == nums.length) {
            count++;
            if (count == k) {
                result = builder.toString();
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            builder.append(nums[i]);
            backtrace(nums, k, builder, marked);
            builder.deleteCharAt(builder.length() - 1);
            marked[i] = false;
        }
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.之前的做法虽然适当的剪了枝，但是毕竟还是暴力，效率比较低
     * 2.这里看了评论中别人的做法，可以采用贪心的解法
     * 3.我们毕竟只需要知道第k个排列即可
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(n)
     */
    public static String getPermutationV2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            //重新定位k
            k -= index * factorials[i];
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k));
    }
}
