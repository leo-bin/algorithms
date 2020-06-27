package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/6 12:13
 * @apiNote 数组中不存在的最小正整数
 * 来源：leetcode-41
 * 链接：https://leetcode-cn.com/problems/first-missing-positive/
 */
public class NotExistMinNumber {

    /**
     * 题目描述：
     * 1.给你一个未排序的整数数组
     * 2.请你找出其中没有出现的最小的正整数。
     * <p>
     * 示例 1:
     * 输入: [1,2,0]
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: [3,4,-1,1]
     * 输出: 2
     * <p>
     * 示例 3:
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * <p>
     * 注意：
     * 1.0不属于正数也不是负数
     * 2.所以最小的正整数是1
     *
     * @apiNote 思路
     * 1.采用先排序，然后判断第一个元素是否是1
     * 2.如果不是1的话，直接返回1
     * 3.如果是1的话，那就遍历一次数组，从第一个元素开始+1和相邻的元素比较，如果不相等则返回+1之后的元素
     * 4.如果相等，继续+1比较
     * 5.时间复杂度：O(n*log(n))
     * 6.空间复杂度：O(n)
     */
    public static int getMinNumber(int[] nums) {
        //鲁棒性
        if (nums.length == 0) {
            return 1;
        }
        //提前过滤掉小于0的数字
        int[] newNums = Arrays.stream(nums).distinct().filter(e -> e > 0).toArray();
        //排序
        Arrays.sort(newNums);
        int base = 1;
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] != base) {
                return base;
            }
            base++;
        }
        return base;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.既然题目要求我们不采用额外的空间，那我们就只好使用原来的数组当作额外的空间
     * 2.这里使用一种就叫做原地hash的方式来做
     * 3.假设数组为：[3,4,-1,1]下标为：[0,1,2,3]
     * 4.我们只需要将原数组进行一个重组，就是将数值为i的元素映射到数组下标为i-1的位置
     * 5.之后，我只要一次遍历数组，判断当前的数是否等于当前的下标+1，如果不相等，说明这里缺数字了！
     * 6.比较难想到以及理解的是如何确定映射关系和越界条件
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(1)
     */
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //1.重组原数组，构造一个哈希表
        for (int i = 0; i < len; i++) {
            //当前值满足越界条件并且没有在指定位置，那就交换！直到当前位置正确为止
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //2.查找第一个不在对应位置的元素
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    /**
     * 交换数组中的两个元素的位置
     */
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        int[] nums = {1, 5};
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {5, 6, 7};
        int[] nums3 = {2, 3, 5};
        System.out.println(getMinNumber(nums));
        System.out.println(getMinNumber(nums1));
        System.out.println(getMinNumber(nums2));
        System.out.println(getMinNumber(nums3));
    }
}
