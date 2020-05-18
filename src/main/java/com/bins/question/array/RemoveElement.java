package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/5/18 23:53
 * @apiNote 移除元素
 * 来源：leetcode-27
 * 链接：https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {


    /**
     * 题目描述：
     * 1.给你一个数组 nums 和一个值 val
     * 2.你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新长度
     * 3.不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组
     * 4.元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
     * <p>
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素
     *
     * @apiNote 思路：
     * 1.类似于双指针的思想
     * 2.对于这种变态的空间复杂度的要求，而且还是数组的删除
     * 3.那么我们首先就要想到元素之间的覆盖！
     * 4.而且题目额外规定，新数组的序列可以是任意的！
     * 5.那么问题就好办了
     * 6.我们只需要设定一个i指针从前面往后面扫，专门找和val相等的值
     * 7.设定一个j指针从后往前扫，专门找不是val的值。
     * 8.同时进行，当找到一个nums[i]=val时,只需要让nums[j]覆盖掉nums[i]就行(记住是覆盖不是交换！)
     * 9.每找到一个nums[i]==val,计数一次，记为count
     * 10.最后新数组的长度就等于nums.length-count
     * 11.时间复杂度：O(n)
     * 12.空间复杂度：O(1)
     */
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++) {
            while (j >= 0 && nums[j] == val) {
                j--;
            }
            if (nums[i] == val) {
                //j>=0防止越界
                nums[i] = j >= 0 ? nums[j] : nums[i];
                count++;
                j--;
            }
        }
        return nums.length - count;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        System.out.println(removeElement(nums1, val1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(removeElement(nums2, val2));
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {3, 3, 3};
        int val3 = 3;
        System.out.println(removeElement(nums3, val3));
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {3, 1, 3, 3, 3};
        int val4 = 3;
        System.out.println(removeElement(nums4, val4));
        System.out.println(Arrays.toString(nums4));
    }
}
