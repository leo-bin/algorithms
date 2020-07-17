package com.bins.question.binary;


/**
 * @author leo-bin
 * @date 2020/4/29 19:20
 * @apiNote 在山脉数组中查找目标值
 * 来源：leetcode-1095
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array/
 */
public class FindInMountainArray {


    /**
     * This is MountainArray's API interface.
     * You should not implement it, or speculate about its implementation
     */
    interface MountainArray {
        public int get(int index);

        public int length();
    }


    /**
     * 题目描述：
     * 1.给你一个山脉数组mountainArr
     * 2.请你返回能够使得mountainArr.get(index)等于target最小的下标 index值
     * 3.如果不存在这样的下标 index，就请返回 -1
     * 4.何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
     * 5.首先，A.length >= 3
     * 6.其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     * 7.你将不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
     * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
     * MountainArray.length() - 会返回该数组的长度
     * <p>
     * 注意：
     * 1.对MountainArray.get发起超过100次调用的提交将被视为错误答案
     * 2.此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消
     * <p>
     * 示例 1：
     * 输入：array = [1,2,3,4,5,3,1], target = 3
     * 输出：2
     * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
     * <p>
     * 示例 2：
     * 输入：array = [0,1,2,4,2,1], target = 3
     * 输出：-1
     * 解释：3 在数组中没有出现，返回 -1。
     *
     * @apiNote 思路：
     * 1.二分思想
     * 2.首先原数组可以分为一个升序数组和一个降序数组
     * 3.我们只要通过二分的思想来找到这个峰值就可以分别对升序数组和降序数组进行二分查找
     * 4.时间复杂度：O(log(n))
     * 5.空间复杂度：O(1)
     */
    public static int findInMountainArray(int target, MountainArray mountainArray) {
        int len = mountainArray.length();
        //二分思想找峰值
        int peekIndex = findPeakIndex(mountainArray);
        //分别进行二分查找
        int left = binarySearch(0, peekIndex, target, mountainArray, true);
        return left != -1 ? left : binarySearch(peekIndex + 1, len - 1, target, mountainArray, false);
    }


    /**
     * 找峰值的索引
     *
     * @apiNote 思路：
     * 1.二分思想
     */
    public static int findPeakIndex(MountainArray mountainArray) {
        int low = 0, high = mountainArray.length() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = mountainArray.get(mid);
            if (midValue > mountainArray.get(mid + 1) && midValue > mountainArray.get(mid - 1)) {
                return mid;
            } else if (midValue < mountainArray.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找模板
     *
     * @apiNote 思路：
     * 1.根据给定参数isASC来决定是升序还是降序的查找
     * 2.时间复杂度：O(log(n))
     * 3.空间复杂度：O(1)
     */
    public static int binarySearch(int low, int high, int target, MountainArray mountainArray, boolean isASC) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = mountainArray.get(mid);
            if (target == midValue) {
                return mid;
            }
            if (target > midValue) {
                //是否是升序，如果是，mid-1，不是就不变
                low = isASC ? mid + 1 : low;
                //是否是升序序，如果是，则不变，反之mid+1
                high = isASC ? high : mid - 1;
            } else {
                //同理
                high = isASC ? mid - 1 : high;
                low = isASC ? low : mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
