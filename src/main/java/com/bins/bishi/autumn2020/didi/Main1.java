package com.bins.bishi.autumn2020.didi;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author leo-bin
 * @date 2020/8/21 17:53
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * A+B问题又来了
     * 设a，b，c是0到9之间的整数（其中a，b，c互不相同）
     * 其中abc和acc是两个不同的三位数，现给定一正整数n
     * 问有多少对abc和acc能满足abc+acc=n（a≠0）
     * <p>
     * 输入描述
     * 一个正整数n（100<n<2000）。
     * <p>
     * 输出描述
     * 第一行输出有多少对满足要求的数字。
     * <p>
     * 接下来每一行输出一对abc和acc，以空格分隔。
     * 如果没有一对abc和acc的话，则直接输出0即可。
     * 如果有多对，请按照abc升序的次序输出。
     * <p>
     * 样例输入
     * 1068
     * 样例输出
     * 1
     * 524 544
     *
     * @apiNote 思路：
     * 1.回溯
     */
    private static int count = 0;
    private static TreeMap<Integer, Integer> result = new TreeMap<>();

    /**
     * 回溯
     */
    public static void backtrace(int[] nums, int target, StringBuilder builder, boolean[] marked) {
        //递归结束条件
        if (builder.length() > 3) {
            return;
        }
        if (builder.length() == 3 && check(target, builder)) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) {
                continue;
            }
            marked[i] = true;
            builder.append(nums[i]);
            backtrace(nums, target, builder, marked);
            builder.deleteCharAt(builder.length() - 1);
            marked[i] = false;
        }
    }

    /**
     * 校验是否相等
     */
    public static boolean check(int target, StringBuilder builder) {
        char[] chs = builder.toString().toCharArray();
        int abc = (chs[0] - '0') * 100 + (chs[1] - '0') * 10 + (chs[2] - '0');
        int acc = (chs[0] - '0') * 100 + (chs[2] - '0') * 10 + (chs[2] - '0');
        if (abc + acc == target) {
            result.put(abc, acc);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean[] marked = new boolean[10];
        backtrace(nums, n, new StringBuilder(), marked);
        System.out.println(count);
        for (Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
