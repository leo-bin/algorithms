package com.bins.bishi.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/3/31 17:04
 * @apiNote 2020-03-30笔试题（阿里校招）
 */
public class HowManyChicken {


    /**
     * 题目描述：
     * 1.小强有n个养鸡场，第i个养鸡场初始有a[i]只小鸡。
     * 2.与其他养鸡场不同的是，他的养鸡场每天增加k只小鸡，小强每天结束都会在数量最多的养鸡场里卖掉一半的小鸡
     * 3.假如一个养鸡场有x只鸡，则卖出后只剩下x/2(向下取整)只鸡。
     * 4.问m天后小强的n个养鸡场一共多少只小鸡？
     * <p>
     * 输入
     * 1.第一行输入三个int类型n,m,k（1 <= n,m,k <= 10^6）
     * 2.第二行输入n个正整数，表示n个养鸡场初始鸡的个数
     * <p>
     * 输出
     * 输出一个整数表示鸡的总数
     * <p>
     * 示例：
     * 输入：
     * 3 3 100
     * 100 200 400
     * <p>
     * 输出：
     * 925
     *
     * @apiNote 思路：
     * 1.暴力解法，一般来说都是超时，需要优化
     * 2.时间复杂度为：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static long howManyChicken(int n, int m, int k, int[] nums) {
        long result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[j] += k;
            }
            nums[n - 1] = nums[n - 1] / 2;
            Arrays.sort(nums);
        }
        for (int i = 0; i < n; i++) {
            result += nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(howManyChicken(n, m, k, nums));
    }
}
