package com.bins.bishi.autumn2020.meituan.bishi2020autumn;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/15 17:35
 * @apiNote
 */
public class Main5 {

    private static long count = 0;

    /**
     * 题目描述：
     * 小团正在装饰自己的书桌，他的书桌上从左到右有m个空位需要放上装饰物
     * 商店中每个整数价格的装饰物恰好有一种，且每种装饰物的数量无限多
     * 小团去商店的时候，想到了一个购买方案，他要让右边的装饰物价格是左边的倍数
     * 用数学语言来说，假设小团的m个装饰物价格为a1,a2...am，那么对于任意的1≤i≤j≤m，aj是ai的倍数。
     * 小团是一个节约的人，他希望最贵的装饰物不超过n元
     * 现在，请你计算小团有多少种购买的方案？
     * <p>
     * 输入描述
     * 输入包含两个数，n和m（1≤n,m≤1000）
     * <p>
     * 输出描述
     * 输出一个数，结果对998244353取模，表示购买的方案数。
     * <p>
     * 样例输入
     * 4 2
     * <p>
     * 样例输出
     * 8
     * <p>
     * 样例解释
     * [1,1][1,2][1,3][1,4][2,2][2,4][3,3][4,4]共8种
     *
     * @apiNote 思路：
     * 1.暴力+回溯
     */
    public static void code(int m, int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(m, nums, track);
    }

    /**
     * 回溯
     */
    public static void backtrace(int m, int[] nums, LinkedList<Integer> track) {
        //递归结束条件
        if (track.size() > m) {
            return;
        }
        if (track.size() == m && check(track)) {
            count++;
        }
        //接着递归
        for (int i = 0; i < nums.length; i++) {
            track.add(nums[i]);
            backtrace(m, nums, track);
            track.removeLast();
        }
    }

    /**
     * 判断方案是否满足条件
     */
    public static boolean check(LinkedList<Integer> track) {
        for (int i = track.size() - 1; i > 0; i--) {
            if (track.get(i) < track.get(i - 1)) {
                return false;
            }
            if (track.get(i) % track.get(i - 1) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        code(m, nums);
        System.out.println(count);
    }
}
