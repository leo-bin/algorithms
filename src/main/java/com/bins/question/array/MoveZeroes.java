package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/5/19 11:37
 * @apiNote 移动零
 * 来源：leetcode-283
 * 链接：https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    /**
     * 题目描述：
     * 1.给定一个数组 nums
     * 2.编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序
     * <p>
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 说明:
     * 1.必须在原数组上操作，不能拷贝额外的数组。
     * 2.尽量减少操作次数
     *
     * @apiNote 思路：
     * 1.双指针思想
     * 2.i指向0，j指向非0的数
     * 3.同时遍历，只有当j指向的元素！=0时，开始交换
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                //交换
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
