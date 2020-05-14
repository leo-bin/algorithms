package com.bins.bishi.bianlifeng;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/10 17:56
 * @apiNote
 */
public class code1 {

    /**
     * 题目描述：
     * 1.已知包含 n 个元素的整数数组（可能包含负数），设计算法找出一个连续子序列 A(i)...A(j)，使其元素之和最大。
     * <p>
     * 输入
     * 包含 n 个元素的数组A(1)...A(n)
     * <p>
     * 输出
     * 子序列的最大和
     * <p>
     * 样例输入
     * -2,11,-4,13,-5,2
     * 样例输出
     * 20
     *
     * @apiNote 思路：
     * 1.dp
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        //鲁棒
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        //最大子序列的和
        int max = 0;
        //1.dp数组
        int[] dp = new int[len];
        //2.初始化dp数组
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            //3.取最大值最为dp中的数据
            dp[i] = Math.max((dp[i - 1] + nums[i]), nums[i]);
            //保存最大值
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(maxSubArray(nums));
    }
}
