package com.bins.question.array;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/5/15 14:55
 * @apiNote 优美子数组的个数
 * 来源：leetcode-1248
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 */
public class NumberOfSubArrays {


    /**
     * 题目描述：
     * 1.整数数组 nums 和一个整数 k
     * 2.如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」
     * 3.请返回这个数组中「优美子数组」的数目。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * <p>
     * 示例 2：
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * <p>
     * 示例 3：
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     * <p>
     * 提示：
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     *
     * @apiNote 思路：
     * 1.前缀和+哈希表
     * 2.我们可以将题目抽象一下
     * 3.可以发现我们只要将所有可能的子数组中的奇数个数作为前缀和
     * 4.然后某个子数组中的奇数个数就等于当前的前缀和-之前的某个存在的前缀和
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int numberOfSubArrays(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int count = 0;
        int oddCount = 0;
        //key：某个子数组中奇数的个数   value：该key出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        for (int n : nums) {
            //统计奇数出现的次数
            oddCount = oddCount + ((n & 1) == 1 ? 1 : 0);
            //出现匹配的就统计count
            if (map.containsKey(oddCount - k)) {
                count += map.get(oddCount - k);
            }
            //更新oddCount在map出现的次数
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(numberOfSubArrays(nums1, k1));

        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println(numberOfSubArrays(nums2, k2));

        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println(numberOfSubArrays(nums3, k3));
    }
}
