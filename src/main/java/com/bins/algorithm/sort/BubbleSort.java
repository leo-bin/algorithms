package com.bins.algorithm.sort;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/19 1:17
 * @apiNote 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @apiNote 思路：
     * 1.相邻的两个元素两两进行比较
     * 2.时间复杂度：O(n^2)
     * 3.空间复杂度：O(1)
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int temp;
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化之后冒泡排序
     *
     * @apiNote 思路：
     * 1.排序的方式和原来的不变
     * 2.但是因为原来的方法可能会出现，在最后几轮排序的时候，原来的数组已经是有序的，但是因为循环条件，必须要执行完毕
     * 3.所以我们这里设置一个标志位，判断当前数组是否已经有序
     */
    public static void bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //每次开启新的一轮比较之前都设置一个标志位，判断当前数组是否有序
            boolean isSorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                int temp;
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //有元素交换了，就说明当前数组还是无序的
                    isSorted = false;
                }
            }
            //有序直接跳出
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4, 1};
        int[] nums1 = {3, 2, 5, 4, 1};
        bubbleSort(nums);
        bubbleSort2(nums1);
        System.out.println("冒泡排序之后的数组为：" + Arrays.toString(nums));
        System.out.println("经过优化之后的冒泡排序之后的数组为：" + Arrays.toString(nums1));
    }
}
