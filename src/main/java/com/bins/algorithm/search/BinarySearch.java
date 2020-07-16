package com.bins.algorithm.search;

/**
 * @author leo-bin
 * @date 2020/3/19 12:04
 * @apiNote 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @apiNote 思路：
     * 1.设置三个指针left和right以及mid
     * 2.每次都让目标值和和mid值进行比较，判断是大于还是小于
     * 3.大于说明目标值应该在mid值的右边
     * 4.小于说明在左边
     * 5.二分查找的前提条件是目标数组是有序的
     * 6.时间复杂度是：O(log(n))
     * 7.空间复杂度是：O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        //特判
        if (nums.length < 1) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums1 = {1};
        int[] nums2 = {3};
        int[] nums3 = {};
        int target = 3;
        int result1 = binarySearch(nums, target);
        int result2 = binarySearch(nums1, target);
        int result3 = binarySearch(nums2, target);
        int result4 = binarySearch(nums3, target);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result1);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result2);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result3);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result4);
    }
}
