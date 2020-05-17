package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/5/17 21:58
 * @apiNote 删除排序数组中的重复数字
 * 来源：leetcode-26
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicate {


    /**
     * 题目描述：
     * 1.给定一个排序数组，你需要在原地删除重复出现的元素
     * 2.使得每个元素只出现一次，返回移除后数组的新长度
     * 3.不要使用额外的数组空间
     * 4.你必须在原地修改输入数组,并在使用O(1)额外空间的条件下完成
     * <p>
     * 示例 1:
     * 给定数组 nums = [1,1,2]
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4]
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
     * 你不需要考虑数组中超出新长度后面的元素
     *
     * @apiNote 思路：
     * 1.
     */
    public static int removeDuplicate(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1, 1, 2};
        System.out.println(removeDuplicate(nums1));
        System.out.println(Arrays.toString(nums1));

        System.out.println(removeDuplicate(nums2));
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 1, 1, 2};
        System.out.println(removeDuplicate(nums3));
        System.out.println(Arrays.toString(nums3));

    }
}
