package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/6 12:13
 * @apiNote 数组中不存在的最小正整数
 */
public class NotExistMinNumber {


    /**
     * 题目描述：
     * 1.求一个数组中不存在的最小正整数
     * 2.输入：{2，5，3}
     * 3.输出：1
     * 注意：
     * 1.0不属于正数也不是负数
     * 2.所以最小的正整数是1
     *
     * @apiNote 思路
     * 1.采用先排序，然后判断第一个元素是否是1
     * 2.如果不是1的话，直接返回1
     * 3.如果是1的话，那就遍历一次数组，从第一个元素开始+1和相邻的元素比较，如果不相等则返回+1之后的元素
     * 4.如果相等，继续+1比较
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static int getMinNumber(int[] nums) {
        //鲁棒性
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] != 1 ? 1 : nums[0] + 1;
        }
        Arrays.sort(nums);
        //不为1，直接返回1
        if (nums[0] != 1) {
            return 1;
        } else {
            //为1，遍历数组，不断+1和相邻的元素比较
            for (int i = 0; i < nums.length - 1; i++) {
                if ((nums[i] + 1) != nums[i + 1]) {
                    return nums[i] + 1;
                }
            }
        }
        return -1;
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
