package com.bins.bishi.autumn2020.guanglianda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/22 11:54
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给出你n条长度不一的边
     * 2.请你从中选择四条边，组成一个最大的平行四边形
     * 2.请你输出最大的平行四边形的面积。
     * <p>
     * 输入描述
     * 输入第一行包含一个正整数n，表示边的数量。(4<=n<=50000)
     * 输入第二行包含n个正整数，表示n条边的长度，边的长度不会超过10^9。
     * <p>
     * 输出描述
     * 输出仅包含一个正整数，即最大的平行四边形的面积，无解则输出-1。
     * <p>
     * 样例输入
     * 5
     * 3 3 4 4 5
     * 样例输出
     * 12
     *
     * @apiNote 思路：
     * 1.
     */
    public static long code(int[] nums) {
        Arrays.sort(nums);
        int[] ab = new int[2];
        for (int i = nums.length - 1, j = 0; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                int count = 1;
                while (i > 0 && nums[i] == nums[i - 1]) {
                    count++;
                    i--;
                }
                while (count >= 2 && j < 2) {
                    ab[j++] = nums[i];
                    count -= 2;
                }
            }
            if (j >= 2) {
                return ab[0] * ab[1];
            }
        }
        return -1;
    }


    /**
     * 测试用例：
     * 输入：1 4 4 4 4 5 输出：16
     * 输入：1 4 4 5 5 6 输出：20
     * 输入：3 3 4 4 5   输出：12
     * 输入：1 4 4 5     输出：-1
     * 输入：1 4 4 4 5 5 5 输出：20
     * 输入：
     */
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
