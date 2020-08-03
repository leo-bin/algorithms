package com.bins.question.dp;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/2 11:53
 * @apiNote 分割等和子集
 * 来源：leetcode-416
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {

    private static boolean result = false;

    /**
     * 题目描述：
     * 1.给定一个只包含正整数的非空数组
     * 2.是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
     * <p>
     * 注意:
     * 1.每个数组中的元素不会超过 100
     * 2.数组的大小不会超过 200
     * <p>
     * 示例 1:
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11]
     * <p>
     * 示例 2:
     * 输入: [1, 2, 3, 5]
     * 输出: false
     * 解释: 数组不能分割成两个元素和相等的子集
     *
     * @apiNote 思路：
     * 1.这个题目有个隐藏的条件就是我们求的是两个子集的和
     * 2.但是其实两个子集的元素和加一块就是整个数组的和sum
     * 3.所以我们可以提前算出两个集合的元素和等于：target=sum/2(sum是所有元素之和)
     * 4.很明显，要想target合法，target也应该是一个正整数，所以sum必须要是偶数！
     * 5.现在题目就能够转换为：求是否有元素的组合之和等于target
     * 6.我们先考虑暴力解法，这里使用回溯+剪枝优化
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //特判
        if ((sum & 1) == 1) {
            return false;
        }
        Arrays.sort(nums);
        backtrace(nums, sum / 2, 0, 0);
        return result;
    }

    /**
     * 回溯
     *
     * @apiNote 思路：
     * 1.这里需要注意一下，我们并没有使用一个track容器来对每次的计算结果进行记录
     * 2.只是用了一个int变量来表示，不会有问题吗？
     * 3.当然不会！int是基本数据类型，传递参数时会自动复制变量值，没有引用的关系
     */
    public static void backtrace(int[] nums, int target, int currentSum, int index) {
        //递归结束条件
        if (result) {
            return;
        }
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result = true;
            return;
        }
        //接着递归
        for (int i = index; i < nums.length; i++) {
            //剪枝优化，并且去重
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            backtrace(nums, target, currentSum + nums[i], i + 1);
        }
    }

    /**
     * 解法二，dp
     *
     * @apiNote 思路：
     * 1.这个题目其实有点像01背包问题
     * 2.我们背包的容量就是sum/2
     * 3.我们现在就是要找是否有组合能够刚好装满背包的容量
     * 4.我们要考虑依旧是放还是不放当前的元素
     * 5.如果放,那我们就要考虑不放当前元素时的总和加上当前元素之后是否等于目标之和
     * 6.如果不放，那就要考虑不放当前元素时的总和是否等于目标值和
     * 7.所以我们的方程就等于：dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]]
     * 8.时间复杂度：O(n*n)
     * 9.空间复杂度：O(n*n)
     */
    public static boolean canPartitionV2(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i-1] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 11, 5, 5};
        System.out.println(canPartition(nums1));

        int[] nums2 = {1, 11, 5, 5};
        System.out.println(canPartitionV2(nums2));
    }
}
