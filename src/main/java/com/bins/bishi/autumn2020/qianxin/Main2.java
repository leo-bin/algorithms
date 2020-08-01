package com.bins.bishi.autumn2020.qianxin;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 15:28
 * @apiNote ac:100%
 */
public class Main2 {

    private static int count = 0;

    /**
     * 题目描述
     * 1.如果一个正整数可以被7整除，我们称之为亲7数
     * 2.对于给出的一组个位数字，请找出使用所有的数字排列出的数中的亲7数的个数。
     * 3.其中给出的个位数字数组中每一个都是不相关的，即使有重复的数字
     * 4.如{1，1，2}排列出的数为{112，121，112，121，211，211}， 亲7数为{112，112}共2个。
     * <p>
     * 输入：个位数字数组，数组有m个元素[x1,x2,x3,...xm]( 0<=xi<=9)
     * 输出：亲7数个数
     * <p>
     * 示例1:
     * 输入
     * [1,1,2]
     * <p>
     * 输出
     * 2
     *
     * @apiNote 思路：
     * 1.暴力+回溯
     * 2.剪枝优化
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] newS = s.replace("[", "").replace("]", "").split(",");
        int[] nums = new int[newS.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(newS[i]);
        }
        System.out.println(code(nums));
    }


    public static int code(int[] digit) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] flag = new boolean[digit.length];
        backtrace(digit, digit.length, track, flag);
        return count;
    }

    /**
     * 回溯
     *
     * @param nums  元素数组
     * @param size  元素个数
     * @param track 记录list
     * @param flag  元素标记
     */
    public static void backtrace(int[] nums, int size, LinkedList<Integer> track, boolean[] flag) {
        //递归结束条件
        if (track.size() == size && check(track)) {
            count++;
        }
        //开始遍历元素
        for (int i = 0; i < size; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            track.add(nums[i]);
            backtrace(nums, size, track, flag);
            track.pollLast();
            flag[i] = false;
        }
    }

    /**
     * 判断是否是亲7数
     */
    public static boolean check(LinkedList<Integer> list) {
        StringBuilder s = new StringBuilder();
        for (int i : list) {
            s.append(i);
        }
        int n = Integer.parseInt(s.toString());
        return n % 7 == 0;
    }
}
