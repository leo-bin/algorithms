package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/4/29 22:08
 * @apiNote 山脉数组的峰顶索引
 * 来源：leetcdoe-852
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class FindPeakIndexInMountainArray {


    /**
     * 题目描述：
     * 1.我们把符合下列属性的数组 A 称作山脉
     * 2.A.length >= 3
     * 3.存在0 < i < A.length-1使得A[0]<A[1]< ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 4.给定一个确定为山脉的数组
     * 5.返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * <p>
     * 示例 1：
     * 输入：[0,1,0]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：[0,2,1,0]
     * 输出：1
     *
     * @apiNote 思路：
     * 1.二分思想
     * 2.时间复杂度：O(log(n))
     * 3.空间复杂度：O(1)
     */
    public static int peakIndexInMountArray(int[] A) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 3, 2, 1};
        int[] D = {1, 5, 4, 3, 2, 1};
        int[] E = {1, 2, 3, 4, 5, 1};
        int[] F = {1, 2, 3, 5, 3};
        System.out.println(peakIndexInMountArray(A));
        System.out.println(peakIndexInMountArray(D));
        System.out.println(peakIndexInMountArray(E));
        System.out.println(peakIndexInMountArray(F));
    }
}
