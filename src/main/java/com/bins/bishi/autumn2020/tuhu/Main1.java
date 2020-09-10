package com.bins.bishi.autumn2020.tuhu;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/9/10 19:56
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.合并两个有序数组
     *
     * @apiNote 思路：
     * 1.暴力
     */
    public static int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        int[] newNum = new int[n + m];
        int i = 0, j = 0, index = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length) {
                while (j < array2.length) {
                    newNum[index++] = array2[j++];
                }
                break;
            }
            if (j == array2.length) {
                while (i < array1.length) {
                    newNum[index++] = array2[i++];
                }
                break;
            }
            if (array1[i] < array2[j]) {
                newNum[index++] = array1[i++];
            } else {
                newNum[index++] = array2[j++];
            }
        }
        return newNum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        int[] result = arrayMerge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(result));
    }
}
