package com.bins.question.array;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/18 1:33
 * @apiNote 有序数组的重排序
 * 来源：leetcode-88
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeArray {


    /**
     * 题目描述：
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
     * <p>
     * 说明:
     * 1.初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 2.你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * <p>
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     * @apiNote 思路：
     * 1.使用双指针的思想，同时去遍历两个数组
     * 2.时间复杂度为：O（m+n）
     * 3.空间复杂度为：O（m）
     */
    public static void orderArrayReSort(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums1 = new int[m];
        System.arraycopy(nums1, 0, newNums1, 0, m);
        int i = 0, j = 0, z = 0;
        while (i < m || j < n) {
            //判断是否有某个数组提前遍历完，如果这个数组遍历完了，那就循环把另一个数组写入就行
            if (i == m) {
                while (j < n) {
                    nums1[z] = nums2[j];
                    z++;
                    j++;
                }
                break;
            } else if (j == n) {
                while (i < m) {
                    nums1[z] = newNums1[i];
                    z++;
                    i++;
                }
                break;
            }
            if (newNums1[i] <= nums2[j]) {
                nums1[z] = newNums1[i];
                z++;
                i++;
            } else if (newNums1[i] > nums2[j]) {
                nums1[z] = nums2[j];
                z++;
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] array2 = {2, 5, 6};
        int n = 3;
        orderArrayReSort(array1, m, array2, n);
        System.out.println("重排序的结果是：" + Arrays.toString(array1));
    }
}
