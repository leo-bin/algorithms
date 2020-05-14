package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/27 16:12
 * @apiNote 旋转数组
 */
public class RotateArray {

    /**
     * 题目描述：（旋转数组的最小值）
     * 1.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 2.输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 3.例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * 4.给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @apiNote 思路：
     * 1.二分的思想
     */
    public static int minNumberInRotateArray(int[] nums) {

        return 0;
    }


    /**
     * 在旋转数组中查找某个值
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
