package com.bins.algorithm.sort;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/26 17:19
 * @apiNote 归并排序
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @apiNote 思路：
     * 1.使用递归，不断的将原数组进行划分
     * 2.直到原数组中只有一个元素了，在调通合并的方法，将分组一一排序合并
     * 3.时间复杂度：O(n*log(n))
     * 4.稳定排序
     */
    public static int[] mergeSort(int[] target) {
        if (target.length == 1) {
            return target;
        }
        int mid = target.length / 2;
        int[] left = Arrays.copyOfRange(target, 0, mid);
        int[] right = Arrays.copyOfRange(target, mid, target.length);
        return mergeSortHelper(mergeSort(left), mergeSort(right));
    }


    /**
     * 归并两个数组，重新排序为一个新数组
     */
    public static int[] mergeSortHelper(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            //前面两个if else表示要么left数组到头了，要么right数组到头了
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
