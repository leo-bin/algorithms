package com.bins.question.binary;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/27 16:12
 * @apiNote 搜索旋转数组
 * 来源：leetcode-33
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotateArray {

    /**
     * 题目描述：
     * 1.假设按照升序排序的数组在预先未知的某个点上进行了旋转
     * 2.例如，数组 [0,1,2,4,5,6,7]可能变为 [4,5,6,7,0,1,2] )
     * 3.搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1
     * 4.你可以假设数组中不存在重复的元素
     * 5.你的算法时间复杂度必须是O(log n)级别
     * <p>
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * @apiNote 思路：
     * 1.先判断旋转点在mid值的左边还是右边
     * 2.如果在左边的话，接着考虑目标值是在mid值的左边还是右边，进一步缩小范围
     * 3.如果事右边的话，同样的，判断一下范围
     * 4.时间复杂度：O(logn)
     * 5.空间复杂度：O(1)
     */
    public static int findNumberInRotateArray(int[] nums, int target) {
        int low = 0, mid, high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            //1.mid直接指向目标值的话直接返回
            if (target == nums[mid]) {
                return mid;
            }
            //2.旋转点在mid值的右边
            if (nums[mid] >= nums[low]) {
                //2.1目标值在mid值的左边
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                }
                //2.2目标值在mid值的右边
                else {
                    low = mid + 1;
                }
            }
            //3.旋转点在mid值的左边
            else {
                //3.1目标值在mid的右边
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                //3.2目标值在mid值的左边
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums1 = {5, 1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4, 5};
        int target = 2;
        System.out.println("数字：" + target + "在旋转数组" + Arrays.toString(nums) + "中的位置是：" + findNumberInRotateArray(nums, target));
        System.out.println("数字：" + target + "在旋转数组" + Arrays.toString(nums1) + "中的位置是：" + findNumberInRotateArray(nums1, target));
        System.out.println("数字：" + target + "在旋转数组" + Arrays.toString(nums2) + "中的位置是：" + findNumberInRotateArray(nums2, target));
    }

}
