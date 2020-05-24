package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/5/24 10:35
 * @apiNote 寻找两个正序数组的中位数
 * 来源：leetcode-4
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {


    /**
     * 题目描述：
     * 1.给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2
     * 2.请你找出这两个正序数组的中位数
     * 3.并且要求算法的时间复杂度为 O(log(m + n))
     * 4.你可以假设 nums1 和 nums2 不会同时为空
     * <p>
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * @apiNote 思路：
     * 1.这道题如果不看时间的限制的话可能就是一个median或者easy题
     * 2.难受就是，这个时间复杂度要求是log级别的，瞬间就变成hard题了！
     * 3.首先，忽略时间的限制，我们有可以使用暴力法
     * 4.就是将两个数组合并，然后排序一遍，求中间的数
     * 5.但是考虑到时间复杂度是log级别的，我们应该考虑二分！
     * 6.这里我们采用寻找两个排序数组中第k小的元素的方式
     * 7.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            int midIndex = totalLen / 2;
            return (double) getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLen / 2 - 1, midIndex2 = totalLen / 2;
            return (double) (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }


    /**
     * @apiNote 思路：
     * 1.要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 2.这里的 "/" 表示整除
     * 3.nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * 4.nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 5.取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 6.这样 pivot 本身最大也只能是第 k-1 小的元素
     * 7.如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 8.如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 9.由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {

    }


}
