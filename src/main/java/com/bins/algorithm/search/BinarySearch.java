package com.bins.algorithm.search;

/**
 * @author leo-bin
 * @date 2020/3/19 12:04
 * @apiNote 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找，迭代实现
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

    /**
     * 二分查找，递归实现
     *
     * @apiNote 思路：
     * 1.递归实现其实也很简单
     * 2.有点像分治法，根据比较的结果来决定像哪边进行查找
     * 3.时间复杂度：O(log(n))
     * 4.空间复杂度：O(n)
     */
    public static int binarySearchV2(int[] nums, int target, int left, int right) {
        //递归结束条件
        int mid = left + (right - left) / 2;
        if (mid > nums.length || mid < 0 || left > right) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        }
        //分别进行分治
        if (nums[mid] > target) {
            return binarySearchV2(nums, target, left, mid - 1);
        } else {
            return binarySearchV2(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums1 = {1};
        int[] nums2 = {3};
        int[] nums3 = {};
/*        int target = 3;
        int result1 = binarySearch(nums, target);
        int result2 = binarySearch(nums1, target);
        int result3 = binarySearch(nums2, target);
        int result4 = binarySearch(nums3, target);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result1);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result2);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result3);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result4);*/

        int target = 5;
        int result1 = binarySearchV2(nums, target, 0, nums.length - 1);
        int result2 = binarySearchV2(nums1, target, 0, nums.length - 1);
        int result3 = binarySearchV2(nums2, target, 0, nums.length - 1);
        int result4 = binarySearchV2(nums3, target, 0, nums.length - 1);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result1);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result2);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result3);
        System.out.println("二分查找：：元素：" + target + "在数组中的位置为" + result4);
    }
}
