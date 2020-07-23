package com.bins.bishi.autumn2020.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/22 11:54
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.有一种排序算法定义如下
     * 2.该排序算法每次只能把一个元素提到序列的开头
     * 3.例如2，1，3，4
     * 4.只需要一次操作把1提到序列起始位置就可以使得原序列从小到大有序
     * 5.现在给你个乱序的1-n的排列，请你计算最少需要多少次操作才可以使得原序列从小到大有序。
     * <p>
     * 输入描述
     * 输入第一行包含一个正整数n ，表示序列的长度。(1<=n<=100000)
     * 接下来一行有n个正整数，表示序列中的n个元素，中间用空格隔开。(1<=a_i<=n)
     * <p>
     * 输出描述
     * 输出仅包含一个整数，表示最少的操作次数
     * <p>
     * 样例输入
     * 4
     * 2 1 3 4
     * 样例输出
     * 1
     *
     * @apiNote 思路：
     * 1.唉，当时时间快到了，暴力都没去想了，昨天复盘的时候有自暴自弃
     * 2.今天看了别人的题解，竟然需要用贪心
     * 3.思路就是再开一个数组，然后对这个数组排序
     * 4.然后从尾到头开始遍历这两个数组
     * 5.遇到相同的元素说明原位置不需要移动
     * 6.但是不相同的话就需要移动原位置，但是这个时候是不需要移动排序数组的
     * 7.我们只需要记录不相同的个数就行
     */
    public static int code(int[] nums) {
        int[] sortNums = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sortNums);
        int count = 0;
        for (int i = nums.length - 1, j = nums.length - 1; i >= 0 && j >= 0; i--) {
            if (nums[i] != sortNums[j]) {
                count++;
            } else {
                j--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(code(nums));
    }
}
