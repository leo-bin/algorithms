package com.bins.bishi.autumn2020.kedaxunfei;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/31 13:50
 * @apiNote 提前批第二题：ac:0
 */
public class Main2 {

    /**
     * 题目描述
     * 用某种排序方法对关键字序列（25,84,21,47,15,27,68,35,20）进行排序，序列的变化情况采样如下：
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 35 27 47 68 84
     * 15 20 21 25 27 35 47 68 84
     * 15 20 21 25 27 35 47 68 84
     * <p>
     * 编程实现该排序算法
     * <p>
     * 输入描述:
     * 输入为两行，第一行为序列长度，第二行为序列内容，如：
     * 9
     * 25 84 21 47 15 27 68 35 20
     * <p>
     * 输入要求：
     * 1. 序列的长度大于等于1
     * 2. 序列内容要求为整数
     * <p>
     * 输出描述:
     * 输出为每一轮变化后的序列快照，某一轮序列处理后不变化也输出，如
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 35 27 47 68 84
     * 15 20 21 25 27 35 47 68 84
     * 15 20 21 25 27 35 47 68 84
     * <p>
     * 示例1：
     * 输入
     * 9
     * 25 84 21 47 15 27 68 35 20
     * <p>
     * 输出
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 47 27 68 35 84
     * 15 20 21 25 35 27 47 68 84
     * 15 20 21 25 27 35 47 68 84
     * 15 20 21 25 27 35 47 68 84
     *
     * @apiNote 思路：
     * 1.根据快排的思想
     * 2.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        quickSort(nums, 0, nums.length - 1);
    }


    /**
     * 快排
     */
    public static void quickSort(int[] nums, int left, int right) {
        //递归结束条件
        if (left >= right) {
            return;
        }
        int midIndex = partition(nums, left, right);
        print(nums);
        quickSort(nums, left, midIndex - 1);
        quickSort(nums, midIndex + 1, right);
    }

    /**
     * 分治找枢轴
     */
    public static int partition(int[] nums, int left, int right) {
        int midValue = nums[left];
        int midIndex = left;
        while (left < right) {
            while (left < right && nums[right] > midValue) {
                right--;
            }
            while (left < right && nums[left] <= midValue) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        //枢轴就位
        nums[midIndex] = nums[left];
        nums[left] = midValue;
        //返回枢轴
        return left;
    }


    /**
     * 打印数组
     */
    public static void print(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print(nums[nums.length - 1] + "\n");
    }

    /**
     * 交换
     */
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
