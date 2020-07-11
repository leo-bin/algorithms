package com.bins.question.dp;


/**
 * @author leo-bin
 * @date 2020/4/11 10:46
 * @apiNote 连续子数组的最大和
 */
public class GreatestSumOfSubArray {

    /**
     * 题目描述：
     * 1.HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学
     * 2.今天测试组开完会后,他又发话了:
     * 3.在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决
     * 4.但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 5.例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
     * 6.给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     *
     * @apiNote 思路：
     * 1.dp
     * 2.dp[0]=0
     * 3.dp[i]=Max((dp[i-1]+array[i-1]),array[i-1])
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        //鲁棒
        if (array.length == 0) {
            return 0;
        }
        //1.定义dp数组
        int[] dp = new int[array.length + 1];
        //2.初始化dp
        dp[0] = 0;
        //3.根据状态方程打表
        //注意这里使用整形的最小值作为max的初始值，因为需要考虑到全都是负数的情况
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max((dp[i - 1] + array[i - 1]), array[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        int[] array1 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] array2 = {-2, -8, -1, -5, -9};
        int[] array3 = {-1, -2};
        System.out.println(findGreatestSumOfSubArray(array));
        System.out.println(findGreatestSumOfSubArray(array1));
        System.out.println(findGreatestSumOfSubArray(array2));
        System.out.println(findGreatestSumOfSubArray(array3));
    }
}
