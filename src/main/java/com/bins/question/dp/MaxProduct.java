package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/5/18 9:28
 * @apiNote 乘积最大子数组
 * 来源：leetcode-152
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {


    /**
     * 题目描述：
     * 1.给你一个整数数组 nums
     * 2.请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）
     * 3.并返回该子数组所对应的乘积
     * <p>
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6
     * <p>
     * 示例 2:
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组
     *
     * @apiNote 思路：
     * 1.dp
     * 2.定义dp[len+1]数组
     * 3.设，dp[i]中的i为原数组中的前i个数，则dp[i]就是由前i个数组成的序列的乘积最大值
     * 4.并且令dp[0]=1
     * 5.我们可以写出状态方程,其中i从1开始
     * 6.dp[i]=max(dp[i-1]*nums[i-1],nums[i-1])
     * 7.但是这个题目有点坑，因为你通不过这样的用例：{-2，3，-4}
     * 8.也就是说负数和负数相乘可能结果会比正数和正数相乘要大！
     * 9.所以这里我们需要记录下当前子数组的最大值和最小值记位curMax和curMin
     * 10.一旦出现当前的值是负数的话，我们只需要交换下curMax和curMin就行
     * 11.最后只需要求curMax和max的最大值就行，因为curMin本质上只是一个标记位而已
     * 12.因为就是要考虑到负数和负数相乘的结果可能会比正数相乘要大！
     * 13.时间复杂度：O(n)
     * 14.空间复杂度：O(1)
     */
    public static int maxProduct(int[] nums) {
        //鲁棒
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //分别设两个变量来保存当前子树组的最大值和最小值
        int curMax = 1;
        int curMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                //交换当前的最大值最小值和
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }



    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 = {-2, 3, -4};
        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
    }
}
