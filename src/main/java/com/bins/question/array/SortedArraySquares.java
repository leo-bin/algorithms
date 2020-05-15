package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/12 22:15
 * @apiNote 排序数组的平方
 */
public class SortedArraySquares {


    /**
     * 题目描述：
     * 1.给定一个按非递减顺序排序的整数数组 A
     * 2.返回每个数字的平方组成的新数组，要求也按非递减顺序排序
     * <p>
     * 示例 1：
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * <p>
     * 示例 2：
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     * <p>
     * 提示：
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A已按非递减顺序排序
     *
     * @apiNote 思路：
     * 1.双指针思想，一次遍历解决
     * 2.首先要知道原来的数组可能会出现负数平方之后会大于原来的整数的平方
     * 3.所以我们在比较的时候可以利用这一点，先将负号去掉，在比较（反正是平方）
     * 4.然后设两个指针left和right分别从头和尾开始扫
     * 5.满足条件就将当前元素的平方丢在新数组的最后面
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(n)
     */
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int left = 0;
        int right = len - 1;
        int current = len - 1;
        while (left <= right) {
            int leftValue = nums[left] < 0 ? -nums[left] : nums[left];
            int rightValue = nums[right] < 0 ? -nums[right] : nums[right];
            if (leftValue <= rightValue) {
                result[current--] = rightValue * rightValue;
                right--;
            } else {
                result[current--] = leftValue * leftValue;
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = sortedSquares(nums1);
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = sortedSquares(nums2);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
