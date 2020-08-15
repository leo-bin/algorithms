package com.bins.bishi.autumn2020.meituan.bishi2020autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/15 15:51
 * @apiNote
 */
public class Main1 {

    private static int count = 0;
    private static List<List<Integer>> result = new ArrayList<>();

    /**
     * 题目描述：
     * 小团最近对逆序数（将一个数字逐位逆序，例如1234的逆序数为4321）特别感兴趣
     * 但是又觉得普通的逆序数问题有点太乏味了。
     * 于是他想出了一个新的定义：如果一个数的4倍恰好是它的逆序数，那么称这两个数是新定义下的逆序对。
     * 接下来给定一正整数n，问：不超过n的正整数中有多少对新定义下的逆序对？
     * <p>
     * 输入描述
     * 单组输入,输入一个正整数n，n<1e7。
     * <p>
     * 输出描述
     * 第一行输出在不超过n的前提下有多少对逆序数，接下来每一行输出一对逆序数，以空格分隔。
     * 如果有多组逆序数，按照第一个数升序输出
     * 如果没有一对逆序数则直接输出0即可
     * <p>
     * 样例输入
     * 10000
     * <p>
     * 样例输出
     * 1
     * 2178 8712
     * <p>
     * 提示
     * 在本题目的情景中我们认为：1234的逆序数为4321，1100的逆序数为11
     *
     * @apiNote 思路：
     * 1.既需要考虑逆序数同时要考虑题目的限制条件：4倍
     * 2.这里先用暴力回溯试下
     * 3.ok,a了
     */
    public static void code(int n) {
        boolean[] nums = new boolean[n];
        for (int i = 1; i <= n; i++) {
            backtrace(n, i, nums);
        }
    }


    /**
     * 回溯
     */
    public static void backtrace(int n, int number, boolean[] nums) {
        //递归结束条件
        long newNumber = check(number);
        if (newNumber > n) {
            return;
        }
        if (newNumber == number * 4 && !nums[number - 1]) {
            count++;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            list.add((int) newNumber);
            result.add(list);
        }
    }

    /**
     * 求新逆序数
     */
    public static long check(int target) {
        long result = 0;
        while (target > 0) {
            result = result * 10 + target % 10;
            target = target / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        code(n);
        System.out.println(count);
        if (result.size() >= 1) {
            for (List<Integer> list : result) {
                System.out.println(list.get(0) + " " + list.get(1));
            }
        }
    }
}
